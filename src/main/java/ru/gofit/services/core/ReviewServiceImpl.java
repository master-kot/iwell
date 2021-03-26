package ru.gofit.services.core;

import lombok.RequiredArgsConstructor;
import org.springframework.security.access.AccessDeniedException;
import org.springframework.security.core.Authentication;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import ru.gofit.dto.ReviewRsDto;
import ru.gofit.dto.ReviewRqDto;
import ru.gofit.entities.Review;
import ru.gofit.exceptions.DataBadRequestException;
import ru.gofit.exceptions.DataNotFoundException;
import ru.gofit.exceptions.JwtAuthenticationException;
import ru.gofit.helpers.Roles;
import ru.gofit.mappers.ReviewMapper;
import ru.gofit.repositories.ReviewRepository;
import ru.gofit.services.api.ClientService;
import ru.gofit.services.api.CoachService;
import ru.gofit.services.api.ReviewService;
import ru.gofit.services.api.UserService;

import java.util.List;

import static ru.gofit.helpers.Messages.DATA_NOT_FOUND;
import static ru.gofit.helpers.Messages.JWT_TOKEN_NOT_VALID;


@Service
@RequiredArgsConstructor
public class ReviewServiceImpl implements ReviewService {

    private final ReviewRepository repository;
    private final ReviewMapper mapper;
    private final UserService userService;
    private final CoachService coachService;
    private final ClientService clientService;


    @Override
    public ReviewRsDto readReviewDtoByIdAndCoachId(Long reviewId, Long coachId) {
        Review review = findById(reviewId);
        if (!review.getCoachProfile().getId().equals(coachId)) {
            throw new DataBadRequestException("Тренер указан некорректно указана не корректно");
        }
        return mapper.mapEntityToDto(review);
    }

    @Override
    public List<ReviewRsDto> readAllReviewsDtoByCoachId(Long coachId) {
        return mapper.mapEntityToDto(repository.findAllByCoachProfileId(coachId));
    }

    @Transactional
    @Override
    public ReviewRsDto saveReview(Long coachId, ReviewRqDto request, Authentication authentication) {
        if (coachService.existById(coachId) && Roles.hasAuthenticationRoleUser(authentication)) {
            var review = mapper.mapDtoToEntity(request);
            return mapper.mapEntityToDto(repository.save(review));
        }
        throw new DataBadRequestException(String.format(DATA_NOT_FOUND, coachId));
    }

    @Transactional
    @Override
    public ReviewRsDto updateReview(Long reviewId, ReviewRqDto request, Authentication authentication) {
        if (repository.existsById(reviewId)&&Roles.hasAuthenticationRoleUser(authentication)) {
            if (isAuthorReview(reviewId, authentication)) {
                var review = mapper.mapDtoToEntity(request);
                repository.save(review);
                return mapper.mapEntityToDto(review);
            }else{
                throw new JwtAuthenticationException(JWT_TOKEN_NOT_VALID);
            }
        }
        throw new DataNotFoundException("Отзыв не найлен");
    }

    @Override
    public Boolean deleteById(Long reviewId, Long coachId, Authentication authentication) {
        if (coachService.existById(coachId) && repository.existsById(reviewId)) {
            if (isAuthorReview(reviewId, authentication) || Roles.hasAuthenticationRoleAdmin(authentication)) {
                var review = repository.findById(reviewId);
                repository.deleteById(reviewId);
                return repository.existsById(reviewId);
            }
        }
        throw new DataNotFoundException("Отзыв не найден");
    }

    private Review findById(Long reviewId) {
        return repository.findById(reviewId).orElseThrow(
                () -> new DataNotFoundException(String.format(DATA_NOT_FOUND, reviewId)));
    }

    private boolean isAuthorReview(Long reviewId, Authentication authentication) {
        if (repository.findByIdAndClientProfileId(reviewId,
                clientService.findClientIdByUserId(userService.getIdByAuthentication(authentication))).isPresent()) {
            return true;
        } else throw new AccessDeniedException("Пользователь не является автором отзыва");
    }
}