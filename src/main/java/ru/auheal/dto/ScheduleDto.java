package ru.auheal.dto;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;
import org.springframework.format.annotation.DateTimeFormat;

import javax.validation.constraints.Positive;
import java.time.LocalDate;
import java.time.LocalTime;


/**
 * Dto представление сущности Расписание
 */
@Data
@JsonIgnoreProperties(ignoreUnknown = true)
@ApiModel(description = "Dto представление сущности Расписание")
public class ScheduleDto {

    @Positive
    @ApiModelProperty(notes = "Уникальный идентификатор Расписания", dataType = "Long", example = "1", required = true, position = 0)
    private Long eventId;

    @DateTimeFormat(pattern="yyyy.MM.dd")
    @ApiModelProperty(notes = "Дата проведения тренировки", dataType = "LocalDate", example = "2007-12-03", required = true, position = 1)
    private LocalDate dateEvent;

    @DateTimeFormat(pattern="HH:mm")
    @ApiModelProperty(notes = "Время начала тренировки", dataType = "LocalTime", example = "10:15", required = true, position = 2)
    private LocalTime startTimeEvent;

    @DateTimeFormat(pattern="HH:mm")
    @ApiModelProperty(notes = "Время окончания тренировки", dataType = "LocalTime", example = "10:15", required = true, position = 3)
    private LocalTime endTimeEvent;

    @ApiModelProperty(notes = "Вид спорта", dataType = "String",  required = true, position = 4)
    private String sportType;

    @Positive
    @ApiModelProperty(notes = "Id сотрудника", dataType = "Long", example = "1", required = true, position = 5)
    private Long couchId;

    @Positive
    @ApiModelProperty(notes = "Id услуги", dataType = "Long", example = "1", required = true, position = 6)
    private Long serviceId;

    @Positive
    @ApiModelProperty(notes = "Id тренировки", dataType = "Long", example = "1", required = true, position = 8)
    private Long trainingId;
}