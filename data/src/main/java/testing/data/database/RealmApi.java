package testing.data.database;

import java.util.Collection;

import testing.data.entity.CountryEntity;

/**
 * Created by Uri Abad on 22/08/16.
 * Seidor S.A.
 * oabad@seidor.es
 */
public interface RealmApi {

    interface CountryListCallback{
        void onCountryListLoaded(Collection<CountryEntity> countryEntityCollection);
        void onError(Exception exception);
    }

    void getCountries(CountryListCallback countryListCallback);

    void putCountries(Collection<CountryEntity> countryEntities);
}
