package com.techis.starwarsplanets.application.exceptionhandler;

import com.techis.starwarsplanets.domain.exception.BusinessException;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

@ControllerAdvice
public class ApiExceptionHandler extends ResponseEntityExceptionHandler {

    @ExceptionHandler(BusinessException.class)
    public ResponseEntity<Object> handleBusinessException(BusinessException ex, WebRequest request) {
        final var problemDetails = ProblemDetails.builder()
            .status(HttpStatus.BAD_REQUEST.value())
            .type(ProblemDetailsType.BUSINESS_ERROR.getUri())
            .title(ProblemDetailsType.BUSINESS_ERROR.getTitle())
            .detail(ex.getMessage())
            .userMessage(ex.getMessage())
            .build();

        return super.handleExceptionInternal(ex, problemDetails, new HttpHeaders(), HttpStatus.BAD_REQUEST, request);
    }

}
