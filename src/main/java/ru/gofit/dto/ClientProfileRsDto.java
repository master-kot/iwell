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
public class ClientProfileRsDto {

    @ApiModelProperty("id профиля клиента")
    private Long id;

    @ApiModelProperty("id клиента")
    private Long userId;

    @ApiModelProperty("Короткая информация о клиенте")
    private String clientInfo;

    @ApiModelProperty("Спортивные достижения клиента")
    private String sportsAchivments;

    @ApiModelProperty("Спортивный разряд")
    private String sportsGrade;
}
