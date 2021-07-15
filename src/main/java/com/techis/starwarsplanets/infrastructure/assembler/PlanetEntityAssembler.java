package com.techis.starwarsplanets.infrastructure.assembler;

import com.techis.starwarsplanets.domain.model.Planet;
import com.techis.starwarsplanets.infrastructure.repository.PlanetEntity;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.stream.Collectors;

@Component
public class PlanetEntityAssembler {

    private final ModelMapper modelMapper;

    public PlanetEntityAssembler(final ModelMapper modelMapper) {
        this.modelMapper = modelMapper;
    }

    public Planet toModel(final PlanetEntity planetEntity) {
        return modelMapper.map(planetEntity, Planet.class);
    }

    public List<Planet> toCollectionModel(final List<PlanetEntity> planetEntities) {
        return planetEntities.stream().map(this::toModel)
            .collect(Collectors.toList());
    }

    public PlanetEntity toEntity(final Planet planet) {
        return modelMapper.map(planet, PlanetEntity.class);
    }

}
