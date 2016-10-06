package ctesting.cleancountries.internal.di.module;

import javax.inject.Singleton;

import ctesting.cleancountries.CleanCountries;
import dagger.Module;
import dagger.Provides;
import io.realm.Realm;
import io.realm.RealmConfiguration;
import testing.data.cache.UserCache;
import testing.data.cache.UserCacheImpl;

/**
 * Created by Uri Abad on 06/10/2016.
 * Seidor S.A.
 * oabad@seidor.es
 */

@Module
public class RealmModule {

    private final CleanCountries application;

    public RealmModule(CleanCountries application) {
        this.application = application;
    }

    @Provides
    @Singleton
    RealmConfiguration provideRealmConfiguration(){
        return new RealmConfiguration.Builder(application)
                .build();
    }

    @Provides
    @Singleton
    Realm provideRealm(RealmConfiguration realmConfiguration){
        return Realm.getInstance(realmConfiguration);
    }

    @Provides
    @Singleton
    UserCache provideUserCache(UserCacheImpl userCacheImpl){
        return userCacheImpl;
    }


}
