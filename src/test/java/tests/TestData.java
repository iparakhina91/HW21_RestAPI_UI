package tests;

import utils.FakerUtils;

import static utils.FakerUtils.*;

public class TestData {

    FakerUtils testFakerData = new FakerUtils();

    public static String
            testCaseName = getFakerTestCaseName(),
            testCaseDescription = getFakerTestCaseDescription(),
            testCaseComment = getTestCaseComment(),
            stepName = getFakerStepName(),
            editStepName = getEditStepName();
}
