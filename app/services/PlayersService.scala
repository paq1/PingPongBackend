package services

import domain.entity.{Field, Page, Player}
import play.api.libs.json.Json
import services.cor.field.CORFieldElement

import java.time.LocalDate

object PlayersService {
  var players: List[Player] = List(new Player("paul", "jack", 10, LocalDate.now()))

  def add(player: Player): List[Player] = {
    players = player :: players
    players
  }

  def paginator(listOfPlayers: List[Player], page: Page): List[Player] = {
    listOfPlayers.slice((page.max * page.current),page.max * (page.current+1))
  }

  def playerById(id: Int): Option[Player] = {
    if (players.indices.contains(id)) {
      Some(players(id))
    } else None
  }

  def deleteWithId(id: Int) = {
    val (a, b) = players.splitAt(id)
    players = a ++ b.tail
  }

  def listFromFieldAndPage(field: Field, page: Page): List[Player] = {
    if (field == null) players
    val result: List[Player] = CORFieldElement.cor.result(field, page)
    if (result != null) {
      CORFieldElement.cor.result(field, page)
    } else {
      if (page != null) paginator(players, page)
      else players
    }
  }
}
