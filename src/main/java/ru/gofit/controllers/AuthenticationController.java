package ru.gofit.controllers;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;
import lombok.RequiredArgsConstructor;
import lombok.extern.log4j.Log4j2;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.web.bind.annotation.*;
import ru.gofit.dto.AuthenticationDto;
import ru.gofit.dto.AuthenticationRequest;
import ru.gofit.dto.ErrorDto;
import ru.gofit.security.JwtTokenProvider;
import ru.gofit.security.JwtUser;
import ru.gofit.services.api.UserService;

import javax.validation.Valid;
import java.util.stream.Collectors;

import static ru.gofit.helpers.Messages.*;

@Log4j2
@CrossOrigin
@RestController
@RequestMapping(value = "/api/v1/auth")
@RequiredArgsConstructor
@Api(value = "/api/v1/auth", tags = {"Контроллер авторизации пользователя"})
public class AuthenticationController {

    // Список необходимых зависимостей
    private final AuthenticationManager authenticationManager;
    private final JwtTokenProvider jwtTokenProvider;
    private final UserService userService;

    @PostMapping("/login")
    @ApiOperation(value = "Осуществляет выдачу токена авторизации пользователя")
    @ApiResponses(value = {
            @ApiResponse(code = 200, message = SUCCESSFUL_REQUEST),
            @ApiResponse(code = 400, message = BAD_REQUEST, response = ErrorDto.class)
    })
    public ResponseEntity<AuthenticationDto> login(@Valid @RequestBody AuthenticationRequest requestDto) {
        try {
            String username = requestDto.getEmail();
            authenticationManager.authenticate(
                    new UsernamePasswordAuthenticationToken(username, requestDto.getPassword()));
            JwtUser user = userService.getJwtByUsername(username);
            if (user == null) {
                throw new UsernameNotFoundException(String.format(USER_NOT_FOUND_BY_USERNAME, username));
            }
            log.debug(String.format(USER_WAS_FOUND, username));

            String token = jwtTokenProvider.createToken(username, user.getId(),
                    user.getAuthorities().stream().map(GrantedAuthority::getAuthority).collect(Collectors.toList()));

            return ResponseEntity.ok(new AuthenticationDto(token));
        } catch (AuthenticationException e) {
            log.debug(e);
            throw new BadCredentialsException(BAD_CREDENTIALS);
        }
    }
}
