package ru.zmaev.commonlib.model.dto.common;

import com.fasterxml.jackson.annotation.JsonSubTypes;
import com.fasterxml.jackson.annotation.JsonTypeInfo;
import ru.zmaev.commonlib.model.dto.response.UserFullResponseDto;
import ru.zmaev.commonlib.model.dto.response.UserInnerResponseDto;

@JsonTypeInfo(
        use = JsonTypeInfo.Id.NAME,
        property = "dtoType"
)
@JsonSubTypes({
        @JsonSubTypes.Type(value = UserFullResponseDto.class, name = "full"),
        @JsonSubTypes.Type(value = UserInnerResponseDto.class, name = "inner")
})
public interface UserCommonResponseDto {
}
