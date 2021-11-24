package models

import play.api.libs.json.{Json, OFormat}

case class Statu (val status : String)

object Statu{
  implicit val format : OFormat[Statu] = Json.format[Statu]
}