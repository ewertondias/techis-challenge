package com.techis.starwarsplanets.infrastructure.repository;

import lombok.Getter;
import lombok.Setter;

import java.io.Serializable;

@Getter
@Setter
public class PlanetResponseResultApi implements Serializable {

    private static final long serialVersionUID = -4441054220336921575L;

    private String name;
    private String climate;
    private String terrain;

}
