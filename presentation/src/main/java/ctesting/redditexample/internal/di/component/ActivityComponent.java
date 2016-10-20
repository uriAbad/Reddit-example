package ctesting.redditexample.internal.di.component;

import android.app.Activity;

import ctesting.redditexample.internal.di.PerActivity;
import ctesting.redditexample.internal.di.module.ActivityModule;
import dagger.Component;

/**
 * Created by Uri Abad on 28/09/2016.
 * Seidor S.A.
 * oabad@seidor.es
 */
@PerActivity
@Component(dependencies = ApplicationComponent.class,modules = ActivityModule.class)
public interface ActivityComponent {

    Activity activity();
}
