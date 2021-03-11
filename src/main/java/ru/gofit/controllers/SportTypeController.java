package ru.gofit.controllers;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;
import ru.gofit.dto.SportTypeRqDto;
import ru.gofit.dto.SportTypeRsDto;
import ru.gofit.exceptions.DataNotFoundException;
import ru.gofit.services.api.SportTypeService;

import javax.validation.Valid;
import java.net.URI;

import static ru.gofit.helpers.Messages.DATA_WAS_NOT_FOUND_BY_ID;

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
        return sportTypeService.getById(id)
                .orElseThrow(() ->
                        new DataNotFoundException(String.format(DATA_WAS_NOT_FOUND_BY_ID, id))
                );
    }

    @ApiOperation("Создать вида спорта")
    @PostMapping
    public ResponseEntity<SportTypeRsDto> create(@Valid @RequestBody SportTypeRqDto sportTypeRqDto) {
        SportTypeRsDto sportTypeRsDto = sportTypeService.create(sportTypeRqDto);
        URI location = ServletUriComponentsBuilder.fromCurrentRequest()
                .path("/{id}")
                .buildAndExpand(sportTypeRsDto.getId())
                .toUri();
        return ResponseEntity.created(location)
                .body(sportTypeRsDto);
    }
}
