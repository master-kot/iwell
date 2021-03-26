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
public class TrainingRequest {
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
            dataType = "SportTypeDto",  required = true, position = 4)
    private Short sportTypeId;

    @ApiModelProperty(notes = "Требуемый уровень клиента",
            dataType = "SportLevelDto",  required = true, position = 5)
    private String sportLevel;

    @ApiModelProperty(notes = "Требуемый инвентарь для тренировки",
            dataType = "InventoryDto",  required = true, position =6)
    private List<Short> inventoryId;

    @ApiModelProperty(notes = "Акцент тренировки (что тренируем)",
            dataType = "SportLevelDto",  required = true, position = 7)
    private Short accentId;

    @ApiModelProperty(notes = "Id тренера, проводящего тенировку",
            dataType = "ClientProfile",   required = true, position = 8)
    private Long couchProfileId;

    @ApiModelProperty(notes = "Id клиента",
            dataType = "ClientProfile",   required = true, position = 9)
    private Long clientProfileId;

    @Size(max=150)
    @ApiModelProperty(notes = "Ссылка на трансляцию",
            dataType = "String",  example = "https://zoom.us/____", required = true, position = 10)
    private String videoLink;

    @ApiModelProperty(notes = "Количество участников тренировки",
            dataType = "Short", example = "2", required = true, position = 11)
    private Short capacity;

    @Size(max=50)
    @ApiModelProperty(notes = "Продолжительность тренировки",
            dataType = "String",  example = "30 минут", required = true, position = 12)
    private String duration;

    @ApiModelProperty(notes = "Абонемент клиента",
            dataType = "SubscriptionDto",   required = true, position = 13)
    private Long subscriptionId;

    @ApiModelProperty(notes = "Закончена ли тренировка",
            dataType = "Boolean", example = "true", required = true, position = 14)
    private Boolean wasCompleted;

    @Size(max=100)
    @ApiModelProperty(notes = "Комментарий тренера",
            dataType = "String",  example = "Все отлично", position = 15)
    private String comment;
}
