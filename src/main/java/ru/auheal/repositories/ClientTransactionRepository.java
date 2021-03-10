package ru.auheal.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.stereotype.Repository;
import ru.auheal.entities.ClientTransaction;

/**
 * Репозиторий Транзакций клиентов
 */
@Repository
public interface ClientTransactionRepository extends JpaRepository<ClientTransaction, Long>,
        JpaSpecificationExecutor<ClientTransaction> {

}
