import org.scalatest.funsuite.AnyFunSuite
import services.PingService

class PingSpec extends AnyFunSuite {
  test("assert that GET for /ping request is pong") {
    assert(PingService.ping() == "pong")
  }
}