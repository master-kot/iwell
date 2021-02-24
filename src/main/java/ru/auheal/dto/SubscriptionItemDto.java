package ru.auheal.dto;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;
import javax.validation.constraints.Positive;

/**
 * Dto представление покупки абонемента
 */

@Data
@JsonIgnoreProperties(ignoreUnknown = true)
@ApiModel(description = "Dto представление покупки абонемента")
public class SubscriptionItemDto {

    @Positive
    @ApiModelProperty(notes = "Уникальный идентификатор покупки товара", dataType = "Long", example = "1", required = true, position = 0)
    private Long itemId;

    @Positive
    @ApiModelProperty(notes = "Количество товара", dataType = "Long",  example = "1", required = true, position = 1)
    private Long quantityProducts;

    @Positive
    @ApiModelProperty(notes = "Абонемент", dataType = "ProductDto", example = "1", required = true, position = 2)
    private ScheduleDto subscriptionDto;

    @Positive
    @ApiModelProperty(notes = "Клиент", dataType = "UserDto", required = true, position = 4)
    private UserDto userDto;
}