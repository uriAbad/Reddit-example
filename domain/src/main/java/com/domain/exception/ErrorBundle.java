package com.domain.exception;

/**
 * Created by Uri Abad on 22/08/16.
 * Seidor S.A.
 * oabad@seidor.es
 */
public interface ErrorBundle {
    Exception getException();
    String getErrorMessage();
}
