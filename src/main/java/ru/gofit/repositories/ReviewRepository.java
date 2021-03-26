package ru.gofit.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import ru.gofit.entities.Review;

import java.util.List;
import java.util.Optional;

/**
 * Репозиторий Отзывов о тренере
 */
@Repository
public interface ReviewRepository extends JpaRepository<Review, Long> {

    List<Review> findAllByCoachProfileId(Long coachId);

    Optional<Review> findByIdAndClientProfileId(Long id, Long clientProfileId);
}
