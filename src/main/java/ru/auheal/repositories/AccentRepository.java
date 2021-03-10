package ru.auheal.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import ru.auheal.entities.Accent;

/**
 * Репозиторий Акцентов тренировок
 */
@Repository
public interface AccentRepository extends JpaRepository<Accent, Short>{

}
