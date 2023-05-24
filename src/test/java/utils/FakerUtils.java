package utils;

import com.github.javafaker.Faker;

public class FakerUtils {

    public static String getFakerTestCaseName() {
        return new Faker().harryPotter().character();
    }

    public static String getFakerTestCaseDescription() {
        return new Faker().harryPotter().book();
    }

    public static String getFakerStepName() {
        return new Faker().harryPotter().spell();
    }

    public static String getEditStepName() {
        return new Faker().harryPotter().location();
    }

    public static String getTestCaseComment() {
        return new Faker().harryPotter().spell();
    }

}
