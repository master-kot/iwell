package ru.gofit.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import ru.gofit.entities.SportType;

/**
 * Репозиторий Видов спорта
 */
@Repository
public interface SportTypeRepository extends JpaRepository<SportType, Short> {

}
