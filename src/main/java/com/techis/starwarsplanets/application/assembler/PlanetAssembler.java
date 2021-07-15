package com.techis.starwarsplanets.application.assembler;

import com.techis.starwarsplanets.domain.model.Planet;
import com.techis.starwarsplanets.domain.model.request.PlanetRequest;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Component;

@Component
public class PlanetAssembler {

    private final ModelMapper modelMapper;

    public PlanetAssembler(ModelMapper modelMapper) {
        this.modelMapper = modelMapper;
    }

    public Planet toModel(final PlanetRequest planetRequest) {
        return modelMapper.map(planetRequest, Planet.class);
    }

}
