package com.techis.starwarsplanets.domain.service;

import com.techis.starwarsplanets.domain.Planet;
import com.techis.starwarsplanets.domain.repository.PlanetServiceRepository;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;

class PlanetServiceTest {

    @Test
    void deveCadastrarUmPlanetaComSucesso() {
        final Planet planetRequest = Planet.builder()
            .name("Dagobah")
            .climate("Murky")
            .terrain("Swamp")
            .build();

        PlanetServiceRepository planetServiceRepositoryMock = Mockito.mock(PlanetServiceRepository.class);
        Mockito.when(planetServiceRepositoryMock.insert(Mockito.any())).thenReturn(planetRequest);

        final PlanetService planetService = new PlanetServiceImpl(planetServiceRepositoryMock);

        final Planet planet = planetService.insert(planetRequest);

        Assertions.assertNotNull(planet);
    }

}
