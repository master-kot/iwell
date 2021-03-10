package ru.auheal.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.stereotype.Repository;
import ru.auheal.entities.Training;

/**
 * Репозиторий Тренировок
 */
@Repository
public interface TrainingRepository  extends JpaRepository<Training, Long>,
        JpaSpecificationExecutor<Training> {

}