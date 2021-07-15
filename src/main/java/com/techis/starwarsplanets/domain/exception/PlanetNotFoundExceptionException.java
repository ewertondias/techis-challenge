package com.techis.starwarsplanets.domain.exception;

public class PlanetNotFoundExceptionException extends ResourceNotFoundException {

    private static final long serialVersionUID = 8620839823390014322L;

    public PlanetNotFoundExceptionException(String message) {
        super(message);
    }

}
