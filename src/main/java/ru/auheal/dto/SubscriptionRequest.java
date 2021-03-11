package ru.auheal.dto;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;
import org.springframework.format.annotation.DateTimeFormat;
import ru.auheal.entities.ClientProfile;
import ru.auheal.entities.Training;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Positive;
import java.time.LocalDateTime;
import java.util.List;

import static ru.auheal.helpers.Messages.DATA_NOT_BLANK;

/**
 * Запрос на создание пакета тренировок
 */
@Data
@JsonIgnoreProperties(ignoreUnknown = true)
@ApiModel(description = "Запрос на создание пакета тренировок")
public class SubscriptionRequest {

    @NotBlank(message = DATA_NOT_BLANK + "Дата начала действия абонемента")
    @DateTimeFormat(pattern = "yyyy.MM.dd")
    @ApiModelProperty(notes = "Дата начала действия абонемента",
            dataType = "LocalDate", example = "2021-03-14", required = true, position = 0)
    private LocalDateTime startDateTime;

    @NotBlank(message = DATA_NOT_BLANK + "Дата окончания действия абонемента")
    @DateTimeFormat(pattern = "yyyy.MM.dd")
    @ApiModelProperty(notes = "Дата окончания действия абонемента",
            dataType = "LocalDate", example = "2021-09-14", required = true, position = 1)
    private LocalDateTime endDateTime;

    @Positive
    @ApiModelProperty(notes = "Общее количество тренировок",
            dataType = "Long", example = "1", required = true, position = 2)
    private Short initialAmount;

    @Positive
    @ApiModelProperty(notes = "Стоимость пакета",
            dataType = "Long", example = "1", required = true, position = 3)
    private Integer totalPrice;

    @NotBlank(message = DATA_NOT_BLANK + "Продолжительность тренировки")
    @ApiModelProperty(notes = "Продолжительность тренировки",
            dataType = "Long", example = "1", required = true, position = 4)
    private String duration;

    @NotBlank(message = DATA_NOT_BLANK + "Профиль клиента")
    @ApiModelProperty(notes = "Лрофиль клиента",
            dataType = "ClitnyProfile", required = true, position = 7)
    private ClientProfile clientProfile;

    @NotBlank(message = DATA_NOT_BLANK + "Список тренировок")
    @ApiModelProperty(notes = "Тренировки, входящие в абонимент",
            dataType = "List<Training>", required = true, position = 6)
    private List<Training> trainings;




}