package com.clauzewitz.kafkaexample.handler.exception;

import lombok.Builder;
import lombok.Getter;
import lombok.NonNull;

import java.time.LocalDateTime;

@Getter
@Builder
public class CustomError {
    @NonNull
    private String path;
    private int status;
    @NonNull
    private String error;
    private String message;
    @Builder.Default
    private LocalDateTime timestamp = LocalDateTime.now();
}