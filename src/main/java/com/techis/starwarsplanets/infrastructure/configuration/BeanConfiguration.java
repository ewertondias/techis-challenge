package com.techis.starwarsplanets.infrastructure.configuration;

import com.techis.starwarsplanets.StarwarsPlanetsApplication;
import com.techis.starwarsplanets.domain.repository.PlanetServiceRepository;
import com.techis.starwarsplanets.domain.service.PlanetService;
import com.techis.starwarsplanets.domain.service.PlanetServiceImpl;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

@Configuration
@ComponentScan(basePackageClasses = StarwarsPlanetsApplication.class)
public class BeanConfiguration {

    @Bean
    PlanetService planetService(final PlanetServiceRepository planetServiceRepository) {
        return new PlanetServiceImpl(planetServiceRepository);
    }

}
