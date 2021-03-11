package ru.auheal.dto;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Positive;
import javax.validation.constraints.Size;

import static ru.auheal.helpers.Messages.DATA_NOT_BLANK;

/**
 * Запрос на создание сущности Отзыв о тренере
 */
@Data
@JsonIgnoreProperties(ignoreUnknown = true)
@ApiModel(description = "Dto представление сущности Отзыв о тренере")
public class ReviewRequest  {

    @Positive
    @ApiModelProperty(notes = "Уникальный идентификатор тренировки",
            dataType = "Long", example = "1", required = true, position = 0)
    private Long trainingId;

    @NotBlank(message = DATA_NOT_BLANK + "Ваше сообщение")
    @Size(max=500)
    @ApiModelProperty(notes = "Текст отзыва, до 500 символов",
            dataType = "String", example = "Текст сообщения", required = true, position = 1)
    private String text;

    @NotBlank(message = DATA_NOT_BLANK + "Ваше сообщение")
    @ApiModelProperty(notes = "Рейтинг Тренера",
            dataType = "Shotr", example = "1", required = true, position = 2)
    private Short raiting;

    @ApiModelProperty(notes = "Идентификатор тренера",
            dataType = "Long",  required = true, position = 3)
    private Long coachId;

    @ApiModelProperty(notes = "Идентификатор клиента",
            dataType = "Long",  required = true, position = 3)
    private Long clientId;
}