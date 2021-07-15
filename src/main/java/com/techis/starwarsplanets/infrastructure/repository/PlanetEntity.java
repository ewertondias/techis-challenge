package com.techis.starwarsplanets.infrastructure.repository;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import javax.validation.constraints.NotNull;

@Document("planets")
@Builder
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class PlanetEntity {

    @Id
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
