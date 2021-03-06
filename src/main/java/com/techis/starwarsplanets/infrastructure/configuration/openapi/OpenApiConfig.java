package com.techis.starwarsplanets.infrastructure.configuration.openapi;

import com.techis.starwarsplanets.application.model.PlanetModel;
import com.techis.starwarsplanets.application.openapi.model.PageableModelOpenApi;
import com.techis.starwarsplanets.domain.model.Planet;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import springfox.documentation.builders.ApiInfoBuilder;
import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.service.ApiInfo;
import springfox.documentation.service.Tag;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

@Configuration
@EnableSwagger2
public class OpenApiConfig {

    @Bean
    public Docket apiDocket() {
        return new Docket(DocumentationType.SWAGGER_2)
            .select()
                .apis(RequestHandlerSelectors.basePackage("com.techis.starwarsplanets"))
                .build()
            .apiInfo(apiInfo())
            .directModelSubstitute(Planet.class, PlanetModel.class)
            .directModelSubstitute(Pageable.class, PageableModelOpenApi.class)
            .useDefaultResponseMessages(false)
            .ignoredParameterTypes(Sort.class, Page.class)
            .tags(new Tag("Planetas", "Gerencia os planetas"));
    }

    public ApiInfo apiInfo() {
        return new ApiInfoBuilder()
            .title("Star Wars Planets API")
            .description("API de planetas Star Wars")
            .version("1")
            .build();
    }

}
