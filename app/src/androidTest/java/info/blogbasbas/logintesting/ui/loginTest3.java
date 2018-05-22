package info.blogbasbas.logintesting.ui;


import android.support.test.espresso.ViewInteraction;
import android.support.test.rule.ActivityTestRule;
import android.support.test.runner.AndroidJUnit4;
import android.test.suitebuilder.annotation.LargeTest;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewParent;
import android.view.WindowManager;

import org.hamcrest.Description;
import org.hamcrest.Matcher;
import org.hamcrest.TypeSafeMatcher;
import org.junit.Rule;
import org.junit.Test;
import org.junit.runner.RunWith;

import info.blogbasbas.logintesting.R;

import static android.support.test.espresso.Espresso.onView;
import static android.support.test.espresso.Espresso.pressBack;
import static android.support.test.espresso.action.ViewActions.click;
import static android.support.test.espresso.action.ViewActions.closeSoftKeyboard;
import static android.support.test.espresso.action.ViewActions.scrollTo;
import static android.support.test.espresso.action.ViewActions.typeText;
import static android.support.test.espresso.assertion.ViewAssertions.matches;
import static android.support.test.espresso.matcher.ViewMatchers.isDisplayed;
import static android.support.test.espresso.matcher.ViewMatchers.withClassName;
import static android.support.test.espresso.matcher.ViewMatchers.withId;
import static android.support.test.espresso.matcher.ViewMatchers.withText;
import static org.hamcrest.Matchers.allOf;
import static org.hamcrest.Matchers.is;

@LargeTest
@RunWith(AndroidJUnit4.class)
public class loginTest3 {
    public static final String idLogin = "guru";
    public static final String passLogin = "1234";
    public static final String mNama = "Guru budi";
    public static final String mEmail = "guru@email.com";
    public static final String mSubsId= "32";

    @Rule
    public ActivityTestRule<LoginActivity> loginActivityActivityTestRule =
            new ActivityTestRule<>(LoginActivity.class);
    //public ActivityTestRule<SplashscreenActivity> mActivityTestRule = new ActivityTestRule<>(SplashscreenActivity.class);

    @Test
    public void loginTest3() {
        try {
            Thread.sleep(5000);
        }
        catch (InterruptedException e){
            e.printStackTrace();
        }

        final LoginActivity loginActivity = loginActivityActivityTestRule.getActivity();
        Runnable wakeUpDevice2 = new Runnable() {
            public void run() {
                loginActivity.getWindow().addFlags(WindowManager.LayoutParams.FLAG_TURN_SCREEN_ON |
                        WindowManager.LayoutParams.FLAG_SHOW_WHEN_LOCKED |
                        WindowManager.LayoutParams.FLAG_KEEP_SCREEN_ON);
            }
        };
        loginActivity.runOnUiThread(wakeUpDevice2);



        try {
            Thread.sleep(5000);
        }
        catch (InterruptedException e){
            e.printStackTrace();
        }



        onView(withId(R.id.etEmail)).perform(typeText(idLogin), closeSoftKeyboard());
        onView(withId(R.id.etPassword)).perform(typeText(passLogin), closeSoftKeyboard());

        onView(withId(R.id.btnSignin)).perform(click());

        try {
            Thread.sleep(5000);
        }
        catch (InterruptedException e){
            e.printStackTrace();
        }



        onView(withId(R.id.txtName)).check(matches(withText(mNama)));
        onView(withId(R.id.txtEmail)).check(matches(withText(mEmail)));
        onView(withId(R.id.txtSubcriptionId)).check(matches(withText(mSubsId)));

        try {
            Thread.sleep(5000);
        }
        catch (InterruptedException e){
            e.printStackTrace();
        }

        ViewInteraction subscriptionVIew = onView(
                allOf(childAtPosition(
                        childAtPosition(
                                withId(R.id.tab),
                                0),
                        1),
                        isDisplayed()));

        ViewInteraction UserVIew = onView(
                allOf(childAtPosition(
                        childAtPosition(
                                withId(R.id.tab),
                                0),
                        0),
                        isDisplayed()));

        subscriptionVIew.perform(click());
        onView(withId(R.id.txtSubcriptionId)).check(matches(withText(mSubsId)));

        try {
            Thread.sleep(5000);
        }
        catch (InterruptedException e){
            e.printStackTrace();
        }

        UserVIew.perform(click());
        onView(withId(R.id.txtName)).check(matches(withText(mNama)));

        try {
            Thread.sleep(5000);
        }
        catch (InterruptedException e){
            e.printStackTrace();
        }

        subscriptionVIew.perform(click());
        onView(withId(R.id.txtSubcriptionId)).check(matches(withText(mSubsId)));

        try {
            Thread.sleep(5000);
        }
        catch (InterruptedException e){
            e.printStackTrace();
        }

        /*
        pressBack();

        try {
            Thread.sleep(2000);
        }
        catch (InterruptedException e){
            e.printStackTrace();
        }

        ViewInteraction YesLogOutButton = onView(
                allOf(withId(android.R.id.button1), withText("Yes"),
                        childAtPosition(
                                childAtPosition(
                                        withClassName(is("android.widget.ScrollView")),
                                        0),
                                3)));
        YesLogOutButton.perform(scrollTo(), click());
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
