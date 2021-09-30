package domain.entity

import play.api.libs.json.Json

import java.time.LocalDate

case class Player(firstName: String, lastName: String, nbVictories: Int, dob: LocalDate) {
}

object Player {
  implicit val playerParserJson = Json.format[Player]
}
