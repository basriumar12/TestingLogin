package info.blogbasbas.logintesting.ui;


import android.support.annotation.NonNull;
import android.support.annotation.StringRes;
import android.support.test.espresso.Espresso;
import android.support.test.espresso.ViewInteraction;
import android.support.test.espresso.assertion.ViewAssertions;
import android.support.test.espresso.matcher.BoundedMatcher;
import android.support.test.espresso.matcher.ViewMatchers;
import android.support.test.rule.ActivityTestRule;
import android.support.test.runner.AndroidJUnit4;
import android.test.suitebuilder.annotation.LargeTest;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewParent;
import android.view.WindowManager;
import android.widget.EditText;
import android.widget.TextView;

import org.hamcrest.Description;
import org.hamcrest.Matcher;
import org.hamcrest.Matchers;
import org.hamcrest.TypeSafeMatcher;
import org.junit.Assert;
import org.junit.Before;
import org.junit.FixMethodOrder;
import org.junit.Rule;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.MethodSorters;

import java.util.ArrayList;
import java.util.Collection;

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
@FixMethodOrder(MethodSorters.NAME_ASCENDING)

public class loginTest4 {
    public static final String idLogin = "guru";
    public static final String passLogin = "1234";
    public static final String mNama = "Guru budi";
    public static final String mEmail = "guru@email.com";
    public static final String mSubsId= "32";

    @Rule
    public ActivityTestRule<LoginActivity> loginActivityActivityTestRule =
            new ActivityTestRule<>(LoginActivity.class);
    //public ActivityTestRule<SplashscreenActivity> mActivityTestRule = new ActivityTestRule<>(SplashscreenActivity.class);

    /*private Collection<Object> collection;
    @Before
    public void setUp() {
        collection = new ArrayList<Object>();
    }*/



    @Test
    public void emptyUsername() {

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

        onView(withId(R.id.btnSignin)).perform(click());
        try {
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
//        onView(withId(R.id.etEmail)).check(matches(withError("Username is empty")));
        onView(withText(R.string.etemail)).check(matches(withText("Username is empty")));
    }

    @Test
    public void wrongId(){
        try {
            Thread.sleep(5000);
        }
        catch (InterruptedException e){
            e.printStackTrace();
        }

        onView(withId(R.id.etEmail)).perform(typeText("salah"), closeSoftKeyboard());
        onView(withId(R.id.etPassword)).perform(typeText(passLogin), closeSoftKeyboard());
        onView(withId(R.id.btnSignin)).perform(click());

        try {
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        onView(withText(R.string.etIncorrect)).check(matches(withText("Username / Pass is incorrect")));
    }

    @Test
    public void wrongPass(){
        try {
            Thread.sleep(5000);
        }
        catch (InterruptedException e){
            e.printStackTrace();
        }

        onView(withId(R.id.etEmail)).perform(typeText(idLogin), closeSoftKeyboard());
        onView(withId(R.id.etPassword)).perform(typeText("salah"), closeSoftKeyboard());
        onView(withId(R.id.btnSignin)).perform(click());

        try {
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        onView(withText(R.string.etIncorrect)).check(matches(withText("Username / Pass is incorrect")));
    }

    @Test
    public void emptyPassword() {
        try {
            Thread.sleep(5000);
        }
        catch (InterruptedException e){
            e.printStackTrace();
        }

        onView(withId(R.id.etEmail)).perform(typeText(idLogin), closeSoftKeyboard());
        onView(withId(R.id.btnSignin)).perform(click());
        try {
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        onView(withText(R.string.etPass)).check(matches(withText("Pass is empty")));
        //onView(withText(R.string.etemail)).check(matches(withText("Username is empty")));
    }

    @Test
    public void aloginTest3() {
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


    }


    private String getString(@StringRes int resourceId) {
        return loginActivityActivityTestRule.getActivity().getString(resourceId);
    }

    /*private static Matcher<View> withError(final String expected) {
        return new TypeSafeMatcher<View>() {
            @Override
            protected boolean matchesSafely(View item) {
                if (item instanceof EditText) {
                    return ((EditText)item).getError()!=null&&((EditText)item).getError().toString().equals(expected);
                }
                return false;
            }

            @Override
            public void describeTo(Description description) {
                description.appendText("Not found error message" + expected + ", find it!");
            }
        };
    }*/



}
