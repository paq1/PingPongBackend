import domain.entity.Player
import org.scalatest.funsuite.AnyFunSuite
import services.PlayersService

import java.time.LocalDate

class PlayerTest extends AnyFunSuite {
  test("assert that GET for /players request return a list with 1 element") {
    assert(PlayersService.players.length > 0)
    assert(PlayersService.players.isInstanceOf[List[Player]])
  }

  test("POST") {
    val lengthPlayersInit: Int = PlayersService.players.length
    PlayersService.add(new Player("new", "player", 10, LocalDate.now()))
    val lengthPlayersAfterAdding: Int = PlayersService.players.length;
    assert(lengthPlayersInit < lengthPlayersAfterAdding);
  }

  test("assert that .. ") {
    PlayersService.add(new Player("new", "player", 2, LocalDate.now()));
    assert(PlayersService.listFromVictories(2).length == 1)
  }

  test("test params") {

  }
}
