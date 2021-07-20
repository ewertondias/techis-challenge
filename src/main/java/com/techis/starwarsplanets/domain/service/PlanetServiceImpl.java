package com.techis.starwarsplanets.domain.service;

import com.techis.starwarsplanets.domain.exception.BusinessException;
import com.techis.starwarsplanets.domain.exception.PlanetAlreadyExistsException;
import com.techis.starwarsplanets.domain.exception.PlanetNotFoundExceptionException;
import com.techis.starwarsplanets.domain.model.Planet;
import com.techis.starwarsplanets.domain.repository.PlanetRepository;
import org.springframework.data.domain.Pageable;

import javax.validation.ConstraintViolation;
import javax.validation.Validation;
import javax.validation.Validator;
import java.util.List;
import java.util.Optional;
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
        final Optional<Planet> planetOptional = planetRepository.findByName(planet.getName());

        if (planetOptional.isPresent()) {
            throw new PlanetAlreadyExistsException(
                String.format("O planeta com o nome %s já está cadastrado", planet.getName())
            );
        }

        final var movieAppareances = findMovieAppearances(planet);
        planet.setMovieAppearances(movieAppareances);

        assertRequestIsValid(planet);
        return planetRepository.insert(planet);
    }

    @Override
    public List<Planet> listDatabase() {
        return planetRepository.listDatabase();
    }

    @Override
    public List<Planet> listApi(final Pageable pageable) {
        return planetRepository.listApi(pageable);
    }

    @Override
    public Planet findByName(final String name) {
        return planetRepository.findByName(name)
            .orElseThrow(() -> new PlanetNotFoundExceptionException(
                String.format("O planeta com o nome %s não foi encontrado", name)
            ));
    }

    @Override
    public Planet findById(final String id) {
        return planetRepository.findById(id)
            .orElseThrow(() -> new PlanetNotFoundExceptionException(
                String.format("O planeta com o id %s não foi encontrado", id)
            ));
    }

    @Override
    public void delete(final String id) {
        findById(id);

        planetRepository.delete(id);
    }

    @Override
    public Integer findMovieAppearances(final Planet planet) {
        return planetRepository.findMovieAppearances(planet);
    }
}
