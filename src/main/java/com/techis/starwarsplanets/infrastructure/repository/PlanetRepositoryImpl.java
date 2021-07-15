package com.techis.starwarsplanets.infrastructure.repository;

import com.techis.starwarsplanets.domain.model.Planet;
import com.techis.starwarsplanets.domain.repository.PlanetRepository;
import com.techis.starwarsplanets.infrastructure.assembler.PlanetEntityAssembler;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.Optional;

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
        var planetEntities = planetMongoRepository.findAll();

        return planetEntityAssembler.toCollectionModel(planetEntities);
    }

    @Override
    public List<Planet> listApi() {
        // TODO Implement
        return null;
    }

    @Override
    public List<Planet> findByName(final String name) {
        final var planetEntities = planetMongoRepository.findByName(name);

        return planetEntityAssembler.toCollectionModel(planetEntities);
    }

    @Override
    public Optional<Planet> findById(final String id) {
        return planetMongoRepository.findById(id)
            .map(planetEntityAssembler::toModel);
    }

    @Override
    public void remove(final String id) {
        // TODO Verificar se existe
        planetMongoRepository.deleteById(id);
    }

}
