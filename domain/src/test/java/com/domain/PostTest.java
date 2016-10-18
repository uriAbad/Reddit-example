package com.domain;

import org.junit.Before;
import org.junit.Test;

import static org.hamcrest.CoreMatchers.is;
import static org.hamcrest.MatcherAssert.assertThat;

/**
 * Created by Uri Abad on 18/10/2016.
 * Seidor S.A.
 * oabad@seidor.es
 */

public class PostTest {

    private static final String FAKE_TEST_NAME = "pep";

    private Post post;

    @Before
    public void setUp(){
        post = new Post();
        post.setTitle(FAKE_TEST_NAME);
    }

    @Test
    public void constructorHappyCase(){
        String name = post.getTitle();
        assertThat(name,is(FAKE_TEST_NAME));
    }
}
