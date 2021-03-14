package ru.auheal.dto;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Positive;

import java.util.List;

import static ru.auheal.helpers.Messages.DATA_NOT_BLANK;

@Data
@JsonIgnoreProperties(ignoreUnknown = true)
@ApiModel(description = "Dto представление сущности Акцент тренировки")
public class AccentDto {

    @Positive
    @ApiModelProperty(notes = "Уникальный идентификатор Акцента",
            dataType = "Short", example = "1", required = true, position = 0)
    private Short id;

    @NotBlank(message = DATA_NOT_BLANK + "необходимо описание акцента тренировки")
    @ApiModelProperty(notes = "Описание акцента тренировки",
            dataType = "String", example = "Тренировка для пресса", required = true, position = 1)
    private String description;

//    @ApiModelProperty(notes = "Список id тренировок с данным акцентом",
//            dataType = "String",  position = 2)
//    private List<Long> trainingIds;
}
