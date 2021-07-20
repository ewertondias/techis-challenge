package com.techis.starwarsplanets.application.exceptionhandler;

import com.techis.starwarsplanets.domain.exception.BusinessException;
import com.techis.starwarsplanets.domain.exception.PlanetAlreadyExistsException;
import com.techis.starwarsplanets.domain.exception.ResourceNotFoundException;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

@ControllerAdvice
public class ApiExceptionHandler extends ResponseEntityExceptionHandler {

    private ProblemDetails.ProblemDetailsBuilder createProblemDetails(HttpStatus status,
                                                                      ProblemDetailsType problemDetailsType,
                                                                      String detail,
                                                                      String userMessage) {
        return ProblemDetails.builder()
            .status(status.value())
            .type(problemDetailsType.getUri())
            .title(problemDetailsType.getTitle())
            .detail(detail)
            .userMessage(userMessage);
    }

    @ExceptionHandler(BusinessException.class)
    public ResponseEntity<Object> handleBusinessException(BusinessException ex, WebRequest request) {

        final var problemDetails = createProblemDetails(
            HttpStatus.BAD_REQUEST,
            ProblemDetailsType.BUSINESS_ERROR,
            ex.getMessage(),
            ex.getMessage()
        ).build();

        return super.handleExceptionInternal(ex, problemDetails, new HttpHeaders(), HttpStatus.BAD_REQUEST, request);
    }

    @ExceptionHandler(ResourceNotFoundException.class)
    public ResponseEntity<Object> handleResourceNotFoundException(ResourceNotFoundException ex, WebRequest request) {
        final var problemDetails = createProblemDetails(
            HttpStatus.NOT_FOUND,
            ProblemDetailsType.RESOURCE_NOT_FOUND,
            ex.getMessage(),
            ex.getMessage()
        ).build();

        return super.handleExceptionInternal(ex, problemDetails, new HttpHeaders(), HttpStatus.NOT_FOUND, request);
    }

    @ExceptionHandler(PlanetAlreadyExistsException.class)
    public ResponseEntity<Object> handleResourceNotFoundException(PlanetAlreadyExistsException ex, WebRequest request) {
        final var problemDetails = createProblemDetails(
            HttpStatus.CONFLICT,
            ProblemDetailsType.RESOURCE_ALREADY_EXISTS,
            ex.getMessage(),
            ex.getMessage()
        ).build();

        return super.handleExceptionInternal(ex, problemDetails, new HttpHeaders(), HttpStatus.CONFLICT, request);
    }

}
