package ru.auheal.dto;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;
import javax.validation.constraints.Positive;

/**
 * Dto представление сущности Услуга
 */
@Data
@JsonIgnoreProperties(ignoreUnknown = true)
@ApiModel(description = "Dto представление сущности Услуга")
public class ServiceDto {

    @Positive
    @ApiModelProperty(notes = "Уникальный идентификатор услуги", dataType = "Long", example = "1", required = true, position = 0)
    private Long serviceId;

    @ApiModelProperty(notes = "Название услуги", dataType = "String",  example = "абонимент хатха-йога", required = true, position = 1)
    private String serviceName;
}