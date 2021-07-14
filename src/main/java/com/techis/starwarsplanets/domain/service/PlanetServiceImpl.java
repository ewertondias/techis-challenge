package com.techis.starwarsplanets.domain.service;

import com.techis.starwarsplanets.domain.Planet;
import com.techis.starwarsplanets.domain.repository.PlanetServiceRepository;

public class PlanetServiceImpl implements PlanetService {

    private final PlanetServiceRepository planetServiceRepository;

    public PlanetServiceImpl(final PlanetServiceRepository planetServiceRepository) {
        this.planetServiceRepository = planetServiceRepository;
    }

    @Override
    public Planet insert(final Planet planet) {
        return planetServiceRepository.insert(planet);
    }

}
