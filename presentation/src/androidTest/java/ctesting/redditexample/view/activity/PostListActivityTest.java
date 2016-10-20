package ctesting.redditexample.view.activity;

import android.app.Fragment;
import android.support.test.rule.ActivityTestRule;
import android.support.test.runner.AndroidJUnit4;
import android.view.WindowManager;
import android.widget.Button;

import org.junit.Before;
import org.junit.Rule;
import org.junit.Test;
import org.junit.runner.RunWith;

import ctesting.redditexample.R;

import static android.support.test.espresso.Espresso.onView;
import static android.support.test.espresso.assertion.ViewAssertions.matches;
import static android.support.test.espresso.matcher.ViewMatchers.isDisplayed;
import static android.support.test.espresso.matcher.ViewMatchers.withId;
import static org.hamcrest.CoreMatchers.is;
import static org.hamcrest.CoreMatchers.not;
import static org.hamcrest.CoreMatchers.nullValue;
import static org.hamcrest.MatcherAssert.assertThat;

/**
 * Created by Uri Abad on 17/10/2016.
 * Seidor S.A.
 * oabad@seidor.es
 */

@RunWith(AndroidJUnit4.class)
public class PostListActivityTest {

    @Rule
    public ActivityTestRule<PostListActivity> activityTestRule = new ActivityTestRule
            <PostListActivity>(PostListActivity.class);

    @Before
    public void setUp() {
        final PostListActivity activity = activityTestRule.getActivity();
        Runnable wakeUpDevice = new Runnable() {
            public void run() {
                activity.getWindow().addFlags(WindowManager.LayoutParams.FLAG_TURN_SCREEN_ON |
                        WindowManager.LayoutParams.FLAG_SHOW_WHEN_LOCKED |
                        WindowManager.LayoutParams.FLAG_KEEP_SCREEN_ON);
            }
        };
        activity.runOnUiThread(wakeUpDevice);
    }

    @Test
    public void testContainsButton(){
        PostListActivity postListActivity = activityTestRule.getActivity();
        Button btn = (Button) postListActivity.findViewById(R.id.btn_retry);
        assertThat(btn,is(not(nullValue())));
    }

    @Test
    public void testFragmentSuccesfullyAdded(){
        Fragment userListFragment = activityTestRule.getActivity()
                .getFragmentManager()
                .findFragmentById(R.id.fragmentContainer);
        assertThat(userListFragment,is(not(nullValue())));
    }

    @Test
    public void testHappyCaseViews(){
        onView(withId(R.id.rl_retry)).check(matches(not(isDisplayed())));
        onView(withId(R.id.rl_ProgressBar)).check(matches(not(isDisplayed())));
        onView(withId(R.id.rv_UserList)).check(matches((isDisplayed())));
    }
}
