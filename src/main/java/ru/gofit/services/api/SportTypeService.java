package ru.gofit.services.api;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import ru.gofit.dto.SportTypeRqDto;
import ru.gofit.dto.SportTypeRsDto;

public interface SportTypeService {

    /**
     * Найти все виды спорта
     *
     * @param pageable количество страниц и количество видов спорта на странице
     * @return список видов спорта
     */
    Page<SportTypeRsDto> getAll(Pageable pageable);

    /**
     * Найти вид спорта по его идентификатору
     *
     * @param id идентификатор вида спорта
     * @return вид спорта
     */
    SportTypeRsDto getById(Short id);

    /**
     * Создать новый вид спорта
     *
     * @param sportTypeRqDto запрос с данными вида спорта
     * @return новый вид спорта, сохраненный в репозитории
     */
    SportTypeRsDto save(SportTypeRqDto sportTypeRqDto);

    /**
     * Изменить описание вида спорта
     *
     * @param id             вида спорта
     * @param sportTypeRqDto изиененное описание вида спорта
     * @return измененный вид спорта, сохраненный в репозитории
     */
    SportTypeRsDto update(Short id, SportTypeRqDto sportTypeRqDto);

    /**
     * Удалить вид спорта по его идентификатору
     *
     * @param id идентификатор вида спорта
     */
    void deleteById(Short id);
}
