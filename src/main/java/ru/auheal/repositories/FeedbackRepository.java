package ru.auheal.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import ru.auheal.entities.Feedback;

/**
 * Репозиторий Данных обратной связи
 */
@Repository
public interface FeedbackRepository extends JpaRepository<Feedback, Long> {

}
