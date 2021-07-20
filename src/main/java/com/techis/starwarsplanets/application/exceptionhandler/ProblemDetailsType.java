package com.techis.starwarsplanets.application.exceptionhandler;

import lombok.Getter;

@Getter
public enum ProblemDetailsType {

    BUSINESS_ERROR("/business-error", "Violação de regra de negócio"),
    RESOURCE_NOT_FOUND("/resource-not-found", "Recurso não encontrado"),
    RESOURCE_ALREADY_EXISTS("/resource-already-exists", "Recurso já existente");

    private final String uri;
    private final String title;

    ProblemDetailsType(String path, String title) {
        this.uri = "https://techis.com" + path;
        this.title = title;
    }

}
