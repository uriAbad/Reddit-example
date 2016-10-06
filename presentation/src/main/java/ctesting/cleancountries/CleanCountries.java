package ctesting.cleancountries;

import android.app.Application;

import com.facebook.stetho.Stetho;
import com.uphyca.stetho_realm.RealmInspectorModulesProvider;

import ctesting.cleancountries.internal.di.component.ApplicationComponent;
import ctesting.cleancountries.internal.di.component.DaggerApplicationComponent;
import ctesting.cleancountries.internal.di.module.ApplicationModule;
import ctesting.cleancountries.internal.di.module.NetModule;
import ctesting.cleancountries.internal.di.module.RealmModule;
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
                .realmModule(new RealmModule(this))
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
