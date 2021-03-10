package ru.gofit.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.stereotype.Repository;
import ru.gofit.entities.Training;

/**
 * Репозиторий Тренировок
 */
@Repository
public interface TrainingRepository  extends JpaRepository<Training, Long>,
        JpaSpecificationExecutor<Training> {

}