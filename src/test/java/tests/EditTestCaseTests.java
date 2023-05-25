package tests;

import io.qameta.allure.*;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;
import pages.TestCasePage;

import static config.ProjectConfig.openProjectUrl;
import static io.qameta.allure.Allure.step;
import static tests.TestData.*;
import static tests.TestData.testCaseComment;

@Tag("editing")
@Feature("Edit testcase")
@Story("Edit created with API test")
@Owner("korovinaiyu")
@Severity(SeverityLevel.NORMAL)
public class EditTestCaseTests extends TestBase {

    TestCasePage testCasePage = new TestCasePage();

    @Test
    @DisplayName("Add description to created with API testcase")
    void addDescriptionToTestCase() {

        openProjectUrl();

        step("Add description to testcase", () -> {
            testCasePage.openTestCase()
                    .addDescriptionToTestCase(testCaseDescription);
        });

        step("Verify description", () -> {
            testCasePage.checkTestCaseDescription(testCaseDescription);
        });
    }

    @Test
    @DisplayName("Add step to created with API testcase")
    void addStepToTestCase() {

        openProjectUrl();

        step("Add step to testcase", () -> {
            testCasePage.openTestCase()
                    .editStepIcon()
                    .addStepToTestCase(stepName);
        });

        step("Verify name of step case", () -> {
            testCasePage.checkNameOfStep(stepName);
        });

    }

    @Test
    @DisplayName("Edit step name of created with API testcase")
    void editStepOfTestCase() {

        openProjectUrl();

        step("Add step to testcase", () -> {
            testCasePage.openTestCase()
                    .editStepIcon()
                    .addStepToTestCase(stepName);
        });

        step("Verify name of step case", () -> {
            testCasePage.checkNameOfStep(stepName);
        });

        step("Edit step of test case", () -> {
            testCasePage.openTestCase()
                    .editStepIcon()
                    .clearStepName()
                    .addStepToTestCase(editStepName);
        });

        step("Verify name of step case", () -> {
            testCasePage.checkNameOfStep(editStepName);
        });
    }

    @Test
    @DisplayName("Add comment to created with API testcase")
    void addCommentToCreatedWithAPITest() {

        openProjectUrl();

        step("Add comment to testcase", () -> {
            testCasePage.openTestCase()
                    .addComment(testCaseComment);
        });

        step("Verify comment", () -> {
            testCasePage.verifyComment(testCaseComment);
        });
    }

    @Test
    @DisplayName("Delete created with API testcase")
    void deleteCreatedWithAPITest() {

        openProjectUrl();

        step("Delete testcase", () -> {
            testCasePage.openTestCase()
                    .deleteTestCase();
        });
    }
}
