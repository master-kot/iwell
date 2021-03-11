package ru.gofit.controllers;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.web.bind.annotation.*;
import ru.gofit.dto.SportTypeRqDto;
import ru.gofit.dto.SportTypeRsDto;
import ru.gofit.services.api.SportTypeService;

import javax.validation.Valid;

@Api(tags = "Виды спорта")
@Slf4j
@RestController
@RequiredArgsConstructor
@RequestMapping("/sport_types")
public class SportTypeController {

    private final SportTypeService sportTypeService;

    @ApiOperation("Запрос списка видов спорта")
//    @ApiResponses({
//            @ApiResponse(code = HttpURLConnection.HTTP_OK, message = "OK"),
//            @ApiResponse(code = HttpURLConnection.HTTP_NOT_FOUND, message = "NOT FOUND"),
//            @ApiResponse(code = HttpURLConnection.HTTP_UNAUTHORIZED, message = "UNAUTHORIZED"),
//            @ApiResponse(code = HttpURLConnection.HTTP_FORBIDDEN, message = "FORBIDDEN")
//    })
    @GetMapping
    public Page<SportTypeRsDto> getAll(Pageable pageable) {
        return sportTypeService.getAll(pageable);
    }

    @ApiOperation("Запрос вида спорта по id")
//    @ApiResponses({
//            @ApiResponse(code = HttpURLConnection.HTTP_OK, message = "OK"),
//            @ApiResponse(code = HttpURLConnection.HTTP_NOT_FOUND, message = "NOT FOUND"),
//            @ApiResponse(code = HttpURLConnection.HTTP_UNAUTHORIZED, message = "UNAUTHORIZED"),
//            @ApiResponse(code = HttpURLConnection.HTTP_FORBIDDEN, message = "FORBIDDEN")
//    })
    @GetMapping("/{id}")
    public SportTypeRsDto getById(@ApiParam(name = "id", value = "ID вида спорта") @PathVariable Short id) {
        return sportTypeService.getById(id);
    }

    @ApiOperation("Создать вида спорта")
    @PostMapping
    public SportTypeRsDto create(@Valid @RequestBody SportTypeRqDto sportTypeRqDto) {
        return sportTypeService.create(sportTypeRqDto);
    }
}
