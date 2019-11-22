package com.freenow.android_demo;
import android.os.SystemClock;
import android.support.test.espresso.matcher.RootMatchers;
import android.support.test.espresso.matcher.ViewMatchers;
import android.support.test.rule.ActivityTestRule;
import android.support.test.runner.AndroidJUnit4;
import com.freenow.android_demo.activities.MainActivity;
import org.hamcrest.Matchers;
import org.junit.Rule;
import org.junit.Test;
import org.junit.runner.RunWith;
import static android.support.test.espresso.Espresso.onView;
import static android.support.test.espresso.action.ViewActions.click;
import static android.support.test.espresso.action.ViewActions.closeSoftKeyboard;
import static android.support.test.espresso.action.ViewActions.typeText;
import static android.support.test.espresso.assertion.ViewAssertions.matches;
import static android.support.test.espresso.matcher.ViewMatchers.withId;
import static android.support.test.espresso.matcher.ViewMatchers.withText;
@RunWith(AndroidJUnit4.class)
public class SearchTest {
    @Rule
    public ActivityTestRule<MainActivity> mainActivityTestRule =
            new ActivityTestRule<>(MainActivity.class);
    @Test
    public void searchForDriver() {
        onView(withId(R.id.nav_username))
                .check(matches(withText("crazydog335")));

        onView(withId(R.id.textSearch))
                .perform(typeText("sa"))
                .perform(closeSoftKeyboard());

        SystemClock.sleep(3000);

        onView(withText("Samantha Reed"))
                .inRoot(RootMatchers.isPlatformPopup())
                .perform(click());

        onView(withText("Samantha Reed"))
                .inRoot(RootMatchers.withDecorView(Matchers.not(mainActivityTestRule.getActivity().getWindow().getDecorView())))
                .check(matches(ViewMatchers.isDisplayed()))
                .perform(click());
    }
}