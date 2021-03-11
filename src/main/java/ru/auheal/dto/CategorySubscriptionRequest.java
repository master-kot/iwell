package ru.auheal.dto;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Builder;
import lombok.Data;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Positive;

import static ru.auheal.helpers.Messages.DATA_NOT_BLANK;


/**
 * Запрос на создание Категории абонемента
 */
@Data
@Builder
@JsonIgnoreProperties(ignoreUnknown = true)
@ApiModel(description = "Запрос на создание Категории абонемента")
public class CategorySubscriptionRequest {


    @Positive
    @ApiModelProperty(notes = "Общее количество тренировок",
            dataType = "Long", example = "1", required = true, position = 0)
    private Short initialAmount;

    @Positive
    @ApiModelProperty(notes = "Стоимость пакета",
            dataType = "Long", example = "1", required = true, position = 1)
    private Integer totalPrice;

    @NotBlank(message = DATA_NOT_BLANK + "Продолжительность тренировки")
    @ApiModelProperty(notes = "Продолжительность тренировки",
            dataType = "Long", example = "1", required = true, position = 2)
    private String duration;
}