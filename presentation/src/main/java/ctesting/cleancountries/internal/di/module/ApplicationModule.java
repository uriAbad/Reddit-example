package ctesting.cleancountries.internal.di.module;

import android.content.Context;

import com.domain.executor.PostExecutionThread;
import com.domain.executor.ThreadExecutor;
import com.domain.repository.UserRepository;

import javax.inject.Singleton;

import ctesting.cleancountries.CleanCountries;
import ctesting.cleancountries.UIThread;
import dagger.Module;
import dagger.Provides;
import testing.data.UserDataRepository;
import testing.data.executor.JobExecutor;

/**
 * Created by Uri Abad on 27/09/2016.
 * Seidor S.A.
 * oabad@seidor.es
 */

@Module
public class ApplicationModule {

    private final CleanCountries application;

    public ApplicationModule(CleanCountries application) {
        this.application = application;
    }

    @Provides
    @Singleton
    Context provideApplicationContext(){
        return this.application;
    }

    @Provides
    @Singleton
    ThreadExecutor provideThreadExecutor(JobExecutor jobExecutor){
        return jobExecutor;
    }

    @Provides
    @Singleton
    PostExecutionThread providePostExecutionThread(UIThread uiThread){
        return uiThread;
    }

    @Provides
    @Singleton
    UserRepository provideUserRepository(UserDataRepository userDataRepository){
        return userDataRepository;
    }
}
