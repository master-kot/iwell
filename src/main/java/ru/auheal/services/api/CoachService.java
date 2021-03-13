package ru.auheal.services.api;

/**
 * Сервис Тренеров
 */

public interface CoachService {
    /**
     * Возвращает булевское значение по идентификатору тренера
     *
     * @param CoachId идентификатор тренера
     * @return true если тренер существует false если нет
     */

    Boolean existById(Long CoachId);
}
