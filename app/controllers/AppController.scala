package controllers

import java.text.Normalizer

import javax.inject._
import play.api.libs.json._
import play.api.mvc._
import reactivemongo.bson.BSONObjectID
import repositories.TwitRepository
import play.api.http.Status
import play.mvc.Results.status
import models.{ErrorMessage, Statu, Tag, Twit}
import reactivemongo.api.commands.WriteResult

import scala.collection.mutable.{ArrayBuffer, ListBuffer}
import scala.concurrent.{ExecutionContext, Future}
import scala.util.matching.Regex

@Singleton
class AppController @Inject()(
   implicit ec: ExecutionContext,
   cc : ControllerComponents,
   twitRepo: TwitRepository
                             ) extends AbstractController(cc) {

  def index(): Action[AnyContent] = Action { implicit request: Request[AnyContent] =>
    Ok("Welcome")
  }

  def getHealth() = Action { implicit request =>

    //db baglanti kontrolu, nasil olur cozemedim.
    val p = new Statu("ok")
    Ok(Json.toJson(p))
  }

  def getTwits(page : Int, count : Int, username : Option[String], tag : Option[String]) = Action.async {
    twitRepo.list(page, count, username, tag ).map {
      case twit => Ok(Json.toJson(twit))
      case _ => Ok(Json.toJson(ErrorMessage("Tweets not found")))
    }
  }

  def getTwit(id : BSONObjectID) = Action.async   {
    twitRepo.get(id).map {
      case Some(twit) => Ok(Json.toJson(twit))
      case _ => Ok(Json.toJson(ErrorMessage("Tweet not found")))
    }
  }

  def deleteTwit(id : BSONObjectID) = Action.async { implicit request =>
    var username = request.headers.get("x-username").getOrElse("")
    twitRepo.delete(id, username).map {
      case true => Status(204)
      case _ => Ok(Json.toJson(new ErrorMessage("Tweet not exists")))
    }
  }

  def insertTwit(): Action[AnyContent] = Action { implicit request: Request[AnyContent] =>
    //kullanici adi
    val username = request.headers.get("x-username").getOrElse("")

    //kullanici adi yoksa, hata ver
    if(username == null)
      Ok(Json.toJson(new ErrorMessage("login first")))

    val message = request.body.asJson.get("message").as[String]

    //mesaj bos ise veya 280 den uzunsa, hata ver
    if(message.trim == "" || message.length > 280)
      Ok(Json.toJson(new ErrorMessage("invalid tweet")))

    val tags = setHashTags(message)

    //twiti olustur
    var twit = Twit(BSONObjectID.generate(), username, message, Some(tags))

    twitRepo.insert(twit).map{
      case false => Ok(Json.toJson(ErrorMessage("insert tweet failed")))
    }
    Ok(Json.toJson(twit))
  }
  //bunlari object olusurken cagirmak istedim, ve beceremedim.
  //hashtagleri bul ve liste dondur.
  def setHashTags(message : String): List[Tag] = {
    var tags = ArrayBuffer[Tag]()
    val hashTagPattern: Regex = """#(\w+)""".r
    hashTagPattern.findAllMatchIn(message).foreach{ m =>
      tags += Tag(m.group(1), setSlug(m.group(1)))
    }
    tags.toList
  }

  //tag dan slug olustur.
  def setSlug(tag : String): String = {
    val slug = Normalizer.normalize(tag, Normalizer.Form.NFD)
      .replaceAll("[^\\w\\s-]", "")
      .replace('-', ' ')
      .trim
      .replaceAll("\\s+", "-")
      .toLowerCase
    slug
  }

}
