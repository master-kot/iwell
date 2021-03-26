package ru.gofit.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.stereotype.Repository;
import ru.gofit.entities.ClientTransaction;

/**
 * Репозиторий Транзакций клиентов
 */
@Repository
public interface ClientTransactionRepository extends JpaRepository<ClientTransaction, Long>,
        JpaSpecificationExecutor<ClientTransaction> {

}
