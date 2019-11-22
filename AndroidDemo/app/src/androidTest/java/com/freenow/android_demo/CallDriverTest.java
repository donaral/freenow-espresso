package com.freenow.android_demo;

import android.content.Intent;
import android.support.test.rule.ActivityTestRule;

import com.freenow.android_demo.activities.DriverProfileActivity;

import org.junit.Rule;
import org.junit.Test;

import static android.support.test.espresso.Espresso.onView;
import static android.support.test.espresso.action.ViewActions.click;
import static android.support.test.espresso.assertion.ViewAssertions.matches;
import static android.support.test.espresso.matcher.ViewMatchers.withId;
import static android.support.test.espresso.matcher.ViewMatchers.withText;

import com.freenow.android_demo.models.Driver;

import java.util.Date;

public class CallDriverTest {

    @Rule
    public ActivityTestRule<DriverProfileActivity> callDriverActivityTestRule =
            new ActivityTestRule<>(DriverProfileActivity.class, false, false);

    @Test
    public void callDriver() {
        Driver driver = new Driver("Duygu Onaral", "905532419612", "www.google.com", "Istanbul", new Date());
        Intent i = new Intent();
        i.putExtra("driver", driver);
        callDriverActivityTestRule.launchActivity(i);

        onView(withId(R.id.textViewDriverName))
                .check(matches(withText("Duygu Onaral")));

        onView(withId(R.id.fab))
                .perform(click());
    }
}
