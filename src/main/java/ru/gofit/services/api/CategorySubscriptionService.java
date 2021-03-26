package ru.gofit.services.api;

import org.springframework.security.core.Authentication;
import ru.gofit.dto.CategorySubscriptionRqDto;
import ru.gofit.dto.CategorySubscriptionRsDto;

import java.util.List;

public interface CategorySubscriptionService {
    /**
     * Возвращает категорию абонемента по его идентификатору
     *
     * @param id идентификатор категории абонемента
     * @return dto категории абонемента
     */
    CategorySubscriptionRsDto getDtoById(Short id);

    /**
     * Возвращает все категории абонементов
     *
     * @return список dto категорий абонементов
     */
    List<CategorySubscriptionRsDto> getAllDto();

    /**
     * Создать новую категорию абонемента
     *
     * @param categorySubscriptionRqDto запрос, содержащий данные абонемента
     * @param authentication данные авторизации
     * @return новый абонемент, сохраненное в репозитории
     */

    CategorySubscriptionRsDto save(CategorySubscriptionRqDto categorySubscriptionRqDto, Authentication authentication);

    /**
     * Изменить данные абонемента по его id
     *  @param categorySubscriptionRqDto абонемент с измененными данными
     * @param categorySubscriptionId индекс абонемента
     * @param authentication данные авторизации
     * @return
     */
    CategorySubscriptionRsDto update(CategorySubscriptionRqDto categorySubscriptionRqDto, Short categorySubscriptionId, Authentication authentication);

    /**
     * Удалить абонемента по его идентификатору
     *
     * @param id идентификатор абонемента
     * @param authentication данные авторизации
     * @return удалено ли мероприятие
     */
    boolean deleteById(Short id, Authentication authentication);

    /**
     * Проверяет существует ли сущность.
     * @param categorySubscriptionId идентификатор абонемента
     * @return true/false
     */
    boolean exist(Short categorySubscriptionId);
}
