package ru.auheal.services.core;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import ru.auheal.services.api.CoachService;


/**
 * Сервис Тренера
 */
@Service
@RequiredArgsConstructor
public class CoachServiceImpl implements CoachService {
    @Override
    public Boolean existById(Long CoachId) {
        return null;
    }
}
