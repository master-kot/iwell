package ru.auheal.dto;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import javax.validation.constraints.Positive;

/**
 * Dto представление покупки товара
 */
@Data
@JsonIgnoreProperties(ignoreUnknown = true)
@ApiModel(description = "Dto представление покупки товара")
public class ProductItemDto {

    @Positive
    @ApiModelProperty(notes = "Уникальный идентификатор покупки товара", dataType = "Long", example = "1", required = true, position = 0)
    private Long itemId;

    @Positive
    @ApiModelProperty(notes = "Количество товара", dataType = "Long",  example = "1", required = true, position = 1)
    private Long quantityProducts;

    @Positive
    @ApiModelProperty(notes = "Товар", dataType = "ProductDto", example = "1", required = true, position = 2)
    private ProductDto productDto;

    @Positive
    @ApiModelProperty(notes = "Клиент", dataType = "UserDto", required = true, position = 3)
    private UserDto userDto;
}