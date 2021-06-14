package com.clauzewitz.kafkaexample.handler;

import com.clauzewitz.kafkaexample.handler.exception.BadRequestException;
import com.clauzewitz.kafkaexample.handler.exception.CustomError;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.ResponseStatus;

import javax.servlet.http.HttpServletRequest;

@Component
@ControllerAdvice
public class GlobalExceptionHandler {

    @ResponseStatus(HttpStatus.BAD_REQUEST)
    @ResponseBody
    @ExceptionHandler(BadRequestException.class)
    public CustomError badRequestException(HttpServletRequest request, BadRequestException exception) {
        return CustomError.builder()
                .path(request.getRequestURI())
                .status(exception.getStatus())
                .error(HttpStatus.BAD_REQUEST.getReasonPhrase())
                .message(exception.getLocalizedMessage())
                .build();
    }

}