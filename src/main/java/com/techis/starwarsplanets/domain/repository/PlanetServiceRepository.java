package com.techis.starwarsplanets.domain.repository;

import com.techis.starwarsplanets.domain.Planet;

import java.util.List;

public interface PlanetServiceRepository {

    // TODO verificar Optional
    Planet insert(final Planet planet);

    List<Planet> listDatabase();

    List<Planet> listApi();

    // TODO verificar Optional
    Planet findByName(final String name);

    Planet findById(final Long id);

    void remove(final Long id);

}
