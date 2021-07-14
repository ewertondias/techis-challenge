package com.techis.starwarsplanets.domain.exception;

public class BusinessException extends RuntimeException {

    private static final long serialVersionUID = 6944938364855951228L;

    public BusinessException(String message) {
        super(message);
    }

    public BusinessException(String message, Throwable cause) {
        super(message, cause);
    }

}
