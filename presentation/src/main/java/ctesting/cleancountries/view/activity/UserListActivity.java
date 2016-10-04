package ctesting.cleancountries.view.activity;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;

import ctesting.cleancountries.R;
import ctesting.cleancountries.internal.di.HasComponent;
import ctesting.cleancountries.internal.di.component.DaggerUserComponent;
import ctesting.cleancountries.internal.di.component.UserComponent;
import ctesting.cleancountries.view.fragment.UserListFragment;


/**
 * Created by Uri Abad on 28/09/2016.
 * Seidor S.A.
 * oabad@seidor.es
 */

public class UserListActivity extends BaseActivity implements HasComponent<UserComponent> {

    public static Intent getCallingIntent(Context context){
        return new Intent(context, UserListActivity.class);
    }

    private UserComponent userComponent;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_layout);

        this.initializeInjector();
        if(savedInstanceState == null) {
            addFragment(R.id.fragmentContainer, new UserListFragment());
        }
    }

    private void initializeInjector() {
        this.userComponent = DaggerUserComponent.builder()
                .applicationComponent(getApplicationComponent())
                .activityModule(getActivityModule())
                .build();
    }

    @Override
    public UserComponent getComponent() {
        return userComponent;
    }
}
