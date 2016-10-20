package ctesting.redditexample.internal.di.module;

import com.domain.interactor.GetPostControversialList;
import com.domain.interactor.GetPostHotList;
import com.domain.interactor.GetPostNewList;
import com.domain.interactor.UseCase;

import javax.inject.Named;

import ctesting.redditexample.internal.di.PerActivity;
import dagger.Module;
import dagger.Provides;

/**
 * Created by Uri Abad on 29/09/2016.
 * Seidor S.A.
 * oabad@seidor.es
 */

@Module
public class UserModule {

    private int userId = -1;

    public UserModule() {
    }

    public UserModule(int userId) {
        this.userId = userId;
    }

    @Provides
    @PerActivity
    @Named("postListNew")
    UseCase provideGetPostListNewUseCase(GetPostNewList getPostNewList){
        return getPostNewList;
    }

    @Provides
    @PerActivity
    @Named("postListHot")
    UseCase provideGetPostListHotUseCase(GetPostHotList getPostNewList){
        return getPostNewList;
    }

    @Provides
    @PerActivity
    @Named("postListControversial")
    UseCase provideGetPostListControversialUseCase(GetPostControversialList getPostNewList){
        return getPostNewList;
    }
}
