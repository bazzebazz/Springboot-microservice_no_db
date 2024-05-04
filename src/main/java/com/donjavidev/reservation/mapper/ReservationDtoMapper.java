package com.donjavidev.reservation.mapper;

import com.donjavidev.reservation.dto.ReservationDto;
import com.donjavidev.reservation.models.Reservation;
import org.mapstruct.Mapper;
import org.springframework.core.convert.converter.Converter;

@Mapper(componentModel = "spring")
public interface ReservationDtoMapper extends Converter<ReservationDto, Reservation> {
    @Override
    Reservation convert(ReservationDto source);
}
