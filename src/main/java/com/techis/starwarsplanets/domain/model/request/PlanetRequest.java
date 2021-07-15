package com.techis.starwarsplanets.domain.model.request;

import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

import javax.validation.constraints.NotNull;

@Builder
@Getter
@Setter
public class PlanetRequest {

    @NotNull
    private String name;

    @NotNull
    private String climate;

    @NotNull
    private String terrain;

}
