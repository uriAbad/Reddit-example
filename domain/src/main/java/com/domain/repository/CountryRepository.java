package com.domain.repository;

import com.domain.Country;

import java.util.List;

import rx.Observable;

/**
 * Created by Uri Abad on 28/09/2016.
 * Seidor S.A.
 * oabad@seidor.es
 */

//TODO: https://jsonplaceholder.typicode.com/
public interface CountryRepository {

    Observable<List<Country>> countries();

//    Observable<Country> country(final )
}
