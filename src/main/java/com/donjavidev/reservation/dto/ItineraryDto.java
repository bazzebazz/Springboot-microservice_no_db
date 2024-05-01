package com.donjavidev.reservation.dto;

import jakarta.validation.Valid;

import java.util.List;

public class ItineraryDto {

    private Long id;

    @Valid
    private List<SegmentDto> segment;

    private PriceDto price;

    public List<SegmentDto> getSegment() {
        return segment;
    }

    public void setSegment(List<SegmentDto> segment) {
        this.segment = segment;
    }

    public PriceDto getPrice() {
        return price;
    }

    public void setPrice(PriceDto price) {
        this.price = price;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }
}
