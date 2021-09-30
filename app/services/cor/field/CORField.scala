package services.cor.field

import domain.entity.{Field, Page, Player}

trait CORField {
  def result(field: Field, page: Page): List[Player]
}