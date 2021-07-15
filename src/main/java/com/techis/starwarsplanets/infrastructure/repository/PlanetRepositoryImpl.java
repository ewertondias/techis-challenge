package com.techis.starwarsplanets.infrastructure.repository;

import com.techis.starwarsplanets.domain.model.Planet;
import com.techis.starwarsplanets.domain.repository.PlanetRepository;
import com.techis.starwarsplanets.infrastructure.assembler.PlanetEntityAssembler;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class PlanetRepositoryImpl implements PlanetRepository {

    private final PlanetMongoRepository planetMongoRepository;
    private final PlanetEntityAssembler planetEntityAssembler;

    public PlanetRepositoryImpl(final PlanetMongoRepository planetMongoRepository,
                                final PlanetEntityAssembler planetEntityAssembler) {
        this.planetMongoRepository = planetMongoRepository;
        this.planetEntityAssembler = planetEntityAssembler;
    }

    @Override
    public Planet insert(final Planet planet) {
        final var planetEntity = planetEntityAssembler.toEntity(planet);

        final var newPlanet = planetMongoRepository.insert(planetEntity);

        return planetEntityAssembler.toModel(newPlanet);
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
