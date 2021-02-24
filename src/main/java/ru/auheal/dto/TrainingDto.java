package ru.auheal.dto;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;
import javax.validation.constraints.Positive;

/**
 * Dto представление сущности Тренировка
 */
@Data
@JsonIgnoreProperties(ignoreUnknown = true)
@ApiModel(description = "Dto представление сущности Тренировка")
public class TrainingDto {

    @Positive
    @ApiModelProperty(notes = "Уникальный идентификатор тренировки", dataType = "Long", example = "1", required = true, position = 0)
    private Long trainingId;

    @ApiModelProperty(notes = "Название тренировки", dataType = "String",  example = "тренировка хатха-йога", required = true, position = 1)
    private String trainingName;
}