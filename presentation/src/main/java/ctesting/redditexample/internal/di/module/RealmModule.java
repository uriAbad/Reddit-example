package ctesting.redditexample.internal.di.module;

import javax.inject.Singleton;

import ctesting.redditexample.RedditSample;
import dagger.Module;
import dagger.Provides;
import io.realm.Realm;
import io.realm.RealmConfiguration;
import testing.data.cache.PostCache;
import testing.data.cache.PostCacheImpl;

/**
 * Created by Uri Abad on 06/10/2016.
 * Seidor S.A.
 * oabad@seidor.es
 */

@Module
public class RealmModule {

    private final RedditSample application;

    public RealmModule(RedditSample application) {
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
    PostCache providePostCache(PostCacheImpl postCacheImpl){
        return postCacheImpl;
    }


}
