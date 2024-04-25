package com.donjavidev.reservation.service;

import com.donjavidev.reservation.dto.ReservationDto;
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

    @Autowired
    public ReservationService(ReservationRepository repository,
                              ConversionService conversionService) {
        this.repository = repository;
        this.conversionService = conversionService;
    }

    public List<ReservationDto> getReservations() {
        return conversionService.convert(repository.getReservations(), List.class);
    }

    public ReservationDto getReservationById(Long id) {
        Optional<Reservation> result = repository.getReservationById(id);
        if(result.isEmpty()) {
            throw  new ReservationException("Not exist");
        }

        return conversionService.convert(result.get(), ReservationDto.class);

    }

    public ReservationDto saveReservation(ReservationDto reservation) {
        if(Objects.nonNull(reservation.getId())) {
            throw new ReservationException("Duplicate it");
        }

        Reservation transformed = conversionService.convert(reservation, Reservation.class);
        Reservation result = repository.saveReservation(Objects.requireNonNull(transformed));
        return conversionService.convert(result, ReservationDto.class);

    }

    public ReservationDto updateReservation(Long id, ReservationDto reservation) {
        if(getReservationById(id) == null) {
            throw new ReservationException("Not exist");
        }

        Reservation transformed = conversionService.convert(reservation, Reservation.class);
        Reservation result = repository.updateReservation(id, Objects.requireNonNull(transformed));
        return conversionService.convert(result, ReservationDto.class);

    }

    public void deleteReservation(Long id) {
        if(getReservationById(id) == null) {
            throw new ReservationException("Not exist");
        }
        repository.deleteReservation(id);
    }

}
