package ru.zmaev.commonlib.model.dto.response;

import lombok.Data;
import ru.zmaev.commonlib.model.dto.common.UserCommonResponseDto;

import java.util.List;

@Data
public class UserFullResponseDto implements UserCommonResponseDto {
    private String id;
    private String username;
    private String email;
    private List<String> roles;
    private String description;
    private Integer age;
    private Integer inGameHours;
    private CountryResponseDto country;
}
