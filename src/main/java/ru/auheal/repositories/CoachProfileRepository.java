package ru.auheal.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import ru.auheal.entities.CoachProfile;

/**
 * Репозиторий Профилей тренера
 */
@Repository
public interface CoachProfileRepository extends JpaRepository<CoachProfile, Long> {

}
