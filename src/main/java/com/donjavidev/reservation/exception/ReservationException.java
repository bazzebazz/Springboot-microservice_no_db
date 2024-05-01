package com.donjavidev.reservation.exception;

import com.donjavidev.reservation.enums.APIError;
import org.springframework.http.HttpStatus;

import java.util.List;

public class ReservationException extends RuntimeException {

    private HttpStatus status;
    private String description;
    private List<String> reasons;

    public ReservationException(HttpStatus status, String description, List<String> reasons) {
        this.status = status;
        this.description = description;
        this.reasons = reasons;
    }

    public ReservationException(APIError error) {
        this.status = error.getHttpStatus();
        this.description = error.getMessage();
    }

    public HttpStatus getStatus() {
        return status;
    }

    public void setStatus(HttpStatus status) {
        this.status = status;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public List<String> getReasons() {
        return reasons;
    }

    public void setReasons(List<String> reasons) {
        this.reasons = reasons;
    }
}
