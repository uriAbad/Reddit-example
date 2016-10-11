package com.domain.repository;

import com.domain.Post;

import java.util.List;

import rx.Observable;

/**
 * Created by Uri Abad on 10/10/2016.
 * Seidor S.A.
 * oabad@seidor.es
 */

public interface PostRepository {

    Observable<List<Post>> posts();

    Observable<List<Post>> postsHot();

    Observable<List<Post>> postsControversial();
}
