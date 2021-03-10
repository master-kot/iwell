package ru.gofit.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.stereotype.Repository;
import ru.gofit.entities.IncomeCoachTransaction;

/**
 * Репозиторий Входящих транзакций тренеров
 */
@Repository
public interface IncomeCoachTransactionRepository extends JpaRepository<IncomeCoachTransaction, Long>,
        JpaSpecificationExecutor<IncomeCoachTransaction> {

}
