package ru.gofit.services.api;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.security.core.Authentication;
import ru.gofit.dto.SportTypeDto;
import ru.gofit.dto.SportTypeRqDto;
import ru.gofit.dto.SportTypeRsDto;
import ru.gofit.exceptions.DataNotFoundException;

import java.util.List;

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

    /**
     * Возращает Вид спорта тренировки по её имени
     *
     * @param description название Вида спорта тренировки
     * @exception DataNotFoundException, Вида спорта тренировки не найден
     * @return AccentDto
     */
    SportTypeDto readSportTypeDtoByDescription(String description);


    /**
     * Возращает все Акценты
     *
     * @return List<ReviewDto>
     */
    List<SportTypeDto> readAllSportTypesDto();


    /**
     * Сохраняет новый Акцент
     *
     * @param authentication данные авторизации
     * @param sportTypeDto запрос на создание нового Вида спорта
     * @return dto нового Вида спорта
     */
    SportTypeDto saveAccent( SportTypeDto sportTypeDto,  Authentication authentication);

    /**
     * Обновляет акцент
     *
     * @param sportTypeDto запрос на обновление
     * @param authentication данные авторизации
     * @exception DataNotFoundException, не получилось найти запрашиваемый Вид спорта
     * @return dto обновленного Вида спорта
     */
    SportTypeDto updateAccent(SportTypeDto sportTypeDto, Authentication authentication);

    /**
     * Удаление Вида спорта (только Администратор рецензии)
     * @param sportTypeId идентификатор Вида спорта
     * @param authentication данные авторизации
     * @exception DataNotFoundException, не получилось найти Вид спорта
     * @return true, false - удаленна ли сущность
     */
    Boolean deleteById(Short sportTypeId, Authentication authentication);
}
