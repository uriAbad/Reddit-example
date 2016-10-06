package ctesting.cleancountries.internal.di.component;

import android.content.Context;
import android.content.SharedPreferences;

import com.domain.executor.PostExecutionThread;
import com.domain.executor.ThreadExecutor;
import com.domain.repository.UserRepository;

import javax.inject.Singleton;

import ctesting.cleancountries.internal.di.module.ApplicationModule;
import ctesting.cleancountries.internal.di.module.NetModule;
import ctesting.cleancountries.internal.di.module.RealmModule;
import ctesting.cleancountries.view.activity.BaseActivity;
import dagger.Component;
import retrofit2.Retrofit;
import testing.data.cache.UserCache;
import testing.data.net.UserService;

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
    UserRepository userRepository();

    Retrofit retrofit();
    UserService userService();
    SharedPreferences sharedPreferences();

    UserCache userCache();
}
