package services

import play.api.libs.json.Json

object ParamsQueryService {
  def getParamsFromString(params: String): Unit = Json.toJson(params);
}
