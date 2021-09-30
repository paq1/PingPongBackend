package services.cor.field
import domain.entity.{Field, Page, Player}

abstract class CORFieldElement(next: CORFieldElement) extends CORField {
  override def result(field: Field, page: Page): List[Player] = {
    val result = result_expert(field, page)
    if (result == null) {
      if (next != null) {
        next.result(field, page)
      } else {
        null
      }
    } else result
  }

  def result_expert(field: Field, page: Page): List[Player]
}

object CORFieldElement {
  val cor: CORFieldElement = {
    val chain = new CORFieldVictories(null)
    new CORFieldFirstName(chain)
  }
}