package ru.zmaev.commonlib.exception.message;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.AllArgsConstructor;
import lombok.Data;

import java.time.Instant;

@Data
@AllArgsConstructor
@Schema(description = "Класс базовой ошибки")
public class ErrorMessage {
    @Schema(description = "Код ошибки", example = "BAD_REQUEST")
    private String code;
    @Schema(description = "Сообщение ошибки", example = "Incorrect request")
    private String message;
    @Schema(description = "Дата и время ошибки", example = "2023-12-22T14:30:00.123Z")
    private Instant instant;

    public ErrorMessage(String code, String message) {
        this.code = code;
        this.message = message;
        this.instant = Instant.now();
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public Instant getInstant() {
        return instant;
    }

    public void setInstant(Instant instant) {
        this.instant = instant;
    }
}
