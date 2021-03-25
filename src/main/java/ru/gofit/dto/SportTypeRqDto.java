package ru.gofit.dto;

import io.swagger.annotations.ApiModelProperty;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.validation.constraints.NotBlank;

import static ru.gofit.helpers.Messages.DATA_NOT_BLANK;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class SportTypeRqDto {

    @ApiModelProperty("Описание вида спорта")
    @NotBlank(message = DATA_NOT_BLANK + ": Описание вида спорта")
    private String description;
}
