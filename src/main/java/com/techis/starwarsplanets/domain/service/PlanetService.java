package com.techis.starwarsplanets.domain.service;

import com.techis.starwarsplanets.domain.model.Planet;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.List;

public interface PlanetService {

    Planet insert(final Planet planet);

    Page<Planet> listDatabase(final Pageable pageable);

    List<Planet> listApi(final Pageable pageable);

    Planet findByName(final String name);

    Planet findById(final String id);

    void delete(final String id);

    Integer findMovieAppearances(final Planet planet);

}
