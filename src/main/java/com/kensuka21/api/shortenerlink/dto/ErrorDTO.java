package com.kensuka21.api.shortenerlink.dto;

/**
 * Created by kesalcedo on 5/20/2016.
 */
public class ErrorDTO {
    private String message;
    private boolean error;

    public ErrorDTO(String message, boolean error) {
        this.message = message;
        this.error = error;
    }

    public ErrorDTO() {
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public boolean isError() {
        return error;
    }

    public void setError(boolean error) {
        this.error = error;
    }
}
