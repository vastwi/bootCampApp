package simulations

import io.gatling.core.Predef._
import io.gatling.core.feeder.RecordSeqFeederBuilder
import io.gatling.core.scenario.Simulation
import io.gatling.http.Predef._

class SignIn extends Simulation {

  val srsHostName: String = scala.util.Properties.envOrElse("HOSTNAME", "localhost" )
  val httpConf = http.baseURL(s"http://${hostName}:9084")

  private val employeeDetailsSeed: RecordSeqFeederBuilder[String] = csv("employee_details.csv")

  val signInScenario = scenario("SignIn with EmpId and check for employeeName result")
    .feed(csv("employee_details.csv").circular)
    .exec(
      http("signIn")
        .put(stringToExpression("/boot_camp_service/candidates/{candidateId}/login"))
        .check(status.in(200 to 210))
        // if required can add some assertions like checking employee name that is returned
    )

  setUp(
    signInScenario.inject(nothingFor(20), rampUsersPerSec(100) to(120) during (600) randomized).protocols(httpConf)
  )
}