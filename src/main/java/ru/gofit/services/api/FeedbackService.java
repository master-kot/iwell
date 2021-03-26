package ru.gofit.services.api;

import org.springframework.security.core.Authentication;
import ru.gofit.dto.FeedbackRsDto;
import ru.gofit.dto.FeedbackRqDto;

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
    FeedbackRsDto getDtoById(Long id);

    /**
     * Найти все данные обратной связи по данным авторизации
     *
     * @return список данных
     */
    List<FeedbackRsDto> getAllDto(Authentication authentication);

    /**
     * Создать новые данные обратной связи
     *
     * @param feedbackRqDto запрос, содержащий данные об обратной связи
     * @return данные, сохраненные в репозитории
     */
    FeedbackRsDto save(FeedbackRqDto feedbackRqDto);

    /**
     * Удалить данные обратной связи по идентификатору запроса
     *
     * @param id идентификатор запроса
     * @return удалены ли данные
     */
    boolean deleteById(Long id);
}
