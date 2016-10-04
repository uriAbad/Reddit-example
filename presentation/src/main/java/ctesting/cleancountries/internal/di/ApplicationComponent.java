package ctesting.cleancountries.internal.di;

import android.content.Context;

import com.domain.executor.PostExecutionThread;
import com.domain.executor.ThreadExecutor;
import com.domain.repository.UserRepository;

import javax.inject.Singleton;

import ctesting.cleancountries.internal.di.module.NetModule;
import ctesting.cleancountries.view.activity.BaseActivity;
import dagger.Component;

/**
 * Created by Uri Abad on 27/09/2016.
 * Seidor S.A.
 * oabad@seidor.es
 */
@Singleton
@Component(modules = {ApplicationModule.class , NetModule.class})
public interface ApplicationComponent {

    void inject(BaseActivity baseActivity);

    //Exposed to subgraphs
    Context context();
    ThreadExecutor threadExecutor();
    PostExecutionThread postExecutionThread();
    UserRepository userRepository();
}
