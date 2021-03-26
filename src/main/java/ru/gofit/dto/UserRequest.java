package ru.gofit.dto;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;

import static ru.gofit.helpers.Messages.*;

/**
 * Запрос для регистрации нового Пользователя
 */
@Data
@JsonIgnoreProperties(ignoreUnknown = true)
public class UserRequest {

    @Email
    @Size(min=4, max=50, message = INVALID_USERNAME_LENGTH)
    @NotBlank(message = DATA_NOT_BLANK + "Адрес эл. почты")
    @ApiModelProperty(notes = "Email пользователя, от 4 до 50 символов",
            dataType = "String", example = "abc@mail.ru", required = true, position = 0)
    private String username;

    @Size(min=6, max=25, message = INVALID_PASSWORD_LENGTH)
    @NotBlank(message = DATA_NOT_BLANK + "Пароль")
    @ApiModelProperty(notes = "Пароль пользователя, от 6 до 25 символов",
            dataType = "String", required = true, position = 3)
    private String password;
}
