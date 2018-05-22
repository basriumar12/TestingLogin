package info.blogbasbas.logintesting.ui;


import android.support.test.espresso.ViewInteraction;
import android.support.test.rule.ActivityTestRule;
import android.support.test.runner.AndroidJUnit4;
import android.test.suitebuilder.annotation.LargeTest;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewParent;

import org.hamcrest.Description;
import org.hamcrest.Matcher;
import org.hamcrest.TypeSafeMatcher;
import org.junit.Rule;
import org.junit.Test;
import org.junit.runner.RunWith;

import info.blogbasbas.logintesting.R;

import static android.support.test.espresso.Espresso.onView;
import static android.support.test.espresso.action.ViewActions.click;
import static android.support.test.espresso.action.ViewActions.closeSoftKeyboard;
import static android.support.test.espresso.action.ViewActions.replaceText;
import static android.support.test.espresso.action.ViewActions.scrollTo;
import static android.support.test.espresso.matcher.ViewMatchers.isDisplayed;
import static android.support.test.espresso.matcher.ViewMatchers.withClassName;
import static android.support.test.espresso.matcher.ViewMatchers.withId;
import static android.support.test.espresso.matcher.ViewMatchers.withText;
import static org.hamcrest.Matchers.allOf;
import static org.hamcrest.Matchers.is;

@LargeTest
@RunWith(AndroidJUnit4.class)
public class hpTest {

    @Rule
    public ActivityTestRule<SplashscreenActivity> mActivityTestRule = new ActivityTestRule<>(SplashscreenActivity.class);

    @Test
    public void hpTest() {
        try {
            Thread.sleep(5000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        /*
        ViewInteraction textInputEditText = onView(
                allOf(withId(R.id.etEmail),
                        childAtPosition(
                                childAtPosition(
                                        withId(R.id.inputEmail),
                                        0),
                                0),
                        isDisplayed()));
        textInputEditText.perform(click());

        ViewInteraction textInputEditText2 = onView(
                allOf(withId(R.id.etEmail),
                        childAtPosition(
                                childAtPosition(
                                        withId(R.id.inputEmail),
                                        0),
                                0),
                        isDisplayed()));
        textInputEditText2.perform(replaceText("guru"), closeSoftKeyboard());

        ViewInteraction textInputEditText3 = onView(
                allOf(withId(R.id.etPassword),
                        childAtPosition(
                                childAtPosition(
                                        withId(R.id.inputPassword),
                                        0),
                                0),
                        isDisplayed()));
        textInputEditText3.perform(replaceText("1234"), closeSoftKeyboard());

        ViewInteraction appCompatButton = onView(
                allOf(withId(R.id.btnSignin), withText("SIGN IN"),
                        childAtPosition(
                                childAtPosition(
                                        withClassName(is("android.widget.LinearLayout")),
                                        1),
                                3)));
        appCompatButton.perform(scrollTo(), click());

        ViewInteraction appCompatButton2 = onView(
                allOf(withId(R.id.btnSignin), withText("SIGN IN"),
                        childAtPosition(
                                childAtPosition(
                                        withClassName(is("android.widget.LinearLayout")),
                                        1),
                                3)));
        appCompatButton2.perform(scrollTo(), click());

        /*
        ViewInteraction tabView = onView(
                allOf(childAtPosition(
                        childAtPosition(
                                withId(R.id.tab),
                                0),
                        2),
                        isDisplayed()));
        tabView.perform(click());

        ViewInteraction tabView2 = onView(
                allOf(childAtPosition(
                        childAtPosition(
                                withId(R.id.tab),
                                0),
                        1),
                        isDisplayed()));
        tabView2.perform(click());

        ViewInteraction tabView3 = onView(
                allOf(childAtPosition(
                        childAtPosition(
                                withId(R.id.tab),
                                0),
                        0),
                        isDisplayed()));
        tabView3.perform(click());

        ViewInteraction tabView4 = onView(
                allOf(childAtPosition(
                        childAtPosition(
                                withId(R.id.tab),
                                0),
                        0),
                        isDisplayed()));
        tabView4.perform(click());

        ViewInteraction tabView5 = onView(
                allOf(childAtPosition(
                        childAtPosition(
                                withId(R.id.tab),
                                0),
                        1),
                        isDisplayed()));
        tabView5.perform(click());

        ViewInteraction tabView6 = onView(
                allOf(childAtPosition(
                        childAtPosition(
                                withId(R.id.tab),
                                0),
                        2),
                        isDisplayed()));
        tabView6.perform(click());

        ViewInteraction tabView7 = onView(
                allOf(childAtPosition(
                        childAtPosition(
                                withId(R.id.tab),
                                0),
                        0),
                        isDisplayed()));
        tabView7.perform(click());

        ViewInteraction tabView8 = onView(
                allOf(childAtPosition(
                        childAtPosition(
                                withId(R.id.tab),
                                0),
                        1),
                        isDisplayed()));
        tabView8.perform(click());

        ViewInteraction tabView9 = onView(
                allOf(childAtPosition(
                        childAtPosition(
                                withId(R.id.tab),
                                0),
                        1),
                        isDisplayed()));
        tabView9.perform(click());

        ViewInteraction tabView10 = onView(
                allOf(childAtPosition(
                        childAtPosition(
                                withId(R.id.tab),
                                0),
                        1),
                        isDisplayed()));
        tabView10.perform(click());

        ViewInteraction tabView11 = onView(
                allOf(childAtPosition(
                        childAtPosition(
                                withId(R.id.tab),
                                0),
                        0),
                        isDisplayed()));
        tabView11.perform(click());
        */


    }

    private static Matcher<View> childAtPosition(
            final Matcher<View> parentMatcher, final int position) {

        return new TypeSafeMatcher<View>() {
            @Override
            public void describeTo(Description description) {
                description.appendText("Child at position " + position + " in parent ");
                parentMatcher.describeTo(description);
            }

            @Override
            public boolean matchesSafely(View view) {
                ViewParent parent = view.getParent();
                return parent instanceof ViewGroup && parentMatcher.matches(parent)
                        && view.equals(((ViewGroup) parent).getChildAt(position));
            }
        };
    }
}
