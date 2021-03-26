package ru.gofit.controllers;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import ru.gofit.dto.ErrorDto;
import ru.gofit.dto.SubscriptionDto;
import ru.gofit.services.api.ReviewService;
import ru.gofit.services.api.SportTypeService;
import ru.gofit.services.api.SubscriptionService;
import ru.gofit.services.api.TrainingService;

import java.util.List;

import static ru.gofit.helpers.Messages.DATA_NOT_FOUND;
import static ru.gofit.helpers.Messages.SUCCESSFUL_REQUEST;


@CrossOrigin
@RestController
@RequiredArgsConstructor
@RequestMapping(value = "/api/v1/subscriptions", produces = "application/json")
@Api(value = "/api/v1/subscriptions", tags = {"Контроллер Абонементов"})
public class SubscriptionController {

    // Список необходимых зависимостей
    private final TrainingService trainingService;
    private final SportTypeService sportTypeService;
    private final ReviewService reviewService;
    private final SubscriptionService subscriptionService;


    @ApiOperation(value = "Отображает все абонементы")
    @ApiResponses(value = {
            @ApiResponse(code = 200, message = SUCCESSFUL_REQUEST),
            @ApiResponse(code = 404, message = DATA_NOT_FOUND, response = ErrorDto.class)
    })
    @GetMapping
    public ResponseEntity<List<SubscriptionDto>> readAllEvent() {
        return ResponseEntity.ok(subscriptionService.getAllDto());
    }
}
