package ctesting.cleancountries.view.activity;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.support.v4.view.MenuItemCompat;
import android.util.Log;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Spinner;

import butterknife.BindArray;
import butterknife.ButterKnife;
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

    @BindArray(R.array.items_list) String[] menu_items;
    private static UserListFragment userListFragment;

    public static Intent getCallingIntent(Context context){
        return new Intent(context, UserListActivity.class);
    }

    private UserComponent userComponent;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_layout);
        ButterKnife.bind(this);

        this.initializeInjector();
        if(savedInstanceState == null) {
            userListFragment = new UserListFragment();
            addFragment(R.id.fragmentContainer, userListFragment);
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

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        MenuInflater inflater = getMenuInflater();
        inflater.inflate(R.menu.menu_list_post, menu);

        MenuItem item = menu.findItem(R.id.menu_spinner);
        Spinner spinner = (Spinner) MenuItemCompat.getActionView(item);
        configureSpinner(spinner);

        return true;
    }

    private void configureSpinner(final Spinner spinner){
        ArrayAdapter<String> spinnerArrayAdapter = new ArrayAdapter<String>(this, android.R
                .layout.simple_spinner_item, menu_items); //selected item will look like a spinner set from XML
        spinnerArrayAdapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        spinner.setAdapter(spinnerArrayAdapter);
        spinner.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> adapterView, View view, int i, long l) {
                String item = spinner.getSelectedItem().toString();
                Log.i("Selected item : ", item);
                userListFragment.loadData(item);
            }

            @Override
            public void onNothingSelected(AdapterView<?> adapterView) {

            }
        });
    }
}
