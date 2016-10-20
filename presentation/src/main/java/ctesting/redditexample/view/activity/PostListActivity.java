package ctesting.redditexample.view.activity;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.support.v4.view.MenuItemCompat;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Spinner;

import butterknife.BindArray;
import butterknife.ButterKnife;
import ctesting.redditexample.R;
import ctesting.redditexample.internal.di.HasComponent;
import ctesting.redditexample.internal.di.component.DaggerPostComponent;
import ctesting.redditexample.internal.di.component.PostComponent;
import ctesting.redditexample.view.fragment.PostListFragment;


/**
 * Created by Uri Abad on 28/09/2016.
 * Seidor S.A.
 * oabad@seidor.es
 */

public class PostListActivity extends BaseActivity implements HasComponent<PostComponent> {

    @BindArray(R.array.items_list) String[] menu_items;
    private static PostListFragment postListFragment;

    public static Intent getCallingIntent(Context context) {
        return new Intent(context, PostListActivity.class);
    }

    private PostComponent postComponent;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_layout);
        ButterKnife.bind(this);

        this.initializeInjector();
        if (savedInstanceState == null) {
            postListFragment = new PostListFragment();
            addFragment(R.id.fragmentContainer, postListFragment);
        }
    }

    private void initializeInjector() {
        this.postComponent = DaggerPostComponent.builder()
                .applicationComponent(getApplicationComponent())
                .activityModule(getActivityModule())
                .build();
    }

    @Override
    public PostComponent getComponent() {
        return postComponent;
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

    private void configureSpinner(final Spinner spinner) {
        ArrayAdapter<String> spinnerArrayAdapter = new ArrayAdapter<String>(this, android.R
                .layout.simple_spinner_item, menu_items); //selected item will look like a spinner set from XML
        spinnerArrayAdapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        spinner.setAdapter(spinnerArrayAdapter);
        spinner.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> adapterView, View view, int i, long l) {
                switch (i){
                    case 0:
                        postListFragment.loadDataNew();
                        break;
                    case 1:
                        postListFragment.loadDataHot();
                        break;
                    case 2:
                        postListFragment.loadDataControversial();
                        break;
                }
            }

            @Override
            public void onNothingSelected(AdapterView<?> adapterView) {

            }
        });
    }

}