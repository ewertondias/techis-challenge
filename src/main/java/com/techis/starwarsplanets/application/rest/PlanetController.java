package com.techis.starwarsplanets.application.rest;

import com.techis.starwarsplanets.domain.Planet;
import com.techis.starwarsplanets.domain.exception.BusinessException;
import com.techis.starwarsplanets.domain.service.PlanetService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("planets")
public class PlanetController {

    private final PlanetService planetService;

    public PlanetController(final PlanetService planetService) {
        this.planetService = planetService;
    }

    @GetMapping
    public String teste() {
        final Planet planetRequest = Planet.builder()
            .name("Dagobah")
            .climate("Murky")
            .terrain("Swamp")
            .build();

        // planetService.insert(planetRequest);
        return "ok";
    }

}
