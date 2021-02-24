package ru.auheal.dto;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import javax.validation.constraints.Positive;

/**
 * Dto представление сущности Товар
 */
@Data
@JsonIgnoreProperties(ignoreUnknown = true)
@ApiModel(description = "Dto представление сущности Товар")
public class ProductDto {

    @Positive
    @ApiModelProperty(notes = "Уникальный идентификатор товара", dataType = "Long", example = "1", required = true, position = 0)
    private Long trainingId;

    @ApiModelProperty(notes = "Название товара", dataType = "String",  example = "Тренировка хатха-йога", required = true, position = 1)
    private String trainingName;

    @Positive
    @ApiModelProperty(notes = "Цена товара", dataType = "Long", example = "1", required = true, position = 2)
    private Long priceProduct;

    @Positive
    @ApiModelProperty(notes = "Количество товара в наличии", dataType = "Long", example = "1", required = true, position = 3)
    private Long countOfProduct;
}