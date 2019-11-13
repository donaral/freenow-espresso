package com.freenow.android_demo;

import android.support.test.rule.ActivityTestRule;
import android.support.test.runner.AndroidJUnit4;

import com.freenow.android_demo.activities.AuthenticationActivity;

import org.junit.Before;
import org.junit.Rule;
import org.junit.Test;
import org.junit.runner.RunWith;

import static android.support.test.espresso.Espresso.onView;
import static android.support.test.espresso.action.ViewActions.click;
import static android.support.test.espresso.action.ViewActions.typeText;
import static android.support.test.espresso.assertion.ViewAssertions.matches;
import static android.support.test.espresso.matcher.ViewMatchers.isDisplayed;
import static android.support.test.espresso.matcher.ViewMatchers.withId;


@RunWith(AndroidJUnit4.class)
public class LoginTest {
    private String username;
    private String password;

    @Rule
    public ActivityTestRule<AuthenticationActivity> authenticationActivityTestRule =
            new ActivityTestRule<>(AuthenticationActivity.class);

    @Before
    public void credentials() {
        username = "crazydog335";
        password = "venture";
    }

    @Test
    public void login() {
        onView(withId(R.id.edt_username))
                .check(matches(isDisplayed()));

        onView(withId(R.id.edt_username))
                .perform(typeText(username));

        onView(withId(R.id.edt_password))
                .perform(typeText(password));

        onView(withId(R.id.btn_login))
                .perform(click());

    }

}


