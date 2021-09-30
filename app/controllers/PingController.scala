package controllers

import play.api.mvc._
import services.PingService
import play.api.mvc.Results

import javax.inject._

class PingController @Inject()(cc: ControllerComponents) extends AbstractController(cc) {
  def Pong() = Action {Ok(PingService.ping())}
}
