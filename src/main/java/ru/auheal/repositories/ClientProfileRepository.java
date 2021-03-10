package ru.auheal.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import ru.auheal.entities.ClientProfile;

/**
 * Репозиторий Профилей клиентов
 */
@Repository
public interface ClientProfileRepository extends JpaRepository<ClientProfile, Long> {

}
