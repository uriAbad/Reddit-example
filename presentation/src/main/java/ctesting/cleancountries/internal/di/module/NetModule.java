package ctesting.cleancountries.internal.di.module;

import android.content.SharedPreferences;
import android.preference.PreferenceManager;

import com.google.gson.FieldNamingPolicy;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

import java.util.concurrent.TimeUnit;

import javax.inject.Singleton;

import ctesting.cleancountries.CleanCountries;
import dagger.Module;
import dagger.Provides;
import okhttp3.Cache;
import okhttp3.OkHttpClient;
import retrofit2.Retrofit;
import retrofit2.adapter.rxjava.RxJavaCallAdapterFactory;
import retrofit2.converter.gson.GsonConverterFactory;
import testing.data.net.UserService;

/**
 * Created by Uri Abad on 02/10/2016.
 * Seidor S.A.
 * oabad@seidor.es
 */
//TODO: DO NET MODULE LIKE : https://guides.codepath.com/android/Dependency-Injection-with-Dagger-2
@Module
public class NetModule {

    private final static String BASE_URL = "https://jsonplaceholder.typicode.com/";
    private final CleanCountries application;

    public NetModule(CleanCountries application) {
        this.application = application;
    }

    @Provides
    @Singleton
    SharedPreferences providesSharedPreferences(){
        return PreferenceManager.getDefaultSharedPreferences(application);
    }

    @Provides
    @Singleton
    Cache provideOkHttpCache(){
        int cacheSize = 10 * 1024 * 1024;
        Cache cache = new Cache(application.getCacheDir(),cacheSize);
        return cache;
    }

    @Provides
    @Singleton
    Gson provideGson(){
        GsonBuilder gsonBuilder = new GsonBuilder();
        gsonBuilder.setFieldNamingPolicy(FieldNamingPolicy.LOWER_CASE_WITH_UNDERSCORES);
        return gsonBuilder.create();
    }

    @Provides
    @Singleton
    OkHttpClient provideHttpClient(Cache cache){
        OkHttpClient client = new OkHttpClient.Builder()
                .connectTimeout(15, TimeUnit.SECONDS)
                .readTimeout(15,TimeUnit.SECONDS)
                .cache(cache)
                .build();
//        if (BuildConfig.DEBUG) {
//            client.networkInterceptors().add(new StethoInterceptor());
//        }
        return client;
    }

    @Provides
    @Singleton
    Retrofit provideRetrofit(Gson gson, OkHttpClient okHttpClient){
        Retrofit retrofit = new Retrofit.Builder()
                .addCallAdapterFactory(RxJavaCallAdapterFactory.create())
                .addConverterFactory(GsonConverterFactory.create(gson))
                .baseUrl(BASE_URL)
                .client(okHttpClient)
                .build();
        return retrofit;
    }

    @Provides
    @Singleton
    UserService provideUserService(Retrofit retrofit){
        return retrofit.create(UserService.class);
    }
}
