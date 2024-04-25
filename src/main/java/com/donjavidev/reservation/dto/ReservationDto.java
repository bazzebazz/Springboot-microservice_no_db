package com.donjavidev.reservation.dto;

import java.time.LocalDate;
import java.util.List;

public class ReservationDto {
    private Long id;

    private List<PassengerDto> passengers;

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
