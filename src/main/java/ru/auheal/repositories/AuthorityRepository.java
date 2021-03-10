package ru.auheal.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import ru.auheal.entities.Authority;

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
