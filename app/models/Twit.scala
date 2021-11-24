package models


import play.api.libs.json.{Json, OFormat}

import reactivemongo.bson.BSONObjectID
import reactivemongo.play.json._

case class Twit(
                 _id: BSONObjectID,
                 username: String,
                 message: String,
                 tags: Option[List[Tag]]
)

object Twit{

  implicit val format : OFormat[Twit] = Json.format[Twit]

}
