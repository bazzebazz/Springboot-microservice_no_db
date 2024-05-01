package com.donjavidev.reservation.dto;

import jakarta.validation.Valid;
import jakarta.validation.constraints.NotEmpty;

import java.time.LocalDate;
import java.util.List;

public class ReservationDto {

    private Long id;

    @Valid
    @NotEmpty(message = "You need at least one passenger")
    private List<PassengerDto> passengers;

    @Valid
    private ItineraryDto itinerary;

    private LocalDate creationDate;

    public List<PassengerDto> getPassengers() {
        return passengers;
    }

    public void setPassengers(List<PassengerDto> passengers) {
        this.passengers = passengers;
    }

    public ItineraryDto getItinerary() {
        return itinerary;
    }

    public void setItinerary(ItineraryDto itinerary) {
        this.itinerary = itinerary;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public LocalDate getCreationDate() {
        return creationDate;
    }

    public void setCreationDate(LocalDate creationDate) {
        this.creationDate = creationDate;
    }
}
