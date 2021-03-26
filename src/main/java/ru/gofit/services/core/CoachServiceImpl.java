package ru.gofit.services.core;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import ru.gofit.services.api.CoachService;


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
