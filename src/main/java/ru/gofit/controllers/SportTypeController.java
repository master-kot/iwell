package ru.gofit.controllers;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import ru.gofit.dto.SportTypeRqDto;
import ru.gofit.dto.SportTypeRsDto;
import ru.gofit.services.api.SportTypeService;

import javax.validation.Valid;

@Api(tags = "Виды спорта")
@RestController
@RequiredArgsConstructor
@RequestMapping("/sport_types")
public class SportTypeController {

    private final SportTypeService sportTypeService;

    @ApiOperation("Запрос списка видов спорта")
    @GetMapping
    public Page<SportTypeRsDto> getAll(Pageable pageable) {
        return sportTypeService.getAll(pageable);
    }

    @ApiOperation("Запрос вида спорта по id")
    @GetMapping("/{id}")
    public SportTypeRsDto getById(@ApiParam(name = "id", value = "ID вида спорта") @PathVariable Short id) {
        return sportTypeService.getById(id);
    }

    @ApiOperation("Создать вид спорта")
    @PostMapping
    public SportTypeRsDto save(@Valid @RequestBody SportTypeRqDto sportTypeRqDto) {
        return sportTypeService.save(sportTypeRqDto);
    }

    @ApiOperation("Обновить вид спорта")
    @PutMapping("/{id}")
    public SportTypeRsDto update(@ApiParam(name = "id", value = "ID вида спорта") @PathVariable Short id,
                                 @RequestBody SportTypeRqDto sportTypeRqDto) {
        return sportTypeService.update(id, sportTypeRqDto);
    }

    @ApiOperation("Удалить вид спорта")
    @DeleteMapping("/{id}")
    public ResponseEntity<?> delete(@ApiParam(name = "id", value = "ID вида спорта") @PathVariable Short id) {
        sportTypeService.deleteById(id);
        return ResponseEntity.accepted()
                .build();
    }
}
