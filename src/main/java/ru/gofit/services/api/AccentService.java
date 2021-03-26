package ru.gofit.services.api;

import org.springframework.security.core.Authentication;
import ru.gofit.dto.AccentRsDto;
import ru.gofit.exceptions.DataNotFoundException;

import java.util.List;


public interface AccentService {
    /**
     * Возращает Акцент тренировки по её имени
     *
     * @param description название Акцента тренировки
     * @exception DataNotFoundException, Акцент тренировки не найден
     * @return AccentRsDto
     */
    AccentRsDto readAccentDtoByDescription(String description);


    /**
     * Возращает все Акценты
     *
     * @return List<ReviewRsDto>
     */
    List<AccentRsDto> readAllAccentesDto();


    /**
     * Сохраняет новый Акцент (только Администратор)
     *
     * @param authentication данные авторизации
     * @param accentRsDto запрос на создание нового акцента
     * @return dto нового акцента
     */
    AccentRsDto saveAccent(AccentRsDto accentRsDto, Authentication authentication);

    /**
     * Обновляет акцент (только Администратор)
     *
     * @param accentRsDto запрос на обновление
     * @param authentication данные авторизации
     * @exception DataNotFoundException, не получилось найти запрашиваемый Акцент
     * @return dto обновленного Акцента
     */
    AccentRsDto updateAccent(AccentRsDto accentRsDto, Authentication authentication);

    /**
     * Удаление рецензии (только Администратор)
     * @param accentId идентификатор Акцента
     * @param authentication данные авторизации
     * @exception DataNotFoundException, не получилось найти Акцент
     * @return true, false - удаленна ли сущность
     */
    Boolean deleteById(Short accentId, Authentication authentication);
}
