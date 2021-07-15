package com.techis.starwarsplanets.infrastructure.repository;

import org.springframework.data.mongodb.repository.MongoRepository;

import java.util.List;

public interface PlanetMongoRepository extends MongoRepository<PlanetEntity, String> {

    List<PlanetEntity> findByName(final String name);

}
