package spec;

import io.restassured.builder.ResponseSpecBuilder;
import io.restassured.specification.RequestSpecification;
import io.restassured.specification.ResponseSpecification;

import static helpers.CustomApiListener.withCustomTemplates;
import static io.restassured.RestAssured.with;
import static io.restassured.filter.log.LogDetail.BODY;
import static io.restassured.filter.log.LogDetail.STATUS;
import static tests.TestBase.allureTestOpsSession;
import static tests.TestBase.xsrfToken;

public class Specs {

    public static RequestSpecification requestSpec = with()
            .log().all()
            .header("X-XSRF-TOKEN", xsrfToken)
            .cookies("XSRF-TOKEN", xsrfToken,
                    "ALLURE_TESTOPS_SESSION", allureTestOpsSession)
            .filter(withCustomTemplates())
            .contentType("application/json;charset=UTF-8")
            .baseUri("https://allure.autotests.cloud")
            .basePath("/api");

    public static ResponseSpecification responseSuccess = new ResponseSpecBuilder()
            .log(STATUS)
            .log(BODY)
            .expectStatusCode(200)
            .build();

}
