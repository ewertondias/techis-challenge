package com.techis.starwarsplanets.domain.service;

import com.techis.starwarsplanets.domain.model.Planet;

import java.util.List;

public interface PlanetService {

    Planet insert(final Planet planet);

    List<Planet> listDatabase();

    List<Planet> listApi();

    List<Planet> findByName(final String name);

    Planet findById(final String id);

    void remove(final String id);

}
