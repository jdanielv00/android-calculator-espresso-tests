package com.sourav.mohanty.calculator;

import androidx.test.espresso.Espresso;
import androidx.test.espresso.action.ViewActions;
import androidx.test.espresso.assertion.ViewAssertions;
import androidx.test.espresso.matcher.ViewMatchers;
import androidx.test.ext.junit.rules.ActivityScenarioRule;
import androidx.test.ext.junit.runners.AndroidJUnit4;
import static androidx.test.espresso.matcher.ViewMatchers.withText;

import org.hamcrest.CoreMatchers;
import org.junit.Rule;
import org.junit.Test;
import org.junit.runner.RunWith;
import android.content.pm.ActivityInfo;
import androidx.test.platform.app.InstrumentationRegistry;

@RunWith(AndroidJUnit4.class)
public class CalculatorEspressoTest {
    @Rule
    public ActivityScenarioRule<MainActivity> activityRule =
            new ActivityScenarioRule<>(MainActivity.class);

    @Test
    public void testTwoPlusTwoEqualsFour() {
        Espresso.onView(withText("Ok")).perform(ViewActions.click()); // Target the 'Ok' button in pop-up with correct casing
        Espresso.onView(ViewMatchers.withId(R.id.button2)).perform(ViewActions.click());
        Espresso.onView(ViewMatchers.withId(R.id.buttonAdd)).perform(ViewActions.click());
        Espresso.onView(ViewMatchers.withId(R.id.button2)).perform(ViewActions.click());
        Espresso.onView(ViewMatchers.withId(R.id.buttonEquals)).perform(ViewActions.click());
        Espresso.onView(ViewMatchers.withId(R.id.newNumber)).check(ViewAssertions.matches(withText(CoreMatchers.containsString("4"))));
    }

    @Test
    public void testThreeMinusOneEqualsTwo() {
        Espresso.onView(withText("Ok")).perform(ViewActions.click());
        Espresso.onView(ViewMatchers.withId(R.id.button3)).perform(ViewActions.click());
        Espresso.onView(ViewMatchers.withId(R.id.buttonMinus)).perform(ViewActions.click());
        Espresso.onView(ViewMatchers.withId(R.id.button1)).perform(ViewActions.click());
        Espresso.onView(ViewMatchers.withId(R.id.buttonEquals)).perform(ViewActions.click());
        Espresso.onView(ViewMatchers.withId(R.id.newNumber)).check(ViewAssertions.matches(withText(CoreMatchers.containsString("2"))));
    }

    @Test
    public void testFiveTimesEightEqualsFourty() {
        Espresso.onView(withText("Ok")).perform(ViewActions.click());
        Espresso.onView(ViewMatchers.withId(R.id.button5)).perform(ViewActions.click());
        Espresso.onView(ViewMatchers.withId(R.id.buttonMultiply)).perform(ViewActions.click());
        Espresso.onView(ViewMatchers.withId(R.id.button8)).perform(ViewActions.click());
        Espresso.onView(ViewMatchers.withId(R.id.buttonEquals)).perform(ViewActions.click());
        Espresso.onView(ViewMatchers.withId(R.id.newNumber)).check(ViewAssertions.matches(withText(CoreMatchers.containsString("40"))));
    }

    @Test
    public void testTwentyDividedByFourEqualsFive() {
        Espresso.onView(withText("Ok")).perform(ViewActions.click());
        Espresso.onView(ViewMatchers.withId(R.id.button2)).perform(ViewActions.click());
        Espresso.onView(ViewMatchers.withId(R.id.button0)).perform(ViewActions.click());
        Espresso.onView(ViewMatchers.withId(R.id.buttonDevide)).perform(ViewActions.click());
        Espresso.onView(ViewMatchers.withId(R.id.button4)).perform(ViewActions.click());
        Espresso.onView(ViewMatchers.withId(R.id.buttonEquals)).perform(ViewActions.click());
        Espresso.onView(ViewMatchers.withId(R.id.newNumber)).check(ViewAssertions.matches(withText(CoreMatchers.containsString("5"))));
    }

    @Test
    public void testChainedOperations() {
        Espresso.onView(withText("Ok")).perform(ViewActions.click());
        Espresso.onView(ViewMatchers.withId(R.id.button6)).perform(ViewActions.click());
        Espresso.onView(ViewMatchers.withId(R.id.button0)).perform(ViewActions.click());
        Espresso.onView(ViewMatchers.withId(R.id.buttonAdd)).perform(ViewActions.click());
        Espresso.onView(ViewMatchers.withId(R.id.button5)).perform(ViewActions.click());
        Espresso.onView(ViewMatchers.withId(R.id.buttonMinus)).perform(ViewActions.click());
        Espresso.onView(ViewMatchers.withId(R.id.button1)).perform(ViewActions.click());
        Espresso.onView(ViewMatchers.withId(R.id.button0)).perform(ViewActions.click());
        Espresso.onView(ViewMatchers.withId(R.id.buttonEquals)).perform(ViewActions.click());
        Espresso.onView(ViewMatchers.withId(R.id.newNumber)).check(ViewAssertions.matches(withText(CoreMatchers.containsString("55"))));
    }

