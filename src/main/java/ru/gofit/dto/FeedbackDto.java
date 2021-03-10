package ru.gofit.dto;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

/**
 * Dto представление сущности Данные обратной связи
 */
@Data
@JsonIgnoreProperties(ignoreUnknown = true)
@ApiModel(description = "Dto представление сущности Пользователь")
public class FeedbackDto {

    @ApiModelProperty(notes = "Имя, до 50 символов",
            dataType = "String", example = "Иван", position = 0)
    private String name;

    @ApiModelProperty(notes = "Телефон, до 20 символов",
            dataType = "String", example = "+7-495-552-64-53", position = 1)
    private String phone;

    @ApiModelProperty(notes = "E-mail, до 50 символов",
            dataType = "String", example = "aaa@mail.ru", required = true, position = 2)
    private String email;

    @ApiModelProperty(notes = "Текст сообщения, до 500 символов",
            dataType = "String", example = "Текст сообщения", required = true, position = 3)
    private String message;

    @ApiModelProperty(notes = "Предпочитаемый способ связи: Телефон",
            dataType = "boolean", example = "true", position = 4)
    private boolean preferPhone;

    @ApiModelProperty(notes = "Предпочитаемый способ связи: E-mail",
            dataType = "boolean", example = "true", position = 5)
    private boolean preferEmail;

    @ApiModelProperty(notes = "Предпочитаемый способ связи: Whatsapp",
            dataType = "boolean", example = "true", position = 6)
    private boolean preferWhatsapp;

    @ApiModelProperty(notes = "Предпочитаемый способ связи: Telegram",
            dataType = "boolean", example = "true", position = 7)
    private boolean preferTelegram;
}
