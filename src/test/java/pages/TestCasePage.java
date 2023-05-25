package pages;

import com.codeborne.selenide.SelenideElement;
import com.codeborne.selenide.selector.ByText;
import tests.TestData;

import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Selectors.byText;
import static com.codeborne.selenide.Selenide.$;

public class TestCasePage {

    private SelenideElement
            testCaseName = $(new ByText(TestData.testCaseName)),
            editDescriptionIcon = $("section[data-testid='section__description'] button[type='button']"),
            testCaseDescription = $("textarea[placeholder='Type a description']"),
            submitDescriptionButton = $("button[name='submit']"),
            editStepsButton = $("[data-testid=section__scenario]").$("[data-testid=button__edit_section]"),
            stepOfTestCase = $(".TestCaseScenarioStepEdit__textarea"),
            submitStepNameButton = $(byText("Submit")),
            nameOfStepTestCase = $(".TestCaseScenarioStep__name"),
            commentArea = $(".MarkdownTextarea__edit"),
            submitCommentButton = $(".Button_style_primary"),
            testCaseComment = $(".Comment"),
            editTestCaseMenu = $(".Menu__trigger"),
            deleteItem = $(".Menu__item_danger "),
            submitDeleteButton = $(".TestCaseDeleteModal__confirm-button");


    public TestCasePage openTestCase() {
        testCaseName.click();

        return this;
    }

    public TestCasePage addDescriptionToTestCase(String value) {
        editDescriptionIcon.click();
        testCaseDescription.setValue(value);
        submitDescriptionButton.click();

        return this;
    }

    public TestCasePage checkTestCaseDescription(String value) {
        testCaseDescription.shouldHave(text(value));

        return this;
    }

    public TestCasePage editStepIcon() {
        editStepsButton.click();

        return this;
    }

    public TestCasePage addStepToTestCase(String value) {
        stepOfTestCase.setValue(value);
        submitStepNameButton.click();

        return this;
    }

    public TestCasePage checkNameOfStep(String value) {
        nameOfStepTestCase.shouldHave(text(value));

        return this;
    }

    public TestCasePage clearStepName() {
        stepOfTestCase.clear();

        return this;
    }

    public TestCasePage addComment(String value) {
        commentArea.click();
        commentArea.setValue(value);
        submitCommentButton.click();

        return this;
    }

    public TestCasePage verifyComment(String value) {
        testCaseComment.shouldHave(text(value));

        return this;
    }

    public TestCasePage deleteTestCase() {
        editTestCaseMenu.click();
        $(byText("Delete")).click();
        deleteItem.click();
        submitDeleteButton.click();

        return this;
    }
}
