package ru.gofit.dto;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;
import org.springframework.format.annotation.DateTimeFormat;

import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Positive;
import javax.validation.constraints.Size;

import static ru.gofit.helpers.Messages.DATA_NOT_BLANK;
import static ru.gofit.helpers.Messages.INVALID_USERNAME_LENGTH;

/**
 * Dto представление сущности Пользователь
 */
@Data
@JsonIgnoreProperties(ignoreUnknown = true)
@ApiModel(description = "Dto представление сущности Пользователь")
public class UserDto {

    //TODO проверить все типы переменных входящих полей и их позиции,
    // добавить недостающие поля, enum типы привести к String
    // сложные внутренние типы привести к простым
    // добавить валидацию полей согласно ограничениям из БД

    @Positive
    @ApiModelProperty(notes = "Уникальный идентификатор Пользователя",
            dataType = "Long", example = "1", required = true, position = 0)
    private Long id;

    @Email
    @Size(min=4, max=50, message = INVALID_USERNAME_LENGTH)
    @NotBlank(message = DATA_NOT_BLANK + "Логин")
    @ApiModelProperty(notes = "Email Пользователя",
            dataType = "String", example = "ivanov@gmail.com", required = true, position = 1)
    private String username;

    @NotBlank(message = DATA_NOT_BLANK + "Имя")
    @ApiModelProperty(notes = "Имя Пользователя",
            dataType = "String", example = "Николай", required = true, position = 2)
    private String firstName;

    @NotBlank(message = DATA_NOT_BLANK + "Фамилия")
    @ApiModelProperty(notes = "Фамилия Пользователя",
            dataType = "String", example = "Иванов", required = true, position = 3)
    private String  lastnameName;

    @NotBlank(message = DATA_NOT_BLANK + "Адрес пользователя")
    @ApiModelProperty(notes = "Адрес пользователя",
            dataType = "String", example = "Ленинградский проспект, 32", required = true, position = 4)
    private String address;

    @NotBlank(message = DATA_NOT_BLANK + "Телефон пользователя")
    @ApiModelProperty(notes = "Адрес пользователя",
            dataType = "String", example = "+7 495 5526453", required = true, position = 5)
    private String phone;

    @DateTimeFormat(pattern="yyyy.MM.dd")
    @ApiModelProperty(notes = "Дата рожнения пользователя",
            dataType = "String", example = "2003-04-05",  position = 6)
    private String birthdayDate;

    @NotBlank(message = DATA_NOT_BLANK + "Укажите пол")
    @ApiModelProperty(notes = "Пол пользователя пользователя, варианты: Женский, Мужской, Не выбран",
            dataType = "String",  example = "Женский", required = true, position = 7)
    @NotBlank(message = DATA_NOT_BLANK + "Пол")
    private String gender;

    @ApiModelProperty(notes = "Информация о пользователя",
            dataType = "String",  example = "Информация о пользователе", position = 8)
    @Size(max=1024)
    private String info;

    @ApiModelProperty(notes = "Ссылка на файл фото",
            dataType = "String",  example = "myphoto.png", position = 9)
    @Size(max = 1024)
    private String photoLink;
}
