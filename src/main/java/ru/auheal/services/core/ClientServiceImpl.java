package ru.auheal.services.core;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import ru.auheal.services.api.ClientService;

/**
 * Сервис Клиента
 */
@Service
@RequiredArgsConstructor

public class ClientServiceImpl implements ClientService {
    @Override
    public Long findClientIdByUserId(Long userId) {
        return null;
    }
}
