package com.domain.exception;

/**
 * Created by Uri Abad on 22/08/16.
 * Seidor S.A.
 * oabad@seidor.es
 */
public class DefaultErrorBundle implements ErrorBundle {

    private static final String DEFAULT_ERROR_MSG = "Unknown Error";
    private final Exception exception;

    public DefaultErrorBundle(Exception exception) {
        this.exception = exception;
    }

    @Override
    public Exception getException() {
        return exception;
    }

    @Override
    public String getErrorMessage() {
        return (exception != null) ? exception.getMessage() : DEFAULT_ERROR_MSG;
    }
}
