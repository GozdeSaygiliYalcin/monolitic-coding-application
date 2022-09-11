package com.boostjava2.MonoliticCoding.dto.request;

import com.fasterxml.jackson.annotation.JsonCreator;

public class FindByIdRequestDto {

    private Long id;

    @JsonCreator
    public FindByIdRequestDto(Long id) {
        this.id = id;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }
}
