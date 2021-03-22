package ru.gofit.dto;

import io.swagger.annotations.ApiModelProperty;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import ru.gofit.entities.User;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.OneToOne;
import javax.validation.constraints.NotBlank;

import static ru.gofit.helpers.Messages.DATA_NOT_BLANK;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class ClientProfileRqDto {

    @ApiModelProperty("id клиента")
    @NotBlank(message = DATA_NOT_BLANK + ": id клиента")
    private Long userId;

    @ApiModelProperty("Короткая информация о клиенте")
    private String clientInfo;

    @ApiModelProperty("Спортивные достижения клиента")
    private String sportsAchivments;

    @ApiModelProperty("Спортивный разряд")
    private String sportsGrade;
}
