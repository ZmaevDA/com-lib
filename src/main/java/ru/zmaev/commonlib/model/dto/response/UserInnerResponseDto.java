package ru.zmaev.commonlib.model.dto.response;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import ru.zmaev.commonlib.model.dto.common.UserCommonResponseDto;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class UserInnerResponseDto implements UserCommonResponseDto {
    private String id;
    private String username;
    private String email;
}
