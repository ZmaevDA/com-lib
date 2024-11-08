package ru.zmaev.commonlib.model.dto.response;

public class EntityIsExistsResponseDto {
    private boolean isExists;

    public EntityIsExistsResponseDto(boolean isExists) {
        this.isExists = isExists;
    }

    public EntityIsExistsResponseDto() {
    }

    public boolean getIsExists() {
        return isExists;
    }

    public void setExists(boolean isExists) {
        this.isExists = isExists;
    }
}
