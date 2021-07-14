package com.techis.starwarsplanets.application;

import lombok.Getter;

@Getter
public enum ProblemDetailsType {

    BUSINESS_ERROR("/business-error", "Violação de regra de negócio");

    private final String uri;
    private final String title;

    ProblemDetailsType(String path, String title) {
        this.uri = "https://techis.com" + path;
        this.title = title;
    }
}
