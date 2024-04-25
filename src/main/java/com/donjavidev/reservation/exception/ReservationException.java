package com.donjavidev.reservation.exception;

public class ReservationException extends RuntimeException {
    private String description;

    public ReservationException(String message) { super(message); }

    public String getDescription() { return description; }

    public void setDescription(String description) {
        this.description = description;
    }
}
