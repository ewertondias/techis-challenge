package com.techis.starwarsplanets.infrastructure.repository;

import lombok.Getter;
import lombok.Setter;

import java.io.Serializable;
import java.util.List;

@Getter
@Setter
public class PlanetResponseApi implements Serializable {

    private static final long serialVersionUID = -227057975227290734L;

    private List<PlanetResponseResultApi> results;

}
