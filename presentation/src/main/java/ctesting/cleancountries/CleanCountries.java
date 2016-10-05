package ctesting.cleancountries;

import android.app.Application;

import com.facebook.stetho.Stetho;
import com.uphyca.stetho_realm.RealmInspectorModulesProvider;

import ctesting.cleancountries.internal.di.ApplicationComponent;
import ctesting.cleancountries.internal.di.ApplicationModule;
import ctesting.cleancountries.internal.di.DaggerApplicationComponent;
import ctesting.cleancountries.internal.di.module.NetModule;
import timber.log.Timber;

/**
 * Created by Uri Abad on 24/08/16.
 * Seidor S.A.
 * oabad@seidor.es
 */
public class CleanCountries extends Application {

    private ApplicationComponent applicationComponent;

    public ApplicationComponent getApplicationComponent() {
        return applicationComponent;
    }


    @Override
    public void onCreate() {
        super.onCreate();

        initializeInjection();
        if(BuildConfig.DEBUG){
            initializeStheto();
            initializeTimber();
        }

    }

    private void initializeInjection() {
        this.applicationComponent = DaggerApplicationComponent.builder()
                .applicationModule(new ApplicationModule(this))
                .netModule(new NetModule(this))
                .build();
    }

    private void initializeTimber() {
            Timber.plant(new Timber.DebugTree());
    }

    private void initializeStheto(){
        Stetho.initialize(
                Stetho.newInitializerBuilder(this)
                    .enableDumpapp(Stetho.defaultDumperPluginsProvider(this))
                        .enableWebKitInspector(Stetho.defaultInspectorModulesProvider(this))
                    .enableWebKitInspector(RealmInspectorModulesProvider.builder(this).build())
                .build()
        );
    }

}
