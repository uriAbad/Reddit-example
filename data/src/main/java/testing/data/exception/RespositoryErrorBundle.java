package testing.data.exception;

import com.domain.exception.ErrorBundle;

/**
 * Created by Uri Abad on 24/08/16.
 * Seidor S.A.
 * oabad@seidor.es
 */
public class RespositoryErrorBundle implements ErrorBundle{

    private final Exception exception;

    public RespositoryErrorBundle(Exception exception) {
        this.exception = exception;
    }

    @Override
    public Exception getException() {
        return exception;
    }

    @Override
    public String getErrorMessage() {
        String message = "";
        if(this.exception != null){
            message = this.exception.getMessage();
        }
        return message;
    }
}
