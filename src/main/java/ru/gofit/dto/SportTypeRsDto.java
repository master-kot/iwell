package ru.gofit.dto;

import io.swagger.annotations.ApiModelProperty;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Positive;
import javax.validation.constraints.Size;
import java.util.List;

import static ru.gofit.helpers.Messages.DATA_NOT_BLANK;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class SportTypeRsDto {

    @Positive
    @ApiModelProperty(notes = "Уникальный идентификатор Вида спорта",
            dataType = "Short", example = "1", required = true, position = 0)
    private Short id;

    @NotBlank(message = DATA_NOT_BLANK + "необходимо описание вида спорта")
    @Size(max=50)
    @ApiModelProperty(notes = "Описание акцента вида спорта",
            dataType = "String", example = "Тренировка для пресса", required = true, position = 1)
    private String description;

    @ApiModelProperty(notes = "Идентификаторы клиентов, выбравших этот вид спорта",
            dataType = "Long", example = "45", required = true, position = 2)
    private List<Long> clientProfilesId;

    @ApiModelProperty(notes = "Идентификаторы тренеров, проводящих тренировки по этому виду спорта",
            dataType = "Long", example = "21", required = true, position = 3)
    private List<Long> coachProfilesId;
}
