package com.techis.starwarsplanets.infrastructure.repository;

import com.techis.starwarsplanets.domain.exception.PlanetNotFoundExceptionException;
import com.techis.starwarsplanets.domain.model.Planet;
import com.techis.starwarsplanets.domain.repository.PlanetRepository;
import com.techis.starwarsplanets.infrastructure.assembler.PlanetEntityAssembler;
import org.springframework.data.domain.Pageable;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;

import java.util.List;
import java.util.Optional;

@Component
public class PlanetRepositoryImpl implements PlanetRepository {

    private final PlanetMongoRepository planetMongoRepository;
    private final PlanetEntityAssembler planetEntityAssembler;
    private final RestTemplate restTemplate = new RestTemplate();

    // TODO Colocar no property
    private static final String API_PATH_PLANETS = "https://swapi.dev/api/planets";

    public PlanetRepositoryImpl(final PlanetMongoRepository planetMongoRepository,
                                final PlanetEntityAssembler planetEntityAssembler) {
        this.planetMongoRepository = planetMongoRepository;
        this.planetEntityAssembler = planetEntityAssembler;
    }

    private PlanetResponseResultApi findPlanetApi(final Planet planet) {
        final String resourceUrl = API_PATH_PLANETS + "/?search=" + planet.getName();

        try {
            ResponseEntity<PlanetResponseApi> response = restTemplate.getForEntity(resourceUrl, PlanetResponseApi.class);

            final var planetApi = response.getBody().getResults().get(0);

            if (!planet.getName().equalsIgnoreCase(planetApi.getName())) {
                throw new PlanetNotFoundExceptionException(
                    String.format("O planeta com o nome %s não foi encontrado na api", planet.getName())
                );
            }

            return planetApi;
        } catch (Exception e) {
            throw new PlanetNotFoundExceptionException(
                String.format("O planeta com o nome %s não foi encontrado na api", planet.getName())
            );
        }
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
    public List<Planet> listApi(final Pageable pageable) {
        var page = pageable.getPageNumber();
        if (page == 0) {
            page = 1;
        }

        final String resourceUrl = API_PATH_PLANETS + "/?page=" + page;

        ResponseEntity<PlanetResponseApi> response = restTemplate.getForEntity(resourceUrl, PlanetResponseApi.class);

        return planetEntityAssembler.responseApiToCollectionModel(response.getBody().getResults());
    }

    @Override
    public Optional<Planet> findByName(final String name) {
        final var planetEntities = planetMongoRepository.findByName(name);

        if (planetEntities.isEmpty()) {
            throw new PlanetNotFoundExceptionException(
                String.format("O planeta com o nome %s não foi encontrado", name)
            );
        }

        final var planet = planetEntityAssembler.toModel(planetEntities.get(0));

        return Optional.of(planet);
    }

    @Override
    public Optional<Planet> findById(final String id) {
        return planetMongoRepository.findById(id)
            .map(planetEntityAssembler::toModel);
    }

    @Override
    public void delete(final String id) {
        planetMongoRepository.deleteById(id);
    }

    @Override
    public Integer findMovieAppearances(final Planet planet) {
        final var planetApi = findPlanetApi(planet);

        return planetApi.getFilms().size();
    }
}
