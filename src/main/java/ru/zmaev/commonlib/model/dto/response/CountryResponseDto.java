package ru.zmaev.commonlib.model.dto.response;

import lombok.Data;

@Data
public class CountryResponseDto {
    private Long id;
    private String name;
    private String iso;
    private String iso3;
}
