package ru.gofit.services.core;

import lombok.RequiredArgsConstructor;
import org.springframework.security.access.AccessDeniedException;
import org.springframework.security.core.Authentication;
import org.springframework.stereotype.Service;
import ru.gofit.dto.FeedbackDto;
import ru.gofit.dto.FeedbackRequest;
import ru.gofit.entities.Feedback;
import ru.gofit.exceptions.DataNotFoundException;
import ru.gofit.mappers.FeedbackMapper;
import ru.gofit.repositories.FeedbackRepository;
import ru.gofit.services.api.FeedbackService;
import ru.gofit.services.api.UserService;

import java.util.List;

import static ru.gofit.helpers.Messages.ACCESS_DENIED;
import static ru.gofit.helpers.Messages.USER_NOT_FOUND_BY_ID;
import static ru.gofit.helpers.Roles.hasAuthenticationRoleAdmin;

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
