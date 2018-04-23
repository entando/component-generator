package org.entando.edo.parser;


public class EdoInputException extends RuntimeException {

    public EdoInputException() {
        super();
    }

    public EdoInputException(String message, Throwable cause, boolean enableSuppression, boolean writableStackTrace) {
        super(message, cause, enableSuppression, writableStackTrace);
    }

    public EdoInputException(String message, Throwable cause) {
        super(message, cause);
    }

    public EdoInputException(String message) {
        super(message);
    }

    public EdoInputException(Throwable cause) {
        super(cause);
    }

}
