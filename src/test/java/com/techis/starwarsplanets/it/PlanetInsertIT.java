package com.techis.starwarsplanets.it;

import com.techis.starwarsplanets.infrastructure.repository.PlanetMongoRepository;
import com.techis.starwarsplanets.util.ResourceUtils;
import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.web.server.LocalServerPort;
import org.springframework.http.HttpStatus;
import org.springframework.test.context.TestPropertySource;
import org.springframework.test.context.junit.jupiter.SpringExtension;

import static io.restassured.RestAssured.given;

@ExtendWith(SpringExtension.class)
@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
@TestPropertySource("/application-test.properties")
class PlanetInsertIT {

    @LocalServerPort
    private int port;

    private String jsonPlanetInsert;

    @Autowired
    private PlanetMongoRepository planetMongoRepository;

    private void setUpData() {
        planetMongoRepository.deleteAll();
    }

    @BeforeEach
    void setUp() {
        RestAssured.port = port;
        RestAssured.basePath = "/planets";

        jsonPlanetInsert = ResourceUtils.getContentFromResource("/json/planet-insert.json");

        setUpData();
    }

    @Test
    void dadoUmPlanetaValido_quandoCadastrarPlaneta_entaoDeveRetornarStatus201() {
        given()
            .body(jsonPlanetInsert)
            .contentType(ContentType.JSON)
            .accept(ContentType.JSON)
        .when()
            .post()
        .then()
            .statusCode(HttpStatus.CREATED.value());
    }

    @Test
    void dadoUmIdInvalido_quandoConsultarUmPlaneta_entaoDeveRetornarStatus404() {
        given()
            .pathParam("id", "123")
            .accept(ContentType.JSON)
        .when()
            .get("/{id}")
        .then()
            .statusCode(HttpStatus.NOT_FOUND.value());
    }

}
