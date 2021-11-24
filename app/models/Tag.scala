package models

import play.api.libs.json.{Json, OFormat}

case class Tag(tag : String, var slug:String)

object Tag{
  implicit val format : OFormat[Tag] = Json.format[Tag]
}
