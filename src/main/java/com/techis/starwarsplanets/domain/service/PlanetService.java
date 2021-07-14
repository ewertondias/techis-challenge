package com.techis.starwarsplanets.domain.service;

import com.techis.starwarsplanets.domain.Planet;

public interface PlanetService {

    Planet insert(final Planet planet);

    /*List<Planet> listDatabase();

    List<Planet> listApi();

    List<Planet> findByName(final String name);

    Planet findById(final Long id);

    void remove(final Long id);*/

}
