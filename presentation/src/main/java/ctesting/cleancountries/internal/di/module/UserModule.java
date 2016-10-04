package ctesting.cleancountries.internal.di.module;

import com.domain.interactor.GetUserList;
import com.domain.interactor.UseCase;

import javax.inject.Named;

import ctesting.cleancountries.internal.di.PerActivity;
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
    @Named("userList")
    UseCase provideGetUserListUseCase(GetUserList getUserList){
        return getUserList;
    }
}
