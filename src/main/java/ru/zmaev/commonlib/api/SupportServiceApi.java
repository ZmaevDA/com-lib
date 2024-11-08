package ru.zmaev.commonlib.api;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Header;
import retrofit2.http.Path;
import ru.zmaev.commonlib.model.dto.common.UserCommonResponseDto;
import ru.zmaev.commonlib.model.dto.response.EntityIsExistsResponseDto;

public interface SupportServiceApi {
    @GET("v1/builds/{id}/exists")
    Call<EntityIsExistsResponseDto> buildExistsById(@Path("id") Long id);

    @GET("v1/users/{id}/exists")
    Call<EntityIsExistsResponseDto> userExistsById(@Path("id") String uuid);

    @GET("v1/users/{id}")
    Call<UserCommonResponseDto> findUserById(@Path("id") String uuid, @Header("dtoType") String dtoType);
}

