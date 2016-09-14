package com.example.arvindhsv.testpyramid.Page;

import com.example.arvindhsv.testpyramid.R;

import static android.support.test.espresso.Espresso.onView;
import static android.support.test.espresso.action.ViewActions.click;
import static android.support.test.espresso.action.ViewActions.replaceText;
import static android.support.test.espresso.assertion.ViewAssertions.matches;
import static android.support.test.espresso.matcher.ViewMatchers.isDisplayed;
import static android.support.test.espresso.matcher.ViewMatchers.withId;
import static android.support.test.espresso.matcher.ViewMatchers.withText;

public class SignInPage {

    public WelcomePage giveValidEmpIdAndClickSignIn(String empId) {
        onView(withId(R.id.emp_Id)).perform(replaceText(empId));
        onView(withId(R.id.sign_in_button)).perform(click());
        return new WelcomePage();
    }

    public SignInPage giveInvalidEmpIdAndClickSignIn(String empId) {
        onView(withId(R.id.emp_Id)).perform(replaceText(empId));
        onView(withId(R.id.sign_in_button)).perform(click());
        return this;
    }

    public SignInPage checkIfErrorMessageAppearsAs(String message) {
        onView(withText(message)).check(matches(isDisplayed()));
        return this;
    }

    public SignInPage clickOnSignIn() {
        onView(withId(R.id.sign_in_button)).perform(click());
        return this;
    }

    public SignInPage checkIfWarningIconAppearsWithError() {
        onView(withId(R.id.indicator_for_error)).check(matches(isDisplayed()));
        return this;
    }

    public SignInPage verifyEmpIdFieldValue(String empId) {
        onView(withId(R.id.emp_Id)).check(matches(withText(empId)));
        return this;
    }
}
