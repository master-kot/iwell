package ru.gofit.dto;

import io.swagger.annotations.ApiModelProperty;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class SportTypeRsDto {

    @ApiModelProperty("Вида спорта")
    private Short id;

    @ApiModelProperty("Описание вида спорта")
    private String description;
}
