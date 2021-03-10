package ru.gofit.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.stereotype.Repository;
import ru.gofit.entities.Subscription;

/**
 * Репозиторий Пакетов тренировок
 */
@Repository
public interface SubscriptionRepository extends JpaRepository<Subscription, Long>,
        JpaSpecificationExecutor<Subscription> {

}