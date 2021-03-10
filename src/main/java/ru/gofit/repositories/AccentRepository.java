package ru.gofit.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import ru.gofit.entities.Accent;

/**
 * Репозиторий Акцентов тренировок
 */
@Repository
public interface AccentRepository extends JpaRepository<Accent, Short>{

}
