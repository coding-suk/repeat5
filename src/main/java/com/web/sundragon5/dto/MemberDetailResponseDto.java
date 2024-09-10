package com.web.sundragon5.dto;

import lombok.Getter;

@Getter
public class MemberDetailResponseDto {

    private final String name;

    public MemberDetailResponseDto(String name) {
        this.name = name;
    }
}
