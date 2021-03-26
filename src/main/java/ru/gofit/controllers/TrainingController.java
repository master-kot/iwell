package ru.gofit.controllers;

import io.swagger.annotations.*;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.annotation.Secured;
import org.springframework.security.core.Authentication;
import org.springframework.web.bind.annotation.*;
import ru.gofit.dto.ErrorDto;
import ru.gofit.dto.TrainingRsDto;
import ru.gofit.services.api.ReviewService;
import ru.gofit.services.api.SportTypeService;
import ru.gofit.services.api.TrainingService;

import java.util.List;

import static ru.gofit.helpers.Messages.DATA_NOT_FOUND;
import static ru.gofit.helpers.Messages.SUCCESSFUL_REQUEST;
import static ru.gofit.helpers.Roles.ROLE_ADMIN;
import static ru.gofit.helpers.Roles.ROLE_USER;


@CrossOrigin
@RestController
@RequiredArgsConstructor
@RequestMapping(value = "/api/v1/trainings", produces = "application/json")
@Api(value = "/api/v1/trainings", tags = {"Контроллер Тренировок"})
public class TrainingController {

    // Список необходимых зависимостей
    private final TrainingService trainingService;
    private final SportTypeService sportTypeService;
    private final ReviewService reviewService;
    

    @ApiOperation(value = "Отображает данные всех мероприятий")
    @ApiResponses(value = {
            @ApiResponse(code = 200, message = SUCCESSFUL_REQUEST),
            @ApiResponse(code = 404, message = DATA_NOT_FOUND, response = ErrorDto.class)
    })
    @GetMapping
    public ResponseEntity<List<TrainingRsDto>> readAllEvent() {
        return ResponseEntity.ok(trainingService.getAllDto());
    }

    //Метод trainingService.getAllDtoByAuth не реализован

    @ApiOperation(value = "Отображает список всех тренировок пользователя")
    @Secured(value = {ROLE_USER, ROLE_ADMIN})
    @GetMapping ("/calendar")
    public ResponseEntity<List<TrainingRsDto>> readAllEventByAuth(Authentication authentication){
        return ResponseEntity.ok(trainingService.findAllDtoByAuth(authentication));
    }
}
