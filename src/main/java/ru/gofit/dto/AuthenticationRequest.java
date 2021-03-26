package ru.gofit.dto;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;

import static ru.gofit.helpers.Messages.DATA_NOT_BLANK;

/**
 * Запрос авторизации
 */
@Data
@JsonIgnoreProperties(ignoreUnknown = true)
@ApiModel(description = "Запрос авторизации")
public class AuthenticationRequest {

    @NotBlank(message = DATA_NOT_BLANK + "Адрес эл. почты")
    @Email
    @ApiModelProperty(notes = "Email пользователя", dataType = "String", example = "ivanov@gmail.com", required = true, position = 0)
    private String email;

    @NotBlank(message = DATA_NOT_BLANK + "Пароль")
    private String password;
}
