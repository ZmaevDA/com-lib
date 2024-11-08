package ru.zmaev.commonlib.model.dto;

import lombok.AllArgsConstructor;
import lombok.Data;

import java.io.Serializable;

@Data
@AllArgsConstructor
public class BuildMessage implements Serializable {
    private String uuid;
    private Long buildId;
    private String buildName;
    private String buildDescription;
}
