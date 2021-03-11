package ru.auheal.services.api;

import org.springframework.security.core.Authentication;
import ru.auheal.dto.ReviewDto;
import ru.auheal.dto.ReviewRequest;

import java.util.List;

/**
 * Сервис Отзывов клиентов о тренерах
 */
public interface ReviewService {

    /**
     * Найти отзыв по идентификатору запроса
     *
     * @param id идентификатор запроса на получение отзыва
     * @return предствление Dto отзыва
     */
    ReviewDto getDtoById(Long id);

    /**
     * Найти все отзывы
     *
     * @return список данных
     */
    List<ReviewDto> getAllDto();

    /**
     * Создать новые данные обратной связи  с использованием данных аунтификации
     *
     * @param reviewRequest запрос, содержащий данные об отзыве
     * @param auntification данные аунтификации пользователя
     * @return данные, сохраненные в репозитории
     */
    ReviewDto save(ReviewRequest reviewRequest, Authentication auntification);

    /**
     * Удалить отзыв по идентификатору запроса
     *
     * @param id идентификатор запроса
     * @return удалены ли данные
     */
    boolean deleteById(Long id);
}