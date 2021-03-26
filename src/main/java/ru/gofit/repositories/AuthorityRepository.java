package ru.gofit.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import ru.gofit.entities.Authority;

/**
 * Репозиторий Ролей пользователей
 */
@Repository
public interface AuthorityRepository extends JpaRepository<Authority, Short> {

    /**
     * Найти роль пользователя по ее имени
     */
    Authority findByAuthority(String authority);
}
