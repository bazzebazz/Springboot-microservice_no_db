package com.donjavidev.reservation.controller;

import com.donjavidev.reservation.controller.resource.ReservationResource;
import com.donjavidev.reservation.dto.ReservationDto;
import com.donjavidev.reservation.enums.APIError;
import com.donjavidev.reservation.exception.ReservationException;
import com.donjavidev.reservation.service.ReservationService;
import io.github.resilience4j.ratelimiter.RequestNotPermitted;
import io.github.resilience4j.ratelimiter.annotation.RateLimiter;
import jakarta.validation.Valid;
import jakarta.validation.constraints.Min;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

@RestController
@RequestMapping("/reservation")
@Validated
public class ReservationController implements ReservationResource {

    private ReservationService service;

    @Autowired
    public ReservationController(ReservationService service) { this.service = service; }

    @GetMapping
    public ResponseEntity<List<ReservationDto>> getReservations() {
        List<ReservationDto> response = service.getReservations();
        return new ResponseEntity<>(response, HttpStatus.OK);
    }

    @GetMapping("/{id}")
    public  ResponseEntity<ReservationDto> getReservationById(@PathVariable Long id) {
        ReservationDto response = service.getReservationById(id);
        return new ResponseEntity<>(response, HttpStatus.OK);
    }

    @Override
    public ResponseEntity<ReservationDto> saveReservation(ReservationDto reservation) {
        return null;
    }

    @PostMapping
    @RateLimiter(name = "post-reservation", fallbackMethod = "fallbackPost")
    public ResponseEntity<ReservationDto> save(@RequestBody @Valid ReservationDto reservation) {
        ReservationDto response = service.saveReservation(reservation);
        return new ResponseEntity<>(response, HttpStatus.CREATED);
    }

    @PutMapping("/{id}")
    public ResponseEntity<ReservationDto> updateReservation(@Min(1) @PathVariable Long id, @Valid @RequestBody ReservationDto reservation) {
        ReservationDto response = service.updateReservation(id, reservation);
        return new ResponseEntity<>(response, HttpStatus.OK);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteReservation(@Min(1) @PathVariable Long id) {
        service.deleteReservation(id);
        return new ResponseEntity<>(HttpStatus.OK);
    }

    private ResponseEntity<ReservationDto> fallbackPost(ReservationDto reservation, RequestNotPermitted ex) {
        System.out.println("calling to fallbackPost");

        throw new ReservationException(APIError.EXCEED_NUMBER_OPERATIONS);
    }

}
