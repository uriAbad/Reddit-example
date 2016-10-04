package testing.data.database;

import android.content.Context;
import android.util.Log;

import java.util.Collection;

import io.realm.RealmResults;
import testing.data.entity.CountryEntity;

/**
 * Created by Uri Abad on 22/08/16.
 * Seidor S.A.
 * oabad@seidor.es
 */
public class RealmApiImpl implements RealmApi {

    private RealmService realmService;

    public RealmApiImpl(Context context) {
        if(context == null){
            throw new IllegalArgumentException("Constructor parameters null");
        }
        this.realmService = new RealmService(context);
    }


    @Override
    public void getCountries(CountryListCallback countryListCallback) {
        try {
            RealmResults<CountryEntity> countryEntityRealmResults = realmService.getCountryList();
            countryListCallback.onCountryListLoaded(countryEntityRealmResults);
        }catch (Exception e ){
            countryListCallback.onError(e);
        }
    }

    @Override
    public void putCountries(Collection<CountryEntity> countryEntities) {
        realmService.saveCountries(countryEntities, new RealmService.CallbackRealmService() {
            @Override
            public void notifyOnSuccessTransaction() {

            }

            @Override
            public void notiftyOnErrorTransaction(Throwable t) {
                //TODO: improve this..
                Log.e("putCountries","PERSISTANCE FAILURE");
            }
        });
    }
}
