package ctesting.redditexample.internal.di.component;

import ctesting.redditexample.internal.di.PerActivity;
import ctesting.redditexample.internal.di.module.ActivityModule;
import ctesting.redditexample.internal.di.module.UserModule;
import ctesting.redditexample.view.fragment.PostListFragment;
import dagger.Component;

/**
 * Created by Uri Abad on 29/09/2016.
 * Seidor S.A.
 * oabad@seidor.es
 */
@PerActivity
@Component(dependencies = ApplicationComponent.class,
           modules = {ActivityModule.class,UserModule.class})
public interface PostComponent extends ActivityComponent{
    void inject(PostListFragment postListFragment);
}
