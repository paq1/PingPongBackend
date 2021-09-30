package services.cor.field
import domain.entity.{Field, Page, Player}
import services.PlayersService

class CORFieldVictories(next: CORFieldElement) extends CORFieldElement(next) {
  private def listFromVictories(nbVictories: Int): List[Player] = {
    PlayersService.players.filter(player => player.nbVictories == nbVictories)
  }
  private def listFromVictoriesGt(value: Int): List[Player] = {
    PlayersService.players.filter(player => player.nbVictories > value)
  }
  private def listFromVictoriesLt(value: Int): List[Player] = {
    PlayersService.players.filter(player => player.nbVictories < value)
  }

  override def result_expert(field: Field, page: Page): List[Player] = {
    if (field.name == "nbVictories") {
      if (field.operator == "lt") {
        val filteredPlayer: List[Player] = listFromVictoriesLt(field.value.toInt)
        if (page != null) PlayersService.paginator(filteredPlayer, page)
        else filteredPlayer
      } else if (field.operator == "gt") {
        val filteredPlayer: List[Player] = listFromVictoriesGt(field.value.toInt)
        if (page != null) PlayersService.paginator(filteredPlayer, page)
        else filteredPlayer
      } else {
        val filteredPlayer: List[Player] = listFromVictories(field.value.toInt)
        if (page != null) PlayersService.paginator(filteredPlayer, page)
        else filteredPlayer
      }
    } else null
  }
}
