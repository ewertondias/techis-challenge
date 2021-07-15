package com.techis.starwarsplanets.domain.exception;

public abstract class ResourceNotFoundException extends BusinessException {

    private static final long serialVersionUID = 2454651115468489793L;

    ResourceNotFoundException(String message) {
        super(message);
    }

}
