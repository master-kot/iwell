package ru.auheal.dto;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;
import org.springframework.format.annotation.DateTimeFormat;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Positive;
import java.time.LocalDate;

import static ru.auheal.helpers.Messages.DATA_NOT_BLANK;

/**
 * Dto представление сущности Абонемент
 */
@Data
@JsonIgnoreProperties(ignoreUnknown = true)
@ApiModel(description = "Dto представление сущности Абонемент")
public class SubscriptionDto {

    @Positive
    @ApiModelProperty(notes = "Уникальный идентификатор Абонемента", dataType = "Long", example = "1", required = true, position = 0)
    private Long subscriptionId;

    @NotBlank(message = DATA_NOT_BLANK + "Название тренировки")
    @ApiModelProperty(notes = "Название тренировки", dataType = "String",  example = "тренировка хатха-йога", required = true, position = 1)
    private String trainingName;

    @Positive
    @ApiModelProperty(notes = "Цена Абонемента", dataType = "Long", example = "1", required = true, position = 2)
    private Long priceSubscription;

    @Positive
    @ApiModelProperty(notes = "Количество посещений", dataType = "Long", example = "1", required = true, position = 3)
    private Long countVisits;

    @NotBlank(message = DATA_NOT_BLANK + "Дата начала действия абонемента")
    @DateTimeFormat(pattern="yyyy.MM.dd")
    @ApiModelProperty(notes = "Дата начала действия абонемента", dataType = "LocalDate", example = "2021-03-14", required = true, position = 1)
    private LocalDate dateStart;

    @NotBlank(message = DATA_NOT_BLANK + "Дата окончания действия абонемента")
    @DateTimeFormat(pattern="yyyy.MM.dd")
    @ApiModelProperty(notes = "Дата окончания действия абонемента", dataType = "LocalDate", example = "2021-09-14", required = true, position = 1)
    private LocalDate dateStop;
}