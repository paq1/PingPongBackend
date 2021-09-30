package domain.entity

import play.api.libs.json.Json

case class Field(name: String, value: String, operator: String)

object Field {
  implicit val fieldParserJson = Json.format[Field]
}

