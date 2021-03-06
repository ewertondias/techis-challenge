package com.techis.starwarsplanets.domain.repository;

import com.techis.starwarsplanets.domain.model.Planet;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.List;
import java.util.Optional;

public interface PlanetRepository {

    Planet insert(final Planet planet);

    Page<Planet> listDatabase(final Pageable pageable);

    List<Planet> listApi(final Pageable pageable);

    Optional<Planet> findByName(final String name);

    Optional<Planet> findById(final String id);

    void delete(final String id);

    Integer findMovieAppearances(final Planet planet);

}
