package com.domain.repository;

import com.domain.User;

import java.util.List;

import rx.Observable;

/**
 * Created by Uri Abad on 28/09/2016.
 * Seidor S.A.
 * oabad@seidor.es
 */

public interface UserRepository {

    Observable<List<User>> users();

    Observable<User> user(final int id);
}
