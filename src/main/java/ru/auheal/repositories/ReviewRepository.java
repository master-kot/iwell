package ru.auheal.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import ru.auheal.entities.Review;

/**
 * Репозиторий Отзывов о тренере
 */
@Repository
public interface ReviewRepository extends JpaRepository<Review, Integer> {

}
