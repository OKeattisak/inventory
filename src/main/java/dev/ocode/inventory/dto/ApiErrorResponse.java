package dev.ocode.inventory.dto;

import lombok.Data;

import java.time.LocalDateTime;

@Data
public class ApiErrorResponse {
    private int status;
    private String message;
    private String error;
    private LocalDateTime timestamp;

    public ApiErrorResponse(int status, String message, String error) {
        this.status = status;
        this.message = message;
        this.error = error;
        this.timestamp = LocalDateTime.now();
    }
}
