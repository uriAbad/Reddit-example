package ctesting.cleancountries.internal.di.component;

import ctesting.cleancountries.internal.di.ApplicationComponent;
import ctesting.cleancountries.internal.di.PerActivity;
import ctesting.cleancountries.internal.di.module.ActivityModule;
import ctesting.cleancountries.internal.di.module.UserModule;
import ctesting.cleancountries.view.fragment.UserListFragment;
import dagger.Component;

/**
 * Created by Uri Abad on 29/09/2016.
 * Seidor S.A.
 * oabad@seidor.es
 */
@PerActivity
@Component(dependencies = ApplicationComponent.class,
           modules = {ActivityModule.class,UserModule.class})
public interface UserComponent extends ActivityComponent{
    void inject(UserListFragment userListFragment);
}
