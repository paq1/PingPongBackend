package controllers

import domain.entity.{Field, Page, Player}
import play.api.libs.json.Json
import play.api.mvc.{AbstractController, ControllerComponents}
import services.{ParamsQueryService, PlayersService}

import javax.inject.Inject

class PlayersController @Inject()(cc: ControllerComponents) extends AbstractController(cc) {
  def getListOfPlayer() = Action { request =>
    val field: Option[String] = request.getQueryString("field")
    val fieldPage: Option[String] = request.getQueryString("page")
    if (field.nonEmpty && fieldPage.nonEmpty) {
      val fieldStringValue: String = field.get
      val fieldPageStringValue: String = fieldPage.get
      val fieldValue = Json.parse(fieldStringValue).as[Field]
      val pageValue = Json.parse(fieldPageStringValue).as[Page]
      Ok(Json.toJson(PlayersService.listFromFieldAndPage(fieldValue, pageValue)))
    } else {
      Ok(Json.toJson(PlayersService.players))
    }
  }

  def getPlayerWithId(id: Int) = Action {
    val playerOption: Option[Player] = PlayersService.playerById(id)
    if (playerOption.nonEmpty) Ok(Json.toJson(playerOption.get))
    else NotFound
  }

  def deleteWithId(id: Int) = Action {
    if (PlayersService.players.indices.contains(id)) {
      PlayersService.deleteWithId(id)
      Ok
    } else NotFound
  }

  def addPlayer() = Action { implicit request =>
    val json = request.body.asJson.get
    val player = json.as[Player]
    PlayersService.add(player)
    Ok(json)
  }
}