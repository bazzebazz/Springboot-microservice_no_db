package com.donjavidev.reservation.mapper;

import com.donjavidev.reservation.dto.ReservationDto;
import com.donjavidev.reservation.models.Reservation;
import org.mapstruct.Mapper;
import org.springframework.core.convert.converter.Converter;

import java.util.List;

@Mapper(componentModel = "spring")
public interface ReservationsListMapper extends Converter<List<Reservation>, List<ReservationDto>> {

    @Override
    List<ReservationDto> convert(List<Reservation> source);
}
