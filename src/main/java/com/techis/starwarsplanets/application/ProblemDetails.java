package com.techis.starwarsplanets.application;

import lombok.Builder;
import lombok.Getter;

@Builder
@Getter
public class ProblemDetails {

    private Integer status;
    private String type;
    private String title;
    private String detail;
    private String userMessage;

}
