package ru.gofit.dto;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Positive;


import static ru.gofit.helpers.Messages.DATA_NOT_BLANK;

@Data
@JsonIgnoreProperties(ignoreUnknown = true)
@ApiModel(description = "Dto представление сущности Акцент тренировки")
public class AccentRsDto {
    @Positive
    @ApiModelProperty(notes = "Уникальный идентификатор Акцента",
            dataType = "Short", example = "1", required = true, position = 0)
    private Short id;

    @NotBlank(message = DATA_NOT_BLANK + "необходимо описание акцента тренировки")
    @ApiModelProperty(notes = "Описание акцента тренировки",
            dataType = "String", example = "Тренировка для пресса", required = true, position = 1)
    private String description;
}
