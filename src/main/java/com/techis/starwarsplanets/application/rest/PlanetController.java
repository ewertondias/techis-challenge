package com.techis.starwarsplanets.application.rest;

import com.techis.starwarsplanets.application.assembler.PlanetAssembler;
import com.techis.starwarsplanets.domain.model.Planet;
import com.techis.starwarsplanets.domain.model.request.PlanetRequest;
import com.techis.starwarsplanets.domain.service.PlanetService;
import org.springframework.data.domain.Pageable;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import javax.validation.Valid;
import java.util.List;

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

    @GetMapping("/database")
    public List<Planet> listDatabase() {
        return planetService.listDatabase();
    }

    @GetMapping("/api")
    public List<Planet> listApi(final Pageable pageable) {
        return planetService.listApi(pageable);
    }

    @GetMapping
    public List<Planet> findByName(@RequestParam final String name) {
        return planetService.findByName(name);
    }

    @GetMapping("/{id}")
    public Planet findById(@PathVariable final String id) {
        return planetService.findById(id);
    }

    @DeleteMapping("/{id}")
    public void remove(@PathVariable final String id) {
        planetService.remove(id);
    }

}
