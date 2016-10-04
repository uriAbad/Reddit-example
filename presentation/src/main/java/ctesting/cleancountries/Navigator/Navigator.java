package ctesting.cleancountries.Navigator;

import android.content.Context;
import android.content.Intent;

import javax.inject.Inject;
import javax.inject.Singleton;

import ctesting.cleancountries.view.activity.UserListActivity;

/**
 * Created by Uri Abad on 23/08/16.
 * Seidor S.A.
 * oabad@seidor.es
 */
@Singleton
public class Navigator {

    @Inject
    public Navigator() {
    }

    public void navigateToUserList(Context context){
        if(context != null){
            Intent intentTolauch = UserListActivity.getCallingIntent(context);
            context.startActivity(intentTolauch);
        }
    }
}
