package ru.auheal.dto;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;
import org.springframework.format.annotation.DateTimeFormat;
import ru.auheal.enums.SportLevel;

import javax.validation.constraints.Positive;
import javax.validation.constraints.Size;
import java.time.LocalDateTime;
import java.util.List;

/**
 * Dto представление сущности Тренировка
 */
@Data
@JsonIgnoreProperties(ignoreUnknown = true)
@ApiModel(description = "Dto представление сущности Тренировка")
public class TrainingDto {

    //TODO проверить все типы переменных входящих полей и их позиции,
    // добавить недостающие поля, enum типы привести к String
    // сложные внутренние типы привести к простым
    // добавить валидацию полей согласно ограничениям из БД

    @Positive
    @ApiModelProperty(notes = "Уникальный идентификатор тренировки",
            dataType = "Long", example = "1", required = true, position = 0)
    private Long trainingId;

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
    private SportTypeDto sportTypeDto;

    @ApiModelProperty(notes = "Требуемый уровень клиента",
            dataType = "SportLevelDto",  required = true, position = 5)
    private SportLevelDto sportLevelDto;

    @ApiModelProperty(notes = "Требуемый инвентарь для тренировки",
            dataType = "InventoryDto",  required = true, position =6)
    private List<InventoryDto> inventoryDto;

    @ApiModelProperty(notes = "Акцент тренировки (что тренируем)",
            dataType = "SportLevelDto",  required = true, position = 7)
    private AccentDto accentDto;

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
    private SubscriptionDto subscriptionDto;

    @ApiModelProperty(notes = "Количество участников тренировки",
            dataType = "Boolean", example = "true", required = true, position = 14)
    private Boolean wasCompleted;

    @Size(max=100)
    @ApiModelProperty(notes = "Комментарий тренера",
            dataType = "String",  example = "Все отлично", position = 15)
    private String comment;
}