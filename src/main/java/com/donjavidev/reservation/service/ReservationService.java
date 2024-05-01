package com.donjavidev.reservation.service;

import com.donjavidev.reservation.connector.CatalogConnector;
import com.donjavidev.reservation.connector.response.CityDto;
import com.donjavidev.reservation.dto.ReservationDto;
import com.donjavidev.reservation.dto.SegmentDto;
import com.donjavidev.reservation.enums.APIError;
import com.donjavidev.reservation.exception.ReservationException;
import com.donjavidev.reservation.models.Reservation;
import com.donjavidev.reservation.repository.ReservationRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.convert.ConversionService;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Objects;
import java.util.Optional;

@Service
public class ReservationService {

    private ReservationRepository repository;
    private ConversionService conversionService;
    private CatalogConnector connector;

    @Autowired
    public ReservationService(
            ReservationRepository repository,
            ConversionService conversionService,
            CatalogConnector connector
    ) {
        this.repository = repository;
        this.conversionService = conversionService;
        this.connector = connector;
    }

    //*Get All Reservations
    public List<ReservationDto> getReservations() {
        return conversionService.convert(repository.getReservations(), List.class);
    }

    //*GetReservationById
    public ReservationDto getReservationById(Long id) {
        Optional<Reservation> result = repository.getReservationById(id);
        if(result.isEmpty()) {
            throw new ReservationException(APIError.RESERVATION_NOT_FOUND);
        }

        return conversionService.convert(result.get(), ReservationDto.class);

    }

    //*SaveReservation
    public ReservationDto saveReservation(ReservationDto reservation) {
        if(Objects.nonNull(reservation.getId())) {
            throw new ReservationException(APIError.RESERVATION_WITH_SAME_ID);
        }
        checkCity(reservation);

        Reservation transformed = conversionService.convert(reservation, Reservation.class);
        Reservation result = repository.saveReservation(Objects.requireNonNull(transformed));
        return conversionService.convert(result, ReservationDto.class);

    }

    //*UpdateReservation
    public ReservationDto updateReservation(Long id, ReservationDto reservation) {
        if(getReservationById(id) == null) {
            throw new ReservationException(APIError.RESERVATION_NOT_FOUND);
        }

        checkCity(reservation);

        Reservation transformed = conversionService.convert(reservation, Reservation.class);
        Reservation result = repository.updateReservation(id, Objects.requireNonNull(transformed));
        return conversionService.convert(result, ReservationDto.class);

    }

    //*Delete A Reservation
    public void deleteReservation(Long id) {
        if(getReservationById(id) == null) {
            throw new ReservationException(APIError.RESERVATION_NOT_FOUND);
        }
        repository.deleteReservation(id);
    }

    //*Check City Code
    private void checkCity(ReservationDto reservationDto) {
        for(SegmentDto segmentDto : reservationDto.getItinerary().getSegment()) {
            CityDto origin = connector.getCity(segmentDto.getOrigin());
            CityDto destination = connector.getCity(segmentDto.getDestination());

            if(origin == null || destination == null) {
                throw new ReservationException(APIError.VALIDATION_ERROR);
            } else {
                System.out.println(origin.getName());
                System.out.println(destination.getName());
            }
        }
    }

}
