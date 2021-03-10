package ru.gofit.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.stereotype.Repository;
import ru.gofit.entities.OutcomeCoachTransaction;
import ru.gofit.entities.Training;

/**
 * Репозиторий Исходящих транзакций тренеров
 */
@Repository
public interface OutcomeCoachTransactionRepository extends JpaRepository<OutcomeCoachTransaction, Long>,
        JpaSpecificationExecutor<Training> {

}
