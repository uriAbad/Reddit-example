package ctesting.redditexample.view;

import android.content.Context;

/**
 * Created by Uri Abad on 23/08/16.
 * Seidor S.A.
 * oabad@seidor.es
 */
public interface LoadDataView {

    void hideLoading();
    void showLoading();

    void showRetry();
    void hideRetry();

    void showError(String message);
    Context context();
}
