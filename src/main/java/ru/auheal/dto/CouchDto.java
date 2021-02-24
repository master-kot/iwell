package ru.auheal.dto;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;
import org.springframework.format.annotation.DateTimeFormat;

import javax.validation.constraints.*;

import static ru.auheal.helpers.Messages.DATA_NOT_BLANK;


/**
 * Dto представление сущности Тренер
 */
@Data
@JsonIgnoreProperties(ignoreUnknown = true)
@ApiModel(description = "Dto представление сущности Тренер")
public class CouchDto {

    @Positive
    @NotBlank(message = DATA_NOT_BLANK)
    @ApiModelProperty(notes = "Уникальный идентификатор тренера", dataType = "Long", example = "1", required = true, position = 0)
    private Long id;

    @ApiModelProperty(notes = "Имя тренера", dataType = "String",  example = "Иван", required = true, position = 1)
    @NotBlank(message = DATA_NOT_BLANK + "Имя")
    private String firstName;

    @ApiModelProperty(notes = "Фамилия пользователя", dataType = "String",  example = "Иванов",  required = true, position = 2)
    private String lastName;

    @NotBlank(message = DATA_NOT_BLANK + "Адрес тренера")
    @ApiModelProperty(notes = "Адрес тренера", dataType = "String", example = "Ленинградский проспект, 32", required = true, position = 3)
    private String address;

    @NotBlank(message = DATA_NOT_BLANK + "Телефон тренера")
    @ApiModelProperty(notes = "Адрес тренера", dataType = "String", example = "+7 495 5526453", required = true, position = 3)
    private String phone;

    @DateTimeFormat(pattern="yyyy.MM.dd")
    @ApiModelProperty(notes = "Дата рожнения тренера", dataType = "String", example = "2003-04-05",  position = 4)
    private String birthdayDate;

    @NotBlank(message = DATA_NOT_BLANK + "Укажите пол")
    @ApiModelProperty(notes = "Пол пользователя тренера", dataType = "String",  example = "Ж", required = true, position = 5)
    @NotBlank(message = DATA_NOT_BLANK + "Пол")
    private String gender;

    @ApiModelProperty(notes = "Информация о тренере", dataType = "String",  example = "Информация о пользователе", position = 6)
    @Size(max=1024)
    private String info;

    @NotBlank(message = DATA_NOT_BLANK)
    @ApiModelProperty(notes = "Оклад тренера", dataType = "Long", example = "1", required = true, position = 7)
    private Long salary;

    @ApiModelProperty(notes = "Ссылка на файл фото", dataType = "String",  example = "myphoto.png", position = 8)
    @Size(max = 1024)
    private String photoLink;


}