    @Test
    public void testDecimalPoints() {
        Espresso.onView(withText("Ok")).perform(ViewActions.click());
        Espresso.onView(ViewMatchers.withId(R.id.button2)).perform(ViewActions.click());
        Espresso.onView(ViewMatchers.withId(R.id.buttonDot)).perform(ViewActions.click());
        Espresso.onView(ViewMatchers.withId(R.id.button5)).perform(ViewActions.click());
        Espresso.onView(ViewMatchers.withId(R.id.buttonAdd)).perform(ViewActions.click());
        Espresso.onView(ViewMatchers.withId(R.id.button3)).perform(ViewActions.click());
        Espresso.onView(ViewMatchers.withId(R.id.buttonDot)).perform(ViewActions.click());
        Espresso.onView(ViewMatchers.withId(R.id.button2)).perform(ViewActions.click());
        Espresso.onView(ViewMatchers.withId(R.id.buttonEquals)).perform(ViewActions.click());
        Espresso.onView(ViewMatchers.withId(R.id.newNumber)).check(ViewAssertions.matches(withText(CoreMatchers.containsString("5.7"))));
    }

    @Test
    public void testClearButton() {
        Espresso.onView(withText("Ok")).perform(ViewActions.click());
        Espresso.onView(ViewMatchers.withId(R.id.button1)).perform(ViewActions.click());
        Espresso.onView(ViewMatchers.withId(R.id.button2)).perform(ViewActions.click());
        Espresso.onView(ViewMatchers.withId(R.id.button3)).perform(ViewActions.click());
        Espresso.onView(ViewMatchers.withId(R.id.clearText)).perform(ViewActions.click());
        Espresso.onView(ViewMatchers.withId(R.id.newNumber)).check(ViewAssertions.matches(withText("")));
    }

    @Test
    public void testPercentage() {
        Espresso.onView(withText("Ok")).perform(ViewActions.click());
        Espresso.onView(ViewMatchers.withId(R.id.button1)).perform(ViewActions.click());
        Espresso.onView(ViewMatchers.withId(R.id.button0)).perform(ViewActions.click());
        Espresso.onView(ViewMatchers.withId(R.id.buttonMultiply)).perform(ViewActions.click());
        Espresso.onView(ViewMatchers.withId(R.id.button5)).perform(ViewActions.click());
        Espresso.onView(ViewMatchers.withId(R.id.button0)).perform(ViewActions.click());
        Espresso.onView(ViewMatchers.withId(R.id.percentage)).perform(ViewActions.click());
        Espresso.onView(ViewMatchers.withId(R.id.newNumber)).check(ViewAssertions.matches(withText(CoreMatchers.containsString("5"))));
    }

    @Test
    public void testScientificCalc() {
        Espresso.onView(withText("Ok")).perform(ViewActions.click());

        activityRule.getScenario().onActivity(activity -> {
            activity.setRequestedOrientation(ActivityInfo.SCREEN_ORIENTATION_LANDSCAPE);
        });

        Espresso.onView(ViewMatchers.withId(R.id.button9)).perform(ViewActions.click());
        Espresso.onView(ViewMatchers.withId(R.id.button0)).perform(ViewActions.click());
        Espresso.onView(ViewMatchers.withId(R.id.buttonSin)).perform(ViewActions.click());
        Espresso.onView(ViewMatchers.withId(R.id.buttonEquals)).perform(ViewActions.click());
        Espresso.onView(ViewMatchers.withId(R.id.newNumber)).check(ViewAssertions.matches(withText(CoreMatchers.containsString("1"))));
    }

    @Test
    public void testScientificCalc2() {
        Espresso.onView(withText("Ok")).perform(ViewActions.click());

        activityRule.getScenario().onActivity(activity -> {
            activity.setRequestedOrientation(ActivityInfo.SCREEN_ORIENTATION_LANDSCAPE);
        });

        Espresso.onView(ViewMatchers.withId(R.id.button2)).perform(ViewActions.click());
        Espresso.onView(ViewMatchers.withId(R.id.button5)).perform(ViewActions.click());
        Espresso.onView(ViewMatchers.withId(R.id.buttonSquare)).perform(ViewActions.click());
        Espresso.onView(ViewMatchers.withId(R.id.newNumber)).check(ViewAssertions.matches(withText(CoreMatchers.containsString("5"))));

    }


}
