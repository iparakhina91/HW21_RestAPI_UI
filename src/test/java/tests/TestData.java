package tests;

import utils.FakerUtils;

import static utils.FakerUtils.*;

public class TestData {

    FakerUtils testFakerData = new FakerUtils();

    public static String
            projectId = "2301",
            xsrfToken = "439586aa-f82e-401b-8495-9dacda7dbe74",
            allureTestopsSession = "fad3bc4c-c5ae-4f8f-a8eb-82be01e31c45",
            testCaseName = getFakerTestCaseName(),
            testCaseDescription = getFakerTestCaseDescription(),
            testCaseComment = getTestCaseComment(),
            stepName = getFakerStepName(),
            editStepName = getEditStepName();
}
