package com.techis.starwarsplanets.application.openapi.controller;

import com.techis.starwarsplanets.application.exceptionhandler.ProblemDetails;
import com.techis.starwarsplanets.application.model.PlanetModel;
import com.techis.starwarsplanets.application.model.PlanetRequest;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.List;

@Api(tags = "Planetas")
public interface PlanetControllerOpenApi {

    @ApiOperation("Cadastra um planeta")
    @ApiResponses({
        @ApiResponse(code = 201, message = "Planeta cadastrado"),
        @ApiResponse(code = 409, message = "Planeta já existe", response = ProblemDetails.class)
    })
    PlanetModel insert(PlanetRequest planetRequest);

    @ApiOperation("Lista os planetas do banco de dados")
    Page<PlanetModel> listDatabase(final Pageable pageable);

    @ApiOperation("Lista os planetas da api")
    List<PlanetModel> listApi(final Pageable pageable);

    @ApiOperation("Busca um planeta pelo nome")
    @ApiResponses({
        @ApiResponse(code = 404, message = "Planeta não encontrado", response = ProblemDetails.class),
    })
    PlanetModel findByName(final String name);

    @ApiOperation("Busca um planeta pelo id")
    @ApiResponses({
        @ApiResponse(code = 404, message = "Planeta não encontrado", response = ProblemDetails.class),
    })
    PlanetModel findById(final String id);

    @ApiOperation("Exclui um planeta pelo id")
    @ApiResponses({
        @ApiResponse(code = 204, message = "Planeta excluído"),
        @ApiResponse(code = 404, message = "Planeta não encontrado", response = ProblemDetails.class),
    })
    void delete(final String id);

}
