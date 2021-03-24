package ru.auheal.controllers;

import io.swagger.annotations.*;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.annotation.Secured;
import org.springframework.security.core.Authentication;
import org.springframework.web.bind.annotation.*;
import ru.auheal.dto.ErrorDto;
import ru.auheal.dto.TrainingDto;
import ru.auheal.services.api.ReviewService;
import ru.auheal.services.api.SportTypeService;
import ru.auheal.services.api.TrainingService;

import javax.validation.Valid;
import java.time.LocalDate;
import java.util.List;

import static ru.auheal.helpers.Messages.DATA_NOT_FOUND;
import static ru.auheal.helpers.Messages.SUCCESSFUL_REQUEST;
import static ru.auheal.helpers.Roles.ROLE_ADMIN;
import static ru.auheal.helpers.Roles.ROLE_USER;


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
    public ResponseEntity<List<TrainingDto>> readAllEvent() {
        return ResponseEntity.ok(trainingService.getAllDto());
    }

    //Метод trainingService.getAllDtoByAuth не реализован

    @ApiOperation(value = "Отображает список всех тренировок пользователя")
    @Secured(value = {ROLE_USER, ROLE_ADMIN})
    @GetMapping ("/calendar")
    public ResponseEntity<List<TrainingDto>> readAllEventByAuth(Authentication authentication){
        return ResponseEntity.ok(trainingService.findAllDtoByAuth(authentication));
    }
}
