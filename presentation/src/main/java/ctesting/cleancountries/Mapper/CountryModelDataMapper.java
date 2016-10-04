package ctesting.cleancountries.Mapper;

import com.domain.Country;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;

import ctesting.cleancountries.Model.CountryModel;

/**
 * Created by Uri Abad on 23/08/16.
 * Seidor S.A.
 * oabad@seidor.es
 */
public class CountryModelDataMapper {

    public CountryModelDataMapper() {
    }

    public CountryModel transform(Country country){
        if(country == null){
            throw new IllegalArgumentException("Cannot trnasform null value");
        }
        CountryModel countryModel = new CountryModel();
        countryModel.setName(country.getName());
        countryModel.setCapital(country.getCapital());
        countryModel.setDenomination(country.getDenomination());
        countryModel.setPopulation(country.getPopulation());
        countryModel.setRegion(country.getRegion());

        return countryModel;
    }

    public Collection<CountryModel> transform(Collection<Country> countryCollection){
        Collection<CountryModel> countryModelCollection;

        if(countryCollection != null && !countryCollection.isEmpty()){
            countryModelCollection = new ArrayList<CountryModel>();
            for(Country country : countryCollection){
                countryModelCollection.add(transform(country));
            }
        }else{
            countryModelCollection = Collections.emptyList();
        }

        return countryModelCollection;
    }
}
