package ru.gofit.services.api;

import org.springframework.security.core.Authentication;
import ru.gofit.dto.ReviewRsDto;
import ru.gofit.dto.ReviewRqDto;
import ru.gofit.exceptions.DataBadRequestException;
import ru.gofit.exceptions.DataNotFoundException;

import java.util.List;

/**
 * Сервис Отзывов клиентов о тренерах
 */


public interface ReviewService {

    /**
     * Возращает рецензию по её идентификатору
     *
     * @param reviewId идентификатор рецензии
     * @param coachId идентификатор тренера
     * @exception DataBadRequestException,
     * @exception DataNotFoundException, не найден тренер
     * @return ReviewRsDto
     */
    ReviewRsDto readReviewDtoByIdAndCoachId(Long reviewId, Long coachId);

    /**
     * Возращает рецензии по идентификатору тренера
     *
     * @param coachId идентификатор тренера
     * @return List<ReviewRsDto>
     */
    List<ReviewRsDto> readAllReviewsDtoByCoachId(Long coachId);

    /**
     * Сохраняет новую рецензию
     * @param coachId идентификатор тренера
     * @param request запрос (текст рецензии)
     * @param authentication данные авторизации
     * @exception DataBadRequestException, не найден тренер
     * @return dto новой рецензии
     */
    ReviewRsDto saveReview(Long coachId, ReviewRqDto request, Authentication authentication);

    /**
     * Обновляет рецензию (текст, имя юзера)
     * @param coachId идентификатор тренера
     * @param request запрос (текст рецензии)
     * @param authentication данные авторизации
     * @exception DataNotFoundException, не получилось найти рецензию
     * @return dto обновлённой рецензии
     */
    ReviewRsDto updateReview(Long coachId, ReviewRqDto request, Authentication authentication);

    /**
     * Удаление рецензии (только автор рецензии)
     * @param reviewId идентификатор рецензии
     * @param coachId идентификатор тренера
     * @param authentication данные авторизации
     * @exception DataNotFoundException, не получилось найти рецензию
     * @return true, false - удаленна ли сущность
     */
    Boolean deleteById(Long reviewId, Long coachId, Authentication authentication);
}