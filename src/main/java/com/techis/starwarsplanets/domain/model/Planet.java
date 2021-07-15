package com.techis.starwarsplanets.domain.model;

import com.fasterxml.jackson.annotation.JsonInclude;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.validation.constraints.NotNull;

@Builder
@Setter
@Getter
@AllArgsConstructor
@NoArgsConstructor
@JsonInclude(JsonInclude.Include.NON_NULL)
public class Planet {

    private String id;

    @NotNull
    private String name;

    @NotNull
    private String climate;

    @NotNull
    private String terrain;

    @NotNull
    private Integer movieAppearances;

}
