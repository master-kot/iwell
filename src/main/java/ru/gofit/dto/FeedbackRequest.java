package ru.gofit.dto;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;

import static ru.gofit.helpers.Messages.DATA_NOT_BLANK;

/**
 * Запрос для регистрации данных обратной связи
 */
@Data
@JsonIgnoreProperties(ignoreUnknown = true)
public class FeedbackRequest {

    @Size(max=50)
    @ApiModelProperty(notes = "Имя, до 50 символов",
            dataType = "String", example = "Иван", position = 0)
    private String name;

    @Size(max=20)
    @ApiModelProperty(notes = "Телефон, до 20 символов",
            dataType = "String", example = "+7-495-552-64-53", position = 1)
    private String phone;

    @NotBlank(message = DATA_NOT_BLANK + "E-mail")
    @Size(max=50)
    @Email
    @ApiModelProperty(notes = "E-mail, до 50 символов",
            dataType = "String", example = "aaa@mail.ru", required = true, position = 2)
    private String email;

    @NotBlank(message = DATA_NOT_BLANK + "Ваше сообщение")
    @Size(max=500)
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
