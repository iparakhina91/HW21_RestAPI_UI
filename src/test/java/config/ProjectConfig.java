package config;

import org.openqa.selenium.Cookie;
import tests.TestBase;

import static com.codeborne.selenide.Selenide.open;
import static com.codeborne.selenide.WebDriverRunner.getWebDriver;
import static java.lang.String.format;
import static tests.TestData.allureTestopsSession;
import static tests.TestData.projectId;

public class ProjectConfig extends TestBase {

    public static void openProjectUrl() {
        open("/favicon.ico");

        Cookie authorizationCookie = new Cookie("ALLURE_TESTOPS_SESSION", allureTestopsSession);
        getWebDriver().manage().addCookie(authorizationCookie);

        String testCaseUrl = format("/project/%s/test-cases/%s", projectId, testCaseId);
        open(testCaseUrl);
    }
}
