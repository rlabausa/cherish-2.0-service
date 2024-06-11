package com.rlabausa.cherishservice.common.responses;

import org.springframework.http.HttpStatus;

import java.util.Date;

public class ApiErrorResponse {
    private HttpStatus status;
    private int statusCode;
    private String message;
    private String type;
    private Date timestamp;

    public ApiErrorResponse(HttpStatus status, String message, String type, Date timestamp) {
        this.status = status;
        this.message = message;
        this.type = type;
        this.timestamp = timestamp;

        this.statusCode = status.value();
    }

    public HttpStatus getStatus() {
        return status;
    }

    public int getStatusCode() {
        return statusCode;
    }

    public String getMessage() {
        return message;
    }

    public String getType() {
        return type;
    }

    public Date getTimestamp() {
        return timestamp;
    }
}
