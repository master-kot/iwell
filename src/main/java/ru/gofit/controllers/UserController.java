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
import ru.gofit.dto.PasswordRequest;
import ru.gofit.dto.UserDto;
import ru.gofit.services.api.UserService;

import javax.validation.Valid;

import static ru.gofit.helpers.Messages.*;
import static ru.gofit.helpers.Roles.ROLE_ADMIN;
import static ru.gofit.helpers.Roles.ROLE_USER;

/**
 * Контроллер Пользователя.
 */
@CrossOrigin
@RestController
@RequestMapping(value = "/api/v1/profile")
@Api(value = "/api/v1/profile", tags = {"Контроллер Профиля пользователя"})
@RequiredArgsConstructor
public class UserController {

    // Тип данных
    private final String DATA_TYPE = "application/json";

    // Необходимые сервисы
    private final UserService userService;

    @Secured(value = {ROLE_USER, ROLE_ADMIN})
    @GetMapping(value = "", produces = DATA_TYPE, consumes = DATA_TYPE)
    @ApiOperation(value = "Отображает собственный профиль авторизованного пользователя")
    @ApiResponses(value = {
            @ApiResponse(code = 200, message = SUCCESSFUL_REQUEST),
            @ApiResponse(code = 403, message = ACCESS_DENIED, response = ErrorDto.class),
            @ApiResponse(code = 404, message = DATA_NOT_FOUND, response = ErrorDto.class)
    })
    public ResponseEntity<UserDto> readUser(Authentication authentication) {
        return ResponseEntity.ok(userService.getDtoByAuthentication(authentication));
    }

    @Secured(value = {ROLE_USER, ROLE_ADMIN})
    @PatchMapping(value = "", produces = DATA_TYPE, consumes = DATA_TYPE)
    @ApiOperation(value = "Изменяет собственный профиль авторизованного пользователя")
    @ApiResponses(value = {
            @ApiResponse(code = 200, message = SUCCESSFUL_REQUEST),
            @ApiResponse(code = 400, message = BAD_REQUEST, response = ErrorDto.class),
            @ApiResponse(code = 403, message = ACCESS_DENIED, response = ErrorDto.class),
            @ApiResponse(code = 404, message = DATA_NOT_FOUND, response = ErrorDto.class)
    })
    public ResponseEntity<UserDto> updateUser(@Valid @RequestBody UserDto userDto,
                                              Authentication authentication) {
        return ResponseEntity.ok(userService.update(userDto, authentication));
    }

    @Secured(value = {ROLE_USER, ROLE_ADMIN})
    @GetMapping(value = "/{id}", produces = DATA_TYPE)
    @ApiOperation(value = "Возваращает пользователя по его id")
    @ApiResponses(value = {
            @ApiResponse(code = 200, message = SUCCESSFUL_REQUEST),
            @ApiResponse(code = 400, message = BAD_REQUEST, response = ErrorDto.class),
            @ApiResponse(code = 403, message = ACCESS_DENIED, response = ErrorDto.class),
            @ApiResponse(code = 404, message = DATA_NOT_FOUND, response = ErrorDto.class)
    })
    public ResponseEntity<UserDto> readUserById(@Valid @PathVariable Long id) {
        return ResponseEntity.ok(userService.getDtoById(id));
    }

    @Secured(value = {ROLE_USER, ROLE_ADMIN})
    @PatchMapping(value = "/password", produces = DATA_TYPE, consumes = DATA_TYPE)
    @ApiOperation(value = "Изменяет пароль авторизованного пользователя")
    @ApiResponses(value = {
            @ApiResponse(code = 200, message = SUCCESSFUL_REQUEST, response = boolean.class),
            @ApiResponse(code = 403, message = ACCESS_DENIED, response = ErrorDto.class),
            @ApiResponse(code = 400, message = BAD_REQUEST, response = ErrorDto.class)
    })
    public ResponseEntity<?> updateUserPassword(@Valid @RequestBody PasswordRequest passwordRequest,
                                                Authentication authentication) {
        return userService.updatePassword(passwordRequest, authentication) ?
                ResponseEntity.ok().build() : ResponseEntity.badRequest().build();
    }
}
