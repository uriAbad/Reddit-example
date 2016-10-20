package ctesting.redditexample.internal.di.component;

import android.content.Context;
import android.content.SharedPreferences;

import com.domain.executor.PostExecutionThread;
import com.domain.executor.ThreadExecutor;
import com.domain.repository.PostRepository;

import javax.inject.Singleton;

import ctesting.redditexample.internal.di.module.ApplicationModule;
import ctesting.redditexample.internal.di.module.NetModule;
import ctesting.redditexample.internal.di.module.RealmModule;
import ctesting.redditexample.view.activity.BaseActivity;
import dagger.Component;
import retrofit2.Retrofit;
import testing.data.net.RedditService;

/**
 * Created by Uri Abad on 27/09/2016.
 * Seidor S.A.
 * oabad@seidor.es
 */
@Singleton
@Component(modules = {  ApplicationModule.class,
                        NetModule.class,
                        RealmModule.class })
public interface ApplicationComponent {

    void inject(BaseActivity baseActivity);

    //Exposed to subgraphs
    Context context();
    ThreadExecutor threadExecutor();
    PostExecutionThread postExecutionThread();
    PostRepository postRepository();

    Retrofit retrofit();
    RedditService redditService();
    SharedPreferences sharedPreferences();
}
