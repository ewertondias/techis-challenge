package com.techis.starwarsplanets.domain;

import lombok.Builder;

@Builder
public class Planet {

    private Long id;
    private String name;
    private String climate;
    private String terrain;
    private Integer movieAppearances;

}
