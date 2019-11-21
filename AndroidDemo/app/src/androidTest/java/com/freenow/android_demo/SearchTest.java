package com.freenow.android_demo;

//import android.app.Activity;
import android.support.test.espresso.DataInteraction;
import android.support.test.espresso.IdlingRegistry;
import android.support.test.espresso.matcher.RootMatchers;
import android.support.test.espresso.matcher.ViewMatchers;
import android.support.test.rule.ActivityTestRule;
import android.support.test.runner.AndroidJUnit4;

import com.freenow.android_demo.activities.MainActivity;
import com.freenow.android_demo.models.Driver;

import org.hamcrest.Matchers;
import org.junit.Rule;
import org.junit.Test;
import org.junit.runner.RunWith;

import java.util.Map;

import static android.support.test.espresso.Espresso.onData;
import static android.support.test.espresso.Espresso.onView;
import static android.support.test.espresso.action.ViewActions.click;
import static android.support.test.espresso.action.ViewActions.closeSoftKeyboard;
import static android.support.test.espresso.action.ViewActions.typeText;
import static android.support.test.espresso.assertion.ViewAssertions.matches;
import static android.support.test.espresso.matcher.ViewMatchers.isDisplayed;
import static android.support.test.espresso.matcher.ViewMatchers.withClassName;
import static android.support.test.espresso.matcher.ViewMatchers.withId;
import static android.support.test.espresso.matcher.ViewMatchers.withText;
import static org.hamcrest.Matchers.allOf;
import static org.hamcrest.Matchers.equalTo;
import static org.hamcrest.Matchers.instanceOf;
import static org.hamcrest.Matchers.is;


@RunWith(AndroidJUnit4.class)
public class SearchTest {

    @Rule
    public ActivityTestRule<MainActivity> mainActivityTestRule =
            new ActivityTestRule<>(MainActivity.class);

    @Test
    public void searchForDriver() {
        IdlingRegistry.getInstance();
        onView(withId(R.id.nav_username))
                .check(matches(withText("crazydog335")));



//        Activity activity = mainActivityTestRule.getActivity();


        onView(withId(R.id.textSearch))
                .perform(typeText("sa"))
                .perform(closeSoftKeyboard());

//      IdlingRegistry idlingRegistry = new AutocompleteShowIdlingResource(activity, R.id.textSearch);
//      DataInteraction aa = onData(ViewMatchers.withClassName(Matchers.endsWith("PopupDecorView")));
//      "com.freenow.android_demo.models.Driver"


        onData(allOf())
                .inAdapterView(("com.freenow.android_demo.models.Driver"), is("Samantha Reed"))
                .check(matches(isDisplayed()));

        onView(withText("Samantha Reed"))
                .inRoot(RootMatchers.withDecorView(
                        Matchers.not(is(mainActivityTestRule.getActivity().getWindow().getDecorView())))
                )
                .perform(click());

    }
}
