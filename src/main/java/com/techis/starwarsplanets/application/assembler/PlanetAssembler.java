package com.techis.starwarsplanets.application.assembler;

import com.techis.starwarsplanets.application.model.PlanetModel;
import com.techis.starwarsplanets.application.model.PlanetRequest;
import com.techis.starwarsplanets.domain.model.Planet;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.stream.Collectors;

@Component
public class PlanetAssembler {

    private final ModelMapper modelMapper;

    public PlanetAssembler(ModelMapper modelMapper) {
        this.modelMapper = modelMapper;
    }

    public PlanetModel toPlanetModel(final Planet planet) {
        return modelMapper.map(planet, PlanetModel.class);
    }

    public List<PlanetModel> toPlanetModelCollection(final List<Planet> planets) {
        return planets.stream().map(this::toPlanetModel).collect(Collectors.toList());
    }

    public Planet toModel(final PlanetRequest planetRequest) {
        return modelMapper.map(planetRequest, Planet.class);
    }

}
