package com.techis.starwarsplanets.infrastructure.repository;

import com.techis.starwarsplanets.domain.Planet;
import com.techis.starwarsplanets.domain.repository.PlanetServiceRepository;
import org.springframework.stereotype.Component;

@Component
public class PlanetMongoRepositoryImpl implements PlanetServiceRepository {

    @Override
    public Planet insert(Planet planet) {
        return null;
    }

}
