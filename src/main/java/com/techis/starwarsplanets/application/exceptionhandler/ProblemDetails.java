package com.techis.starwarsplanets.application.exceptionhandler;

import io.swagger.annotations.ApiModelProperty;
import lombok.Builder;
import lombok.Getter;

@Builder
@Getter
public class ProblemDetails {

    @ApiModelProperty(example = "400")
    private final Integer status;

    @ApiModelProperty(example = "https://techis.com/dados-invalidos", position = 1)
    private final String type;

    @ApiModelProperty(example = "Dados inválidos", position = 2)
    private final String title;

    @ApiModelProperty(example = "Um ou mais campos estão inválidos. Faça o preenchimento correto e tente novamente.",
        position = 3)
    private final String detail;

    @ApiModelProperty(example = "Um ou mais campos estão inválidos. Faça o preenchimento correto e tente novamente.",
        position = 4)
    private final String userMessage;

}
