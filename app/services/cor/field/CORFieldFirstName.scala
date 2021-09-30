package services.cor.field

import domain.entity._
import services.PlayersService

class CORFieldFirstName(next: CORFieldElement) extends CORFieldElement(next) {

  override def result_expert(field: Field, page: Page): List[Player] = {
    println("ici")
    if (field.name == "firstName") {
      PlayersService.players.filter(player => player.firstName == field.value)
    } else null
  }

}
