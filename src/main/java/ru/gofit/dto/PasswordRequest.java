package ru.gofit.dto;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;

import static ru.gofit.helpers.Messages.*;

/**
 * Запрос на изменение пароля
 */
@Data
@JsonIgnoreProperties(ignoreUnknown = true)
@ApiModel(description = "Запрос на изменение пароля")
public class PasswordRequest {

    @Size(min=4, max=20, message = INVALID_PASSWORD_LENGTH)
    @NotBlank(message = DATA_NOT_BLANK + "Старый пароль")
    @ApiModelProperty(notes = "Старый пароль пользователя", dataType = "String", required = true, position = 0)
    private String oldPassword;

    @Size(min=4, max=20, message = INVALID_PASSWORD_LENGTH)
    @NotBlank(message = DATA_NOT_BLANK + "Новый пароль")
    @ApiModelProperty(notes = "Новый пароль пользователя", dataType = "String", required = true, position = 1)
    private String newPassword;

    @ApiModelProperty(notes = "Подтверждение пароля", dataType = "String", required = true, position = 2)
    private String newPasswordConfirm;
}
