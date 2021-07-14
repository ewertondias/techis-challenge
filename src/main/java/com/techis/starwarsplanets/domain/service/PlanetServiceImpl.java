package com.techis.starwarsplanets.domain.service;

import com.techis.starwarsplanets.domain.Planet;
import com.techis.starwarsplanets.domain.exception.BusinessException;
import com.techis.starwarsplanets.domain.repository.PlanetServiceRepository;

import javax.validation.ConstraintViolation;
import javax.validation.Validation;
import javax.validation.Validator;
import java.util.List;
import java.util.Set;

public class PlanetServiceImpl implements PlanetService {

    private final PlanetServiceRepository planetServiceRepository;
    private final Validator validator = Validation.buildDefaultValidatorFactory().getValidator();

    public PlanetServiceImpl(final PlanetServiceRepository planetServiceRepository) {
        this.planetServiceRepository = planetServiceRepository;
    }

    private void assertRequestIsValid(final Planet planet) {
        final Set<ConstraintViolation<Planet>> violations = validator.validate(planet);
        if (!violations.isEmpty()) {
            throw new BusinessException(violations.toString());
        }
    }

    @Override
    public Planet insert(final Planet planet) {
        // TODO: Obter a quantidade de participacoes nos filmes pela API
        planet.setMovieAppearances(3);

        assertRequestIsValid(planet);
        return planetServiceRepository.insert(planet);
    }

    @Override
    public List<Planet> listDatabase() {
        return planetServiceRepository.listDatabase();
    }

    @Override
    public List<Planet> listApi() {
        return planetServiceRepository.listApi();
    }

    @Override
    public Planet findByName(final String name) {
        return planetServiceRepository.findByName(name);
    }

    @Override
    public Planet findById(final Long id) {
        return planetServiceRepository.findById(id);
    }

    @Override
    public void remove(final Long id) {
        planetServiceRepository.remove(id);
    }

}
