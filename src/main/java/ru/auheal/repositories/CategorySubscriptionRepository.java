package ru.auheal.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import ru.auheal.entities.CategorySubscription;
import ru.auheal.entities.Subscription;


/**
 * Репозиторий Категорий абонементов
 */
@Repository
public interface CategorySubscriptionRepository extends JpaRepository<CategorySubscription, Short> {
    /**
     * Возвращает абонемент по начальному количеству тренировок
     * @param initialAmount начальное число тренировок
     * @return абонемент
     */
    Subscription findByInitialAmount(Short initialAmount);
}

