package ru.zmaev.commonlib.creator;

import com.google.gson.InstanceCreator;
import ru.zmaev.commonlib.model.dto.common.UserCommonResponseDto;
import ru.zmaev.commonlib.model.dto.response.UserInnerResponseDto;
import java.lang.reflect.Type;

public class UserCommonResponseDtoInstanceCreator implements InstanceCreator<UserCommonResponseDto> {
    @Override
    public UserCommonResponseDto createInstance(Type type) {
        return new UserInnerResponseDto();
    }
}
