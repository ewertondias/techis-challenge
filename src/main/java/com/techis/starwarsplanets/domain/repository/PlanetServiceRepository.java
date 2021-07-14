package com.techis.starwarsplanets.domain.repository;

import com.techis.starwarsplanets.domain.Planet;

public interface PlanetServiceRepository {

    Planet insert(final Planet planet);

}
