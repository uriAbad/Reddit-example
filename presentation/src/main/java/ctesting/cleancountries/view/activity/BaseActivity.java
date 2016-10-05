package ctesting.cleancountries.view.activity;

import android.app.Activity;
import android.app.Fragment;
import android.app.FragmentTransaction;
import android.os.Bundle;

import javax.inject.Inject;

import ctesting.cleancountries.CleanCountries;
import ctesting.cleancountries.Navigator.Navigator;
import ctesting.cleancountries.internal.di.ApplicationComponent;
import ctesting.cleancountries.internal.di.module.ActivityModule;

/**
 * Created by Uri Abad on 23/08/16.
 * Seidor S.A.
 * oabad@seidor.es
 */
public abstract class BaseActivity extends Activity {

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
        return ((CleanCountries)getApplication()).getApplicationComponent();
    }

    protected ActivityModule getActivityModule() {
        return new ActivityModule(this);
    }

}
