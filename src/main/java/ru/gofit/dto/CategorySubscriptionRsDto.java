package ru.gofit.dto;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Builder;
import lombok.Data;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Positive;

import static ru.gofit.helpers.Messages.DATA_NOT_BLANK;


/**
 * Dto представление Категория абонемента
 */
@Data
@Builder
@JsonIgnoreProperties(ignoreUnknown = true)
@ApiModel(description = "Dto представление сущности Категория Абонемент")
public class CategorySubscriptionRsDto {

    @Positive
    @ApiModelProperty(notes = "Уникальный идентификатор Абонемента",
            dataType = "Long", example = "1", required = true, position = 0)
    private Long subscriptionId;

    @Positive
    @ApiModelProperty(notes = "Общее количество тренировок",
            dataType = "Long", example = "1", required = true, position = 1)
    private Short initialAmount;

    @Positive
    @ApiModelProperty(notes = "Стоимость пакета",
            dataType = "Long", example = "1", required = true, position = 2)
    private Integer totalPrice;

    @NotBlank(message = DATA_NOT_BLANK + "Продолжительность тренировки")
    @ApiModelProperty(notes = "Продолжительность тренировки",
            dataType = "Long", example = "1", required = true, position = 3)
    private String duration;
}
