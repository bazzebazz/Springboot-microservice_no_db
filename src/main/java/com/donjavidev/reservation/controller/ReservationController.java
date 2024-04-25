package com.donjavidev.reservation.controller;

import com.donjavidev.reservation.dto.ReservationDto;
import com.donjavidev.reservation.service.ReservationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/reservation")
public class ReservationController {

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

    @PostMapping
    public ResponseEntity<ReservationDto> saveReservation(@RequestBody ReservationDto reservation) {
        ReservationDto response = service.saveReservation(reservation);
        return new ResponseEntity<>(response, HttpStatus.CREATED);
    }

    @PutMapping("/{id}")
    public ResponseEntity<ReservationDto> updateReservation(@PathVariable Long id, @RequestBody ReservationDto reservation) {
        ReservationDto response = service.updateReservation(id, reservation);
        return new ResponseEntity<>(response, HttpStatus.OK);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<ReservationDto> deleteReservation(@PathVariable Long id) {
        service.deleteReservation(id);
        return new ResponseEntity<>(HttpStatus.OK);
    }

}
