package com.domain.exception;

import org.junit.Before;
import org.junit.Test;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import static org.mockito.Mockito.verify;

/**
 * Created by Uri Abad on 22/08/16.
 * Seidor S.A.
 * oabad@seidor.es
 */
public class DefaultErrorBundleTest {

    private DefaultErrorBundle defaultErrorBundle;

    @Mock private Exception exception;

    @Before
    public void setUp(){
        try {
            MockitoAnnotations.initMocks(this);
        }catch(NullPointerException npe){
            //bug
        }
        defaultErrorBundle = new DefaultErrorBundle(exception);
    }

    @Test
    public void testGetErrorMessageIntereaction(){
        defaultErrorBundle.getErrorMessage();
        verify(exception).getMessage();
    }
}
