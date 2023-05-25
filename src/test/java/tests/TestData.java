package tests;

import static utils.FakerUtils.*;

public class TestData {

    public static String
            testCaseName = getFakerTestCaseName(),
            testCaseDescription = getFakerTestCaseDescription(),
            testCaseComment = getTestCaseComment(),
            stepName = getFakerStepName(),
            editStepName = getEditStepName();
}
