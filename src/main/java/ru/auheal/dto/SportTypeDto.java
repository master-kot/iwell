package ru.auheal.dto;

import io.swagger.annotations.ApiModelProperty;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Positive;
import javax.validation.constraints.Size;

import java.util.List;

import static ru.auheal.helpers.Messages.DATA_NOT_BLANK;

public class SportTypeDto {

    @Positive
    @ApiModelProperty(notes = "Уникальный идентификатор Вида спорта",
            dataType = "Short", example = "1", required = true, position = 0)
    private Short id;

    @NotBlank(message = DATA_NOT_BLANK + "необходимо описание вида спорта")
    @Size(max=50)
    @ApiModelProperty(notes = "Описание акцента вида спорта",
            dataType = "String", example = "Тренировка для пресса", required = true, position = 1)
    private String description;

    @ApiModelProperty(notes = "Идентификаторы клиентов, выбравших этот вид спорта",
            dataType = "Long", example = "45", required = true, position = 2)
    private List<Long> clientProfilesId;

    @ApiModelProperty(notes = "Идентификаторы тренеров, проводящих тренировки по этому виду спорта",
            dataType = "Long", example = "21", required = true, position = 3)
    private List<Long> coachProfilesId;
}
