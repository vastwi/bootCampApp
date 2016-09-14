package com.example.arvindhsv.testpyramid.Test;

import android.support.test.rule.ActivityTestRule;
import android.support.test.runner.AndroidJUnit4;

import com.example.arvindhsv.testpyramid.Page.SignInPage;
import com.example.arvindhsv.testpyramid.SignInActivity;

import org.junit.Rule;
import org.junit.Test;
import org.junit.runner.RunWith;

@RunWith(AndroidJUnit4.class)
public class SignInTest {
    @Rule
    public final ActivityTestRule main = new ActivityTestRule(SignInActivity.class, true, true);
    private SignInPage signInPage = new SignInPage();

    @Test
    public void givingEmptyEmpIdCheckIfErrorAppears() {
        signInPage
                .giveInvalidEmpIdAndClickSignIn(" ")
                .checkIfErrorMessageAppearsAs("This employee id is invalid");
    }

    @Test
    public void onClickingSignInWithoutEmpIdCheckIfErrorAppears() {
        signInPage
                .clickOnSignIn()
                .checkIfErrorMessageAppearsAs("This field is required");
    }

    @Test
    public void checkErrorMessageAppearsWithWarningIcon() {
        signInPage
                .giveInvalidEmpIdAndClickSignIn("112")
                .checkIfWarningIconAppearsWithError();
    }

    @Test
    public void checkIfCursorStaysInEmpIdFieldOnValidationError() {
        signInPage
                .clickOnSignIn()
                .giveInvalidEmpIdAndClickSignIn("EE2")
                .giveValidEmpIdAndClickSignIn("13426")
                .checkIfEmpNameGetsDisplayedAs("Arvind");
    }

    @Test
    public void checkIfTheUserIsAbleToEnterMoreThan5DigitsOfDate() {
        signInPage
                .giveInvalidEmpIdAndClickSignIn("123456789")
                .verifyEmpIdFieldValue("123456789");
    }

    @Test
    public void giveValidEmpIdCheckIfEmpNameGetsDisplayedInWelcomePage() {
        signInPage
                .giveValidEmpIdAndClickSignIn("13426")
                .checkIfUserIsInWelcomePage()
                .checkIfEmpNameGetsDisplayedAs("Arvind");
    }
}
