package ru.gofit.dto;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Positive;
import javax.validation.constraints.Size;

import static ru.gofit.helpers.Messages.DATA_NOT_BLANK;


/**
 * Dto представление сущности Профиль тренера
 */
@Data
@JsonIgnoreProperties(ignoreUnknown = true)
@ApiModel(description = "Dto представление сущности Профиль тренера")
public class CoachProfileDto {

    @Positive
    @NotBlank(message = DATA_NOT_BLANK)
    @Size(max = 1024)
    @ApiModelProperty(notes = " тренера", dataType = "", example = "", required = true, position = 0)
    private Long id;

    //TODO проверить все типы переменных входящих полей и их позиции,
    // добавить недостающие поля, enum типы привести к String
    // сложные внутренние типы привести к простым
    // добавить валидацию полей согласно ограничениям из БД
}