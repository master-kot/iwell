package ru.gofit.services.api;

import org.springframework.security.core.Authentication;
import ru.gofit.dto.SubscriptionDto;
import ru.gofit.dto.SubscriptionRequest;

import java.util.List;


/**
 * Сервис Абонементов
 */
public interface SubscriptionService {

    /**
     * Возвращает абонемент по его идентификатору
     *
     * @param id идентификатор абонемента
     * @return dto абонемента
     */
    SubscriptionDto getDtoById(Long id);

    /**
     * Возвращает все абонементы
     *
     * @return список dto абонементов
     */
    List<SubscriptionDto> getAllDto();

    /**
     * Создать новый абонемент
     *
     * @param subscriptionRequest запрос, содержащий данные абонемента
     * @param authentication данные авторизации
     * @return новый абонемент, сохраненное в репозитории
     */
    SubscriptionDto save(SubscriptionRequest subscriptionRequest, Authentication authentication);

    /**
     * Изменить данные абонемента по его id
     *
     * @param subscriptionRequest абонемент с измененными данными
     * @param subscriptionId индекс абонемента
     * @param authentication данные авторизации
     */
    SubscriptionDto update(SubscriptionRequest subscriptionRequest, Long subscriptionId, Authentication authentication);

    /**
     * Удалить абонемента по его идентификатору
     * @param id идентификатор абонемента
     * @param authentication данные авторизации
     * @return удален ли абонемент
     */
    boolean deleteById(Long id, Authentication authentication);

    /**
     * Проверяет существует ли сущность.
     * @param eventId идентификатор абонемента
     * @return true/false
     */
    boolean exist(Long eventId);


}