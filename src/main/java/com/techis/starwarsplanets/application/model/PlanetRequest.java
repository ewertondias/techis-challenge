package com.techis.starwarsplanets.application.model;

import io.swagger.annotations.ApiModelProperty;
import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

import javax.validation.constraints.NotNull;

@Builder
@Getter
@Setter
public class PlanetRequest {

    @NotNull
    @ApiModelProperty(value = "Nome do planeta", example = "Tatooine")
    private String name;

    @NotNull
    @ApiModelProperty(value = "Clima do planeta", example = "Arid", position = 1)
    private String climate;

    @NotNull
    @ApiModelProperty(value = "Terreno do planeta", example = "Desert", position = 2)
    private String terrain;

}
