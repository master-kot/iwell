package ru.gofit.services.api;

/**
 * Сервис Клиентов
 */

public interface ClientService {

    Long findClientIdByUserId(Long userId);
}
