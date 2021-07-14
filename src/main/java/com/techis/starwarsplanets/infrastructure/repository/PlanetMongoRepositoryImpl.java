package com.techis.starwarsplanets.infrastructure.repository;

import com.techis.starwarsplanets.domain.Planet;
import com.techis.starwarsplanets.domain.repository.PlanetServiceRepository;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class PlanetMongoRepositoryImpl implements PlanetServiceRepository {

    @Override
    public Planet insert(Planet planet) {
        // TODO Implement
        return null;
    }

    @Override
    public List<Planet> listDatabase() {
        // TODO Implement
        return null;
    }

    @Override
    public List<Planet> listApi() {
        // TODO Implement
        return null;
    }

    @Override
    public Planet findByName(String name) {
        // TODO Implement
        return null;
    }

    @Override
    public Planet findById(Long id) {
        // TODO Implement
        return null;
    }

    @Override
    public void remove(Long id) {
        // TODO Implement
    }

}
