package ctesting.redditexample.view.activity;

import android.app.Fragment;
import android.app.FragmentTransaction;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;

import javax.inject.Inject;

import ctesting.redditexample.RedditSample;
import ctesting.redditexample.Navigator.Navigator;
import ctesting.redditexample.internal.di.component.ApplicationComponent;
import ctesting.redditexample.internal.di.module.ActivityModule;

/**
 * Created by Uri Abad on 23/08/16.
 * Seidor S.A.
 * oabad@seidor.es
 */
public abstract class BaseActivity extends AppCompatActivity {

    @Inject Navigator navigator;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        this.getApplicationComponent().inject(this);
    }

    protected void addFragment(int containerViewId, Fragment fragment){
        FragmentTransaction fragmentTransaction = this.getFragmentManager().beginTransaction();
        fragmentTransaction.add(containerViewId,fragment);
        fragmentTransaction.commit();
    }

    protected ApplicationComponent getApplicationComponent(){
        return ((RedditSample)getApplication()).getApplicationComponent();
    }

    protected ActivityModule getActivityModule() {
        return new ActivityModule(this);
    }

}
