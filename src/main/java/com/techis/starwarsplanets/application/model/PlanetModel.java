package com.techis.starwarsplanets.application.model;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Getter;
import lombok.Setter;

@ApiModel(value = "Planet", description = "Representa um planeta")
@Getter
@Setter
@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonPropertyOrder()
public class PlanetModel {

    @ApiModelProperty(value = "Id do planeta", example = "60f70f15b7fb3840655b9ef8")
    private String id;

    @ApiModelProperty(value = "Nome do planeta", example = "Tatooine", position = 1)
    private String name;

    @ApiModelProperty(value = "Clima do planeta", example = "Arid", position = 2)
    private String climate;

    @ApiModelProperty(value = "Terreno do planeta", example = "Desert", position = 3)
    private String terrain;

    @ApiModelProperty(value = "Quantidade de aparições em filmes", example = "3", position = 4)
    private Integer movieAppearances;

}
