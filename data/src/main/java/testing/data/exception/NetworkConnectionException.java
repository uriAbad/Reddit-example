package testing.data.exception;

/**
 * Created by Uri Abad on 06/10/2016.
 * Seidor S.A.
 * oabad@seidor.es
 */

public class NetworkConnectionException extends Exception {

    public NetworkConnectionException() {
        super();
    }

    public NetworkConnectionException(String message) {
        super(message);
    }

    public NetworkConnectionException(String message, Throwable cause) {
        super(message, cause);
    }

    public NetworkConnectionException(Throwable cause) {
        super(cause);
    }
}
