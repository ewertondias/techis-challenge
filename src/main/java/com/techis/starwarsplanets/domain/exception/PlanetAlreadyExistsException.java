package com.techis.starwarsplanets.domain.exception;

public class PlanetAlreadyExistsException extends BusinessException {

    private static final long serialVersionUID = 4937134412759524465L;

    public PlanetAlreadyExistsException(String message) {
        super(message);
    }

}
