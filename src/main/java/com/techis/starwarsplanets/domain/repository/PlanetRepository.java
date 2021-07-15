package com.techis.starwarsplanets.domain.repository;

import com.techis.starwarsplanets.domain.model.Planet;

import java.util.List;
import java.util.Optional;

public interface PlanetRepository {

    // TODO verificar Optional
    Planet insert(final Planet planet);

    List<Planet> listDatabase();

    List<Planet> listApi();

    List<Planet> findByName(final String name);

    Optional<Planet> findById(final String id);

    void remove(final String id);

}
