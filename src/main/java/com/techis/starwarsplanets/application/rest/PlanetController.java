package com.techis.starwarsplanets.application.rest;

import com.techis.starwarsplanets.application.assembler.PlanetAssembler;
import com.techis.starwarsplanets.domain.model.Planet;
import com.techis.starwarsplanets.domain.model.request.PlanetRequest;
import com.techis.starwarsplanets.domain.service.PlanetService;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.validation.Valid;

@RestController
@RequestMapping("/planets")
public class PlanetController {

    private final PlanetService planetService;
    private final PlanetAssembler planetAssembler;

    public PlanetController(final PlanetService planetService, final PlanetAssembler planetAssembler) {
        this.planetService = planetService;
        this.planetAssembler = planetAssembler;
    }

    @PostMapping
    public Planet insert(@RequestBody @Valid PlanetRequest request) {
        Planet planet = planetAssembler.toModel(request);

        return planetService.insert(planet);
    }

}