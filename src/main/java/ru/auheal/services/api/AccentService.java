package ru.auheal.services.api;

import org.springframework.security.core.Authentication;
import ru.auheal.dto.AccentDto;
import ru.auheal.dto.ReviewDto;
import ru.auheal.exceptions.DataNotFoundException;

import java.util.List;


public interface AccentService {
    /**
     * Возращает Акцент тренировки по её имени
     *
     * @param description название Акцента тренировки
     * @exception DataNotFoundException, Акцент тренировки не найден
     * @return AccentDto
     */
    AccentDto readAccentDtoByDescription(String description);


    /**
     * Возращает все Акценты
     *
     * @return List<ReviewDto>
     */
    List<AccentDto> readAllAccentDto();


    /**
     * Сохраняет новый Акцент
     *
     * @param authentication данные авторизации
     * @param accent запрос на создание нового акцента
     * @return dto нового акцента
     */
    AccentDto saveAccent( AccentDto accent,  Authentication authentication);

    /**
     * Обновляет акцент
     *
     * @param accentDto запрос на обновление
     * @param authentication данные авторизации
     * @exception DataNotFoundException, не получилось найти запрашиваемый Акцент
     * @return dto обновленного Акцента
     */
    AccentDto updateAccent(AccentDto accentDto, Authentication authentication);

    /**
     * Удаление рецензии (только автор рецензии)
     * @param accentId идентификатор Акцента
     * @param authentication данные авторизации
     * @exception DataNotFoundException, не получилось найти Акцент
     * @return true, false - удаленна ли сущность
     */
    Boolean deleteById(Short accentId, Authentication authentication);
}
