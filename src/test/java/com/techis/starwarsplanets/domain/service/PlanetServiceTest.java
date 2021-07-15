package com.techis.starwarsplanets.domain.service;

import com.techis.starwarsplanets.domain.model.Planet;
import com.techis.starwarsplanets.domain.exception.BusinessException;
import com.techis.starwarsplanets.domain.repository.PlanetRepository;
import org.hamcrest.Matchers;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.Optional;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.ArgumentMatchers.anyLong;
import static org.mockito.ArgumentMatchers.anyString;
import static org.mockito.Mockito.doNothing;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

class PlanetServiceTest {

    private static PlanetService planetService;
    private static PlanetRepository planetRepositoryMock;

    @BeforeAll
    static void beforeAll() {
        planetRepositoryMock = Mockito.mock(PlanetRepository.class);
        planetService = new PlanetServiceImpl(planetRepositoryMock);
    }

    @Test
    void deveCadastrarUmPlaneta() {
        final Planet planetRequest = Planet.builder()
            .name("Dagobah")
            .climate("Murky")
            .terrain("Swamp")
            .build();

        when(planetRepositoryMock.insert(Mockito.any())).thenReturn(planetRequest);
        final Planet planet = planetService.insert(planetRequest);

        Assertions.assertNotNull(planet);
    }

    @Test
    void dadoUmRequestInvalido_quandoInserirUmPlaneta_entaoDeveRetornarException() {
        final Planet invalidPlanetRequest = Planet.builder()
            .climate("Murky")
            .terrain("Swamp")
            .build();

        assertThrows(BusinessException.class, () -> planetService.insert(invalidPlanetRequest));
    }

    @Test
    void deveRetornarUmaListaDePlanetasDoBancoDeDados() {
        final List<Planet> planetsMock = Collections.singletonList(
            Planet.builder()
                .name("Dagobah")
                .climate("Murky")
                .terrain("Swamp")
                .movieAppearances(3)
                .build()
        );

        when(planetRepositoryMock.listDatabase()).thenReturn(planetsMock);

        final List<Planet> planets = planetService.listDatabase();

        assertFalse(planets.isEmpty());
        assertThat(planets.size(), Matchers.greaterThanOrEqualTo(1));
    }

    @Test
    void deveRetornarUmaListaDePlanetasDaApi() {
        final List<Planet> planetsMock = Collections.singletonList(
            Planet.builder()
                .name("Dagobah")
                .climate("Murky")
                .terrain("Swamp")
                .movieAppearances(3)
                .build()
        );

        when(planetRepositoryMock.listApi(any())).thenReturn(planetsMock);

        // TODO ajustar pageable
        final List<Planet> planets = planetService.listApi(null);

        assertFalse(planets.isEmpty());
        assertThat(planets.size(), Matchers.greaterThanOrEqualTo(1));
    }

    @Test
    void dadoUmNome_deveRetornarUmOuMaisPlanetas() {
        final String planetNameSearch = "Dagobah";

        final List<Planet> planetsMock = Collections.singletonList(
            Planet.builder()
                .name("Dagobah")
                .climate("Murky")
                .terrain("Swamp")
                .movieAppearances(3)
                .build()
        );

        when(planetRepositoryMock.findByName(anyString())).thenReturn(planetsMock);

        final List<Planet> planets = planetService.findByName(planetNameSearch);

        assertFalse(planets.isEmpty());
        assertThat(planets.size(), Matchers.greaterThanOrEqualTo(1));
    }

    @Test
    void dadoUmId_deveRetornarUmPlaneta() {
        final String planetIdSearch = "60efadad6023686be98177d8";

        final Planet planetMock = Planet.builder()
            .name("Dagobah")
            .climate("Murky")
            .terrain("Swamp")
            .movieAppearances(3)
            .build();

        when(planetRepositoryMock.findById(anyString())).thenReturn(Optional.of(planetMock));

        final Planet planet = planetService.findById(planetIdSearch);

        assertNotNull(planet);
    }

    // TODO Criar teste de erro quando id do planeta nao existir

    @Test
    void deveRemoverUmPlaneta() {
        final String id = "60efadad6023686be98177d8";

        doNothing().when(planetRepositoryMock).remove(anyString());

        planetService.remove(id);

        verify(planetRepositoryMock, times(1)).remove(id);
    }

}
