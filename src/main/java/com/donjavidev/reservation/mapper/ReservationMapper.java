package com.donjavidev.reservation.mapper;

import com.donjavidev.reservation.dto.ReservationDto;
import com.donjavidev.reservation.models.Reservation;
import org.mapstruct.Mapper;
import org.springframework.core.convert.converter.Converter;

@Mapper(componentModel = "spring")
public interface ReservationMapper extends Converter<Reservation, ReservationDto> {

    @Override
    ReservationDto convert(Reservation source);
}
