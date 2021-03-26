package ru.gofit.services.api;

import org.springframework.security.core.Authentication;
import ru.gofit.dto.SportTypeDto;
import ru.gofit.exceptions.DataNotFoundException;

import java.util.List;


public interface SportTypeService {
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
