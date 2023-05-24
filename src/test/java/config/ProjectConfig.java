package config;

import org.openqa.selenium.Cookie;
import tests.TestBase;

import static com.codeborne.selenide.Selenide.open;
import static com.codeborne.selenide.WebDriverRunner.getWebDriver;
import static java.lang.String.format;

public class ProjectConfig extends TestBase {

    public static void openProjectUrl() {
        open("/favicon.ico");

        Cookie authorizationCookie = new Cookie("ALLURE_TESTOPS_SESSION", allureTestOpsSession);
        getWebDriver().manage().addCookie(authorizationCookie);

        String testCaseUrl = format("/project/%s/test-cases/%s", projectId, testCaseId);
        open(testCaseUrl);
    }
}
