package com.techis.starwarsplanets.application.rest;

import com.techis.starwarsplanets.application.assembler.PlanetAssembler;
import com.techis.starwarsplanets.application.helper.ResourceUriHelper;
import com.techis.starwarsplanets.application.model.PlanetModel;
import com.techis.starwarsplanets.application.model.PlanetRequest;
import com.techis.starwarsplanets.application.openapi.controller.PlanetControllerOpenApi;
import com.techis.starwarsplanets.domain.service.PlanetService;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageImpl;
import org.springframework.data.domain.Pageable;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import javax.validation.Valid;
import java.util.List;

@RestController
@RequestMapping("/planets")
public class PlanetController implements PlanetControllerOpenApi {

    private final PlanetService planetService;
    private final PlanetAssembler planetAssembler;

    public PlanetController(final PlanetService planetService, final PlanetAssembler planetAssembler) {
        this.planetService = planetService;
        this.planetAssembler = planetAssembler;
    }

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public PlanetModel insert(@RequestBody @Valid PlanetRequest planetRequest) {
        var planet = planetAssembler.toModel(planetRequest);

        planet = planetService.insert(planet);

        ResourceUriHelper.addUriResponseHeader(planet.getId());

        return planetAssembler.toPlanetModel(planet);
    }

    @GetMapping("/database")
    public Page<PlanetModel> listDatabase(final Pageable pageable) {
        final var pagePlanets = planetService.listDatabase(pageable);

        final var planetsModel = planetAssembler.toPlanetModelCollection(pagePlanets.getContent());

        return new PageImpl<>(planetsModel);
    }

    @GetMapping("/api")
    public List<PlanetModel> listApi(final Pageable pageable) {
        final var planets = planetService.listApi(pageable);

        return planetAssembler.toPlanetModelCollection(planets);
    }

    @GetMapping
    public PlanetModel findByName(@RequestParam final String name) {
        final var planet = planetService.findByName(name);

        return planetAssembler.toPlanetModel(planet);
    }

    @GetMapping("/{id}")
    public PlanetModel findById(@PathVariable final String id) {
        final var planet = planetService.findById(id);

        return planetAssembler.toPlanetModel(planet);
    }

    @DeleteMapping("/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void delete(@PathVariable final String id) {
        planetService.delete(id);
    }

}
