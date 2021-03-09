package ru.auheal.services.core;

import lombok.RequiredArgsConstructor;
import org.springframework.security.access.AccessDeniedException;
import org.springframework.security.core.Authentication;
import org.springframework.stereotype.Service;
import ru.auheal.dto.FeedbackDto;
import ru.auheal.dto.FeedbackRequest;
import ru.auheal.entities.Feedback;
import ru.auheal.exceptions.DataNotFoundException;
import ru.auheal.mappers.FeedbackMapper;
import ru.auheal.repositories.FeedbackRepository;
import ru.auheal.services.api.FeedbackService;
import ru.auheal.services.api.UserService;

import java.util.List;

import static ru.auheal.helpers.Messages.ACCESS_DENIED;
import static ru.auheal.helpers.Messages.USER_NOT_FOUND_BY_ID;
import static ru.auheal.helpers.Roles.hasAuthenticationRoleAdmin;

/**
 * Сервис Данных обратной связи
 */
@Service
@RequiredArgsConstructor
public class FeedbackServiceImpl implements FeedbackService {

    // Необходимые сервисы, мапперы и репозитории
    private final UserService userService;
    private final FeedbackRepository feedbackRepository;
    private final FeedbackMapper feedbackMapper;

    @Override
    public FeedbackDto getDtoById(Long id) {
        return feedbackMapper.mapEntityToDto(feedbackRepository.findById(id).orElseThrow(
                () -> new DataNotFoundException(String.format(USER_NOT_FOUND_BY_ID, id))));
    }

    @Override
    public List<FeedbackDto> getAllDto(Authentication authentication) {
        if (authentication != null && hasAuthenticationRoleAdmin(authentication)) {
            return feedbackMapper.mapEntityToDto(feedbackRepository.findAll());
        } else {
            throw new AccessDeniedException(ACCESS_DENIED);
        }
    }

    @Override
    public FeedbackDto save(FeedbackRequest feedbackRequest) {
        Feedback feedback = feedbackMapper.mapDtoToEntity(feedbackRequest);
        return feedbackMapper.mapEntityToDto(feedbackRepository.save(feedback));
    }

    @Override
    public boolean deleteById(Long id) {
        feedbackRepository.deleteById(id);
        return feedbackRepository.existsById(id);
    }
}
