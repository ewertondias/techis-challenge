package com.techis.starwarsplanets.domain;

import lombok.Builder;
import lombok.Setter;

import javax.validation.constraints.NotNull;

@Builder
@Setter
public class Planet {

    private Long id;

    @NotNull
    private String name;

    @NotNull
    private String climate;

    @NotNull
    private String terrain;

    @NotNull
    private Integer movieAppearances;

}
