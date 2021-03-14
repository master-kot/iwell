package ru.auheal.services.core;

import lombok.RequiredArgsConstructor;
import org.springframework.security.access.AccessDeniedException;
import org.springframework.security.core.Authentication;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import ru.auheal.dto.ReviewDto;
import ru.auheal.dto.ReviewRequest;
import ru.auheal.entities.Review;
import ru.auheal.exceptions.DataBadRequestException;
import ru.auheal.exceptions.DataNotFoundException;
import ru.auheal.exceptions.JwtAuthenticationException;
import ru.auheal.helpers.Roles;
import ru.auheal.mappers.ReviewMapper;
import ru.auheal.repositories.ReviewRepository;
import ru.auheal.services.api.ClientService;
import ru.auheal.services.api.CoachService;
import ru.auheal.services.api.ReviewService;
import ru.auheal.services.api.UserService;

import java.util.List;

import static ru.auheal.helpers.Messages.DATA_NOT_FOUND;
import static ru.auheal.helpers.Messages.JWT_TOKEN_NOT_VALID;


@Service
@RequiredArgsConstructor
public class ReviewServiceImpl implements ReviewService {

    private final ReviewRepository repository;
    private final ReviewMapper mapper;
    private final UserService userService;
    private final CoachService coachService;
    private final ClientService clientService;


    @Override
    public ReviewDto readReviewDtoByIdAndCoachId(Long reviewId, Long coachId) {
        Review review = findById(reviewId);
        if (!review.getCoachProfile().getId().equals(coachId)) {
            throw new DataBadRequestException("Тренер указан некорректно указана не корректно");
        }
        return mapper.mapEntityToDto(review);
    }

    @Override
    public List<ReviewDto> readAllReviewsDtoByCoachId(Long coachId) {
        return mapper.mapEntityToDto(repository.findAllByCoachId(coachId));
    }

    @Transactional
    @Override
    public ReviewDto saveReview(Long coachId, ReviewRequest request, Authentication authentication) {
        if (coachService.existById(coachId) && Roles.hasAuthenticationRoleUser(authentication)) {
            var review = mapper.mapDtoToEntity(request);
            return mapper.mapEntityToDto(repository.save(review));
        }
        throw new DataBadRequestException(String.format(DATA_NOT_FOUND, coachId));
    }

    @Transactional
    @Override
    public ReviewDto updateReview(Long reviewId,  ReviewRequest request, Authentication authentication) {
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