package ru.gofit.dto;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;
import org.springframework.format.annotation.DateTimeFormat;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Positive;
import java.time.LocalDateTime;

import static ru.gofit.helpers.Messages.DATA_NOT_BLANK;

/**
 * Dto представление сущности Пакет тренировок
 */
@Data
@JsonIgnoreProperties(ignoreUnknown = true)
@ApiModel(description = "Dto представление сущности Абонемент")
public class SubscriptionDto {

    //TODO проверить все типы переменных входящих полей и их позиции,
    // добавить недостающие поля, enum типы привести к String
    // сложные внутренние типы привести к простым
    // добавить валидацию полей согласно ограничениям из БД

    @Positive
    @ApiModelProperty(notes = "Уникальный идентификатор Абонемента",
            dataType = "Long", example = "1", required = true, position = 0)
    private Long subscriptionId;

    @NotBlank(message = DATA_NOT_BLANK + "Дата начала действия абонемента")
    @DateTimeFormat(pattern="yyyy.MM.dd")
    @ApiModelProperty(notes = "Дата начала действия абонемента",
            dataType = "LocalDate", example = "2021-03-14", required = true, position = 1)
    private LocalDateTime startDateTime;

    @NotBlank(message = DATA_NOT_BLANK + "Дата окончания действия абонемента")
    @DateTimeFormat(pattern="yyyy.MM.dd")
    @ApiModelProperty(notes = "Дата окончания действия абонемента",
            dataType = "LocalDate", example = "2021-09-14", required = true, position = 2)
    private LocalDateTime endDateTime;

    @Positive
    @ApiModelProperty(notes = "Стоимость пакета",
            dataType = "Long", example = "1", required = true, position = 3)
    private Integer totalPrice;

    @Positive
    @ApiModelProperty(notes = "Общее количество тренировок",
            dataType = "Long", example = "1", required = true, position = 4)
    private Short initialAmount;

    @Positive
    @ApiModelProperty(notes = "Оставшееся количество тренировок",
            dataType = "Long",  example = "1", required = true, position = 5)
    private Short remainingAmount;

    @NotBlank(message = DATA_NOT_BLANK + "Продолжительность тренировки")
    @ApiModelProperty(notes = "Продолжительность тренировки",
            dataType = "Long", example = "1", required = true, position = 6)
    private String duration;
}
