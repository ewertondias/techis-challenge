package com.techis.starwarsplanets.infrastructure.assembler;

import com.techis.starwarsplanets.domain.model.Planet;
import com.techis.starwarsplanets.infrastructure.repository.PlanetEntity;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Component;

@Component
public class PlanetEntityAssembler {

    private final ModelMapper modelMapper;

    public PlanetEntityAssembler(final ModelMapper modelMapper) {
        this.modelMapper = modelMapper;
    }

    public Planet toModel(final PlanetEntity planetEntity) {
        return modelMapper.map(planetEntity, Planet.class);
    }

    public PlanetEntity toEntity(final Planet planet) {
        return modelMapper.map(planet, PlanetEntity.class);
    }

}
