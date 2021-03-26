package ru.gofit.dto;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;
import org.springframework.format.annotation.DateTimeFormat;

import javax.validation.constraints.Size;
import java.time.LocalDateTime;
import java.util.List;


/**
 * Request запрос на создание сущности Тренировка
 */
@Data
@JsonIgnoreProperties(ignoreUnknown = true)
@ApiModel(description = "Dto представление сущности Тренировка")
public class TrainingRqDto {

    @Size(max=150)
    @ApiModelProperty(notes = "Название тренировки",
            dataType = "String",  example = "Тренировка хатха-йога", required = true, position = 1)
    private String name;

    @DateTimeFormat(pattern="HH:mm")
    @ApiModelProperty(notes = "Время начала тренировки",
            dataType = "LocalTime", example = "10:15", required = true, position = 2)
    private LocalDateTime startDateTime;

    @DateTimeFormat(pattern="HH:mm")
    @ApiModelProperty(notes = "Время окончания тренировки",
            dataType = "LocalTime", example = "10:15", required = true, position = 3)
    private LocalDateTime endDateTime;

    @ApiModelProperty(notes = "Вид спорта",
            dataType = "String",  required = true, position = 4)
    private String sportType;

    @ApiModelProperty(notes = "Требуемый уровень клиента",
            dataType = "SportLevelRsDto",  required = true, position = 5)
    private String sportLevel;

    @ApiModelProperty(notes = "Требуемый инвентарь для тренировки",
            dataType = "String",  required = true, position =6)
    private List<String> inventories;

    @ApiModelProperty(notes = "Акцент на который направлено занятие",
            dataType = "String",  required = true, position = 7)
    private String accent;

    @ApiModelProperty(notes = "Количество участников тренировки",
            dataType = "Short", example = "2", required = true, position = 8)
    private Short capacity;

    @Size(max=50)
    @ApiModelProperty(notes = "Продолжительность тренировки",
            dataType = "String",  example = "30 минут", required = true, position = 9)
    private String duration;
}
