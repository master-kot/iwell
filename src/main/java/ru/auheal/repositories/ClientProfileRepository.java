package ru.auheal.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import ru.auheal.entities.ClientProfile;

/**
 * Репозиторий профилей клиентов
 */

public interface ClientProfileRepository extends JpaRepository<ClientProfile, Long> {
    /*
     * СОГЛАШЕНИЕ О НАИМЕНОВАНИИ МЕТОДОВ РЕПОЗИТОРИЕВ
     * Optional<Object> findById(Long id) найти объект по параметру
     * List<Object> findAll() найти все объекты
     * List<Object> findAllByEnabled(boolean enabled) найти все объекты по параметру
     * void delete(Object object) удалить конкретный объект
     * void deleteById(Long id) удалить объект по параметру
     * void deleteAll(List<Object> objects) удалить список объектов
     * Object save(Object object) сохранить объект
     * List<Object> saveAll(List<Object> objects) сохранить список объектов
     */
}