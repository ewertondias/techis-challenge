package com.techis.starwarsplanets.application.exceptionhandler;

import lombok.Builder;
import lombok.Getter;

@Builder
@Getter
public class ProblemDetails {

    private final Integer status;
    private final String type;
    private final String title;
    private final String detail;
    private final String userMessage;

}
