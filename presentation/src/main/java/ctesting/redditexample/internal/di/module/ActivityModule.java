package ctesting.redditexample.internal.di.module;

import android.app.Activity;

import ctesting.redditexample.internal.di.PerActivity;
import dagger.Module;
import dagger.Provides;

/**
 * Created by Uri Abad on 28/09/2016.
 * Seidor S.A.
 * oabad@seidor.es
 */

@Module
public class ActivityModule {
    private final Activity activity;

    public ActivityModule(Activity activity) {
        this.activity = activity;
    }

    @Provides
    @PerActivity
    Activity activity(){
        return this.activity;
    }


}
