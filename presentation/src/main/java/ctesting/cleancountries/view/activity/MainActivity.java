package ctesting.cleancountries.view.activity;

import android.os.Bundle;
import android.widget.Button;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;
import ctesting.cleancountries.R;

public class MainActivity extends BaseActivity {

    @BindView(R.id.mainBtn) Button mainBtn;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        ButterKnife.bind(this);
    }

    @OnClick(R.id.mainBtn)
    void navigateToUserList(){
        this.navigator.navigateToUserList(this);
    }

}
