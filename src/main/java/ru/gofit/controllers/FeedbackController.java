package ru.gofit.controllers;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.annotation.Secured;
import org.springframework.security.core.Authentication;
import org.springframework.web.bind.annotation.*;
import ru.gofit.dto.ErrorDto;
import ru.gofit.dto.FeedbackDto;
import ru.gofit.dto.FeedbackRequest;
import ru.gofit.services.api.FeedbackService;

import javax.validation.Valid;
import java.util.List;

import static ru.gofit.helpers.Messages.*;
import static ru.gofit.helpers.Roles.ROLE_ADMIN;

/**
 * Контроллер Обратной связи.
 */
@CrossOrigin
@RestController
@RequestMapping(value = "/api/v1/feedback", produces = "application/json")
@Api(value = "/api/v1/feedback", tags = {"Контроллер Обратной связи"})
@RequiredArgsConstructor
public class FeedbackController {

    // Необходимые сервисы
    private final FeedbackService feedbackService;

    @ApiOperation(value = "Сохраняет запрос обратной связи")
    @PostMapping
    @ApiResponses(value = {
            @ApiResponse(code = 200, message = SUCCESSFUL_REQUEST),
            @ApiResponse(code = 400, message = BAD_REQUEST, response = ErrorDto.class)
    })
    public ResponseEntity<FeedbackDto> createFeedback(@Valid @RequestBody FeedbackRequest request) {
        return ResponseEntity.ok(feedbackService.save(request));
    }

    @Secured(value = {ROLE_ADMIN})
    @GetMapping
    @ApiOperation(value = "Отображает список всех данных обратной связи")
    @ApiResponses(value = {
            @ApiResponse(code = 200, message = SUCCESSFUL_REQUEST),
            @ApiResponse(code = 403, message = ACCESS_DENIED, response = ErrorDto.class)
    })
    public ResponseEntity<List<FeedbackDto>> readAllFeedbacks(Authentication authentication) {
        return ResponseEntity.ok(feedbackService.getAllDto(authentication));
    }
}
