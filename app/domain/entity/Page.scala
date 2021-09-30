package domain.entity

import play.api.libs.json.Json

case class Page(current: Int, max: Int)

object Page {
  implicit val pageParserJson = Json.format[Page]
}
