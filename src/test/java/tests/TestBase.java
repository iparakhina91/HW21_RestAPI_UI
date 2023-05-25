package tests;

import com.codeborne.selenide.Configuration;
import com.codeborne.selenide.Selenide;
import com.codeborne.selenide.logevents.SelenideLogger;
import config.WebDriverConfig;
import config.AuthConfig;
import helpers.Attach;
import io.qameta.allure.junit5.AllureJunit5;
import io.qameta.allure.selenide.AllureSelenide;
import io.restassured.RestAssured;
import models.CreateTestCaseBody;
import models.CreateTestCaseResponse;
import org.aeonbits.owner.ConfigFactory;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.extension.ExtendWith;
import org.openqa.selenium.remote.DesiredCapabilities;

import java.util.Map;

import static io.qameta.allure.Allure.step;
import static io.restassured.RestAssured.given;
import static org.assertj.core.api.Assertions.assertThat;
import static spec.Specs.requestSpec;
import static spec.Specs.responseSuccess;
import static tests.TestData.testCaseName;

@ExtendWith({AllureJunit5.class})
public class TestBase {

    public static String
            projectId = "2301",
            allureTestOpsSession = "1632fb77-54e3-4fa0-ba64-ff5b57594c9a",
            xsrfToken = "d14799d9-dc1a-4c54-ac1f-30b82ea8950c";

    public static String testCaseId;

    static WebDriverConfig webDriverConfig = ConfigFactory.create(WebDriverConfig.class, System.getProperties());
    static AuthConfig authConfig = ConfigFactory.create(AuthConfig.class, System.getProperties());

    @BeforeAll
    static void configuration() {
        Configuration.browser = webDriverConfig.browser();
        Configuration.browserVersion = webDriverConfig.browserVersion();
        Configuration.browserSize = webDriverConfig.browserSize();
        Configuration.baseUrl = webDriverConfig.baseUrl();
        RestAssured.baseURI = "https://allure.autotests.cloud";
        String remoteUrl = "https://" + authConfig.remote_username() + ":" + authConfig.remote_password()
                + "@" + webDriverConfig.remoteUrl() + "/wd/hub";
        System.out.println(remoteUrl);
        if (webDriverConfig.isRemote()) {
            Configuration.remote = remoteUrl;

            DesiredCapabilities capabilities = new DesiredCapabilities();
            capabilities.setCapability("selenoid:options", Map.<String, Object>of(
                    "enableVNC", true,
                    "enableVideo", true
            ));

            Configuration.browserCapabilities = capabilities;
        }
    }

    @BeforeEach
    void addListener() {
        SelenideLogger.addListener("AllureSelenide", new AllureSelenide());

        CreateTestCaseBody testCaseBody = new CreateTestCaseBody();
        testCaseBody.setName(testCaseName);

        CreateTestCaseResponse createTestCaseResponse = step("Create testcase", () ->
                given(requestSpec)
                        .body(testCaseBody)
                        .queryParam("projectId", projectId)
                        .when()
                        .post("/rs/testcasetree/leaf")
                        .then()
                        .spec(responseSuccess)
                        .extract().as(CreateTestCaseResponse.class));

        Integer testCaseId = createTestCaseResponse.getId();

        step("Verify testcase name", () -> {
            assertThat(createTestCaseResponse.getName()).isEqualTo(testCaseName);
        });
    }

    @AfterEach
    void addAttachments() {
        Attach.screenshotAs("Last screenshot");
        Attach.pageSource();
        Attach.browserConsoleLogs();
        Attach.addVideo();
        Selenide.closeWebDriver();
    }
}
