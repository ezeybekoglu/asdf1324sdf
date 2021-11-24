package repositories

import akka.http.scaladsl.model.HttpHeader.ParsingResult.Ok
import javax.inject.Inject
import models.Twit
import play.modules.reactivemongo.ReactiveMongoApi
import reactivemongo.api.commands.WriteResult
import reactivemongo.bson.{BSONDocument, BSONInteger, BSONObjectID}
import reactivemongo.play.json._
import reactivemongo.play.json.collection.JSONCollection
import reactivemongo.api.{Cursor, QueryOpts, ReadPreference}
import play.api.http.Status
import play.api.libs.json.{JsValue, Json}
import play.api.mvc.RequestHeader
import reactivemongo.api.bson.BSONDocumentWriter

import scala.concurrent.{ExecutionContext, Future}
import scala.util.{Failure, Success}


class TwitRepository @Inject()(
  implicit ec: ExecutionContext,
  reactiveMongoApi : ReactiveMongoApi
) {

  private def collection: Future[JSONCollection] = reactiveMongoApi.database.map(_.collection("twit"))

  def list(page : Int, count : Int, username : Option[String], tag : Option[String]) : Future[Seq[Twit]] = {

      //jsobj olarak olustur, gerekirse guncellenecek
      var selector = Json.obj("deleted" -> BSONDocument("$exists" -> false))

      val sorter = Json.toJsObject(BSONDocument("_id" -> -1))

      //kullanici adi varsa, ekle
      if (username.isDefined)
        selector ++= Json.obj("username" -> username)

      //etiket varsa ekle
      if (tag.isDefined)
        selector ++= Json.obj("tags.slug" -> tag)

      var query = selector.as[BSONDocument]

      collection.flatMap(
        _.find(query)
          .sort(Json.toJsObject(BSONDocument("_id" -> -1)))
          .options(QueryOpts(skipN = (page - 1) * count, batchSizeN = count))
          .cursor[Twit](ReadPreference.primary)
          .collect[Seq](count, Cursor.FailOnError[Seq[Twit]]())
      )
  }

  def insert(twit: Twit) = {
    collection.flatMap(_.insert(ordered = true).one(twit)).map(_.ok)
  }

  def get(id: BSONObjectID)  =
    collection.flatMap(_.find(BSONDocument("_id" -> id,"deleted" -> BSONDocument("$exists" -> false))).one[Twit])

  def delete(id: BSONObjectID, username : String) = {
    //silmek yok, deleted = true
    val selector = BSONDocument(
      "_id" -> id,
      "deleted" -> BSONDocument("$exists" -> false),
      "username" -> username
    )
    val modifier = BSONDocument(
      "$set" -> BSONDocument("deleted" -> true)
    )

    //nmodified > 0 guncelleme oldu. sifir ise, hata verecek
    val result = collection.flatMap(
      _.update(selector, modifier)
    ).map(_.nModified.>(0))
    result
  }
}
