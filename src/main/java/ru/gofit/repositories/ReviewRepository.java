package ru.gofit.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import ru.gofit.entities.Review;

import java.util.List;
import java.util.Optional;

/**
 * Репозиторий Отзывов о тренере
 */
@Repository
public interface ReviewRepository extends JpaRepository<Review, Long> {

    /**
     * Находит отзыв по его id и по в id пользователя
     *
     * @param reviewId идентификатор отзыва
     * @param clientId идентификатор клиента
     * @return
     */

    Optional<Review> findByIdAndClientProfileId(Long reviewId, Long clientId);

    /**
     * Находит все отзывы о тренере по его идентификатору
     *
     * @param coachId идентификатор тренера
     * @return все отзывы о тренере
     */

    @Query(value = "SELECT s FROM coach_profiles e JOIN reviews m " +
            "ON e.id = m.coach_profile_id " +
            "WHERE m.coach_profile_id = :coachId ", nativeQuery = true)
    List<Review> findAllByCoachId(Long coachId);

}
