package ru.gofit.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import ru.gofit.entities.ClientProfile;

import java.util.Optional;

/**
 * Репозиторий Профилей клиентов
 */
@Repository
public interface ClientProfileRepository extends JpaRepository<ClientProfile, Long> {

    Optional<ClientProfile> getByUserId(Long user_id);
}
