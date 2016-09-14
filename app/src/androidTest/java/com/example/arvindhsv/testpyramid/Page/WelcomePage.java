package com.example.arvindhsv.testpyramid.Page;

import com.example.arvindhsv.testpyramid.R;

import static android.support.test.espresso.Espresso.onView;
import static android.support.test.espresso.assertion.ViewAssertions.matches;
import static android.support.test.espresso.matcher.ViewMatchers.isDisplayed;
import static android.support.test.espresso.matcher.ViewMatchers.withId;
import static android.support.test.espresso.matcher.ViewMatchers.withText;
import static org.hamcrest.Matchers.containsString;

public class WelcomePage {

    public WelcomePage checkIfUserIsInWelcomePage() {
        onView(withId(R.id.user_name)).check(matches(isDisplayed()));
        return this;
    }

    public WelcomePage checkIfEmpNameGetsDisplayedAs(String empName) {
        onView(withId(R.id.user_name)).check(matches(withText(containsString(empName))));
        return this;
    }
}
