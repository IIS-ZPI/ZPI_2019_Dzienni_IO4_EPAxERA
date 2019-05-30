package com.epaxera.zpiserver.services.error;

public class URLNotFound extends RuntimeException {

    public URLNotFound() {
    }

    public URLNotFound(String message) {
        super(message);
    }

    public URLNotFound(String message, Throwable cause) {
        super(message, cause);
    }

    public URLNotFound(Throwable cause) {
        super(cause);
    }

    public URLNotFound(String message, Throwable cause, boolean enableSuppression, boolean writableStackTrace) {
        super(message, cause, enableSuppression, writableStackTrace);
    }

}
