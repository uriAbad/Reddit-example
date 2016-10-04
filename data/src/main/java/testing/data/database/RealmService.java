package testing.data.database;

import android.content.Context;

import java.util.Collection;

import io.realm.Realm;
import io.realm.RealmConfiguration;
import io.realm.RealmResults;
import testing.data.entity.CountryEntity;

/**
 * Created by Uri Abad on 22/08/16.
 * Seidor S.A.
 * oabad@seidor.es
 */

public class RealmService {

    interface CallbackRealmService{
        void notifyOnSuccessTransaction();
        void notiftyOnErrorTransaction(Throwable t);
    }

//    private Realm realm;
    RealmConfiguration realmConfiguration;

    public RealmService(Context context) {
        realmConfiguration = new RealmConfiguration.Builder(context.getApplicationContext()).build();
//        this.realm = Realm.getInstance(realmConfiguration);
    }

    public RealmResults<CountryEntity> getCountryList(){
        return Realm.getInstance(realmConfiguration).where(CountryEntity.class).findAll();
    }

    public void saveCountries(final Collection<CountryEntity> countries, final CallbackRealmService callbackRealmService){

        final Realm.Transaction.OnSuccess success = new Realm.Transaction.OnSuccess() {
            @Override
            public void onSuccess() {
                callbackRealmService.notifyOnSuccessTransaction();
            }
        };

        final Realm.Transaction.OnError error = new Realm.Transaction.OnError() {
            @Override
            public void onError(Throwable error) {
                callbackRealmService.notiftyOnErrorTransaction(error);
            }
        };

        Realm realm = Realm.getInstance(realmConfiguration);
        Realm.getInstance(realmConfiguration).executeTransactionAsync(new Realm.Transaction() {
            @Override
            public void execute(Realm realm) {
                realm.copyToRealmOrUpdate(countries);
            }
        },success,error);
    };

//    public void stopService(){
//        if(realm != null){
//            realm.close();
//        }
//    }


}
