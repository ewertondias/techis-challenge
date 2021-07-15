package com.techis.starwarsplanets.domain.service;

import com.techis.starwarsplanets.domain.exception.BusinessException;
import com.techis.starwarsplanets.domain.model.Planet;
import com.techis.starwarsplanets.domain.repository.PlanetRepository;

import javax.validation.ConstraintViolation;
import javax.validation.Validation;
import javax.validation.Validator;
import java.util.List;
import java.util.Set;

public class PlanetServiceImpl implements PlanetService {

    private final PlanetRepository planetRepository;
    private final Validator validator = Validation.buildDefaultValidatorFactory().getValidator();

    public PlanetServiceImpl(final PlanetRepository planetRepository) {
        this.planetRepository = planetRepository;
    }

    private void assertRequestIsValid(final Planet planet) {
        final Set<ConstraintViolation<Planet>> violations = validator.validate(planet);
        if (!violations.isEmpty()) {
            throw new BusinessException(violations.toString());
        }
    }

    @Override
    public Planet insert(final Planet planet) {
        // TODO Obter a quantidade de participacoes nos filmes pela API
        planet.setMovieAppearances(3);

        assertRequestIsValid(planet);
        return planetRepository.insert(planet);
    }

    @Override
    public List<Planet> listDatabase() {
        return planetRepository.listDatabase();
    }

    @Override
    public List<Planet> listApi() {
        return planetRepository.listApi();
    }

    @Override
    public List<Planet> findByName(final String name) {
        return planetRepository.findByName(name);
    }

    @Override
    public Planet findById(final String id) {
        // TODO Criar exception generica e ajustar mensagem
        return planetRepository.findById(id)
            .orElseThrow(() -> new BusinessException("Planeta com id 1 não encontrado"));
    }

    @Override
    public void remove(final String id) {
        planetRepository.remove(id);
    }

}
