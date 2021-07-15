package com.techis.starwarsplanets.infrastructure.repository;

import org.springframework.data.mongodb.repository.MongoRepository;

public interface PlanetMongoRepository extends MongoRepository<PlanetEntity, Long> {
}
