package testing.data;

import javax.inject.Inject;
import javax.inject.Singleton;
//import testing.data.repository.countryOLD.CountryDataStoreFactory;

/**
 * Created by Uri Abad on 22/08/16.
 * Seidor S.A.
 * oabad@seidor.es
 */

@Singleton
public class CountryDataRepository /*implements CountryRepository*/ {

//    private static CountryDataRepository INSTANCE;
//
//    public static synchronized CountryDataRepository getInstance(
//            CountryDataStoreFactory countryDataStoreFactory,
//            CountryEntityDataMapper countryEntityDataMapper) {
//        if(INSTANCE == null){
//            INSTANCE = new CountryDataRepository(countryDataStoreFactory,countryEntityDataMapper);
//        }
//
//        return INSTANCE;
//    }

//    private final CountryDataStoreFactory countryDataStoreFactory;
//    private final CountryEntityDataMapper countryEntityDataMapper;

//    @Inject
//    protected CountryDataRepository(CountryDataStoreFactory countryDataStoreFactory,
//                                    CountryEntityDataMapper countryEntityDataMapper){
//        this.countryDataStoreFactory = countryDataStoreFactory;
//        this.countryEntityDataMapper = countryEntityDataMapper;
//    }

    @Inject
    public CountryDataRepository() {
//        this.countryDataStoreFactory = null;
//        this.countryEntityDataMapper = null;
    }

//    @Override
//    public void getCountryList(final CountryListCallback callback) {
//        CountryDataStore cloudCountryDataStore = countryDataStoreFactory.createCloudCountryDataStore();
//        cloudCountryDataStore.loadCountries(new CountryDataStore.LoadCountriesCallback() {
//            @Override
//            public void onCountriesLoaded(Collection<CountryEntity> countries) {
//                callback.onCountryListLoaded(countryEntityDataMapper.transform(countries));
//            }
//
//            @Override
//            public void onError(Exception e) {
//                callback.onError(new RespositoryErrorBundle(e));
//            }
//        });
//    }
}
