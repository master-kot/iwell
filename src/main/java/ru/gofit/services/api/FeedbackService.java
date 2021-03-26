package ru.gofit.services.api;

import org.springframework.security.core.Authentication;
import ru.gofit.dto.FeedbackDto;
import ru.gofit.dto.FeedbackRequest;

import java.util.List;

/**
 * Сервис Данных обратной связи
 */
public interface FeedbackService {

    /**
     * Найти данные обратной связи по идентификатору запроса
     *
     * @param id идентификатор запроса обратной связи
     * @return занные
     */
    FeedbackDto getDtoById(Long id);

    /**
     * Найти все данные обратной связи по данным авторизации
     *
     * @return список данных
     */
    List<FeedbackDto> getAllDto(Authentication authentication);

    /**
     * Создать новые данные обратной связи
     *
     * @param feedbackRequest запрос, содержащий данные об обратной связи
     * @return данные, сохраненные в репозитории
     */
    FeedbackDto save(FeedbackRequest feedbackRequest);

    /**
     * Удалить данные обратной связи по идентификатору запроса
     *
     * @param id идентификатор запроса
     * @return удалены ли данные
     */
    boolean deleteById(Long id);
}
