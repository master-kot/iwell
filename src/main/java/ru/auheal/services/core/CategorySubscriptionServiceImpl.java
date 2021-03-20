package ru.auheal.services.core;

import lombok.RequiredArgsConstructor;
import org.springframework.security.access.AccessDeniedException;
import org.springframework.security.core.Authentication;
import org.springframework.stereotype.Service;
import ru.auheal.dto.CategorySubscriptionDto;
import ru.auheal.dto.CategorySubscriptionRequest;
import ru.auheal.entities.CategorySubscription;
import ru.auheal.exceptions.DataBadRequestException;
import ru.auheal.helpers.Roles;
import ru.auheal.mappers.CategorySubscriptionMapper;
import ru.auheal.repositories.CategorySubscriptionRepository;
import ru.auheal.services.api.CategorySubscriptionService;

import java.util.List;
import java.util.Optional;

import static ru.auheal.helpers.Messages.ACCESS_DENIED;
import static ru.auheal.helpers.Messages.DATA_WAS_NOT_FOUND_BY_ID;

@Service
@RequiredArgsConstructor
public class CategorySubscriptionServiceImpl implements CategorySubscriptionService {

    private final CategorySubscriptionRepository categorySubscriptionRepository;
    private final CategorySubscriptionMapper categorySubscriptionMapper;

    @Override
    public CategorySubscriptionDto getDtoById(Short id) {
        if (categorySubscriptionRepository.findById(id).isPresent()) {
            return categorySubscriptionMapper.mapEntityToDto(categorySubscriptionRepository.findById(id));
        }else{
            throw new DataBadRequestException(String.format(DATA_WAS_NOT_FOUND_BY_ID, id));
        }
    }

    @Override
    public List<CategorySubscriptionDto> getAllDto() {
        return categorySubscriptionMapper.mapEntityToDto(categorySubscriptionRepository.findAll());
    }

    @Override
    public CategorySubscriptionDto save(CategorySubscriptionRequest categorySubscriptionRequest,
                                        Authentication authentication) {
        if (Roles.hasAuthenticationRoleAdmin(authentication)) {
            return categorySubscriptionMapper.mapEntityToDto(categorySubscriptionRepository
                    .save(categorySubscriptionMapper.mapDtoToEntity(categorySubscriptionRequest)));
        } else {
            throw new AccessDeniedException(ACCESS_DENIED);
        }
    }

    //TODO придумать, как определить метод equals для сущностей и Dto
    @Override
    public CategorySubscriptionDto update(CategorySubscriptionRequest categorySubscriptionRequest, Short categorySubscriptionId, Authentication authentication) {
        if (Roles.hasAuthenticationRoleAdmin(authentication)) {
            Optional<CategorySubscription> categorySubscription = categorySubscriptionRepository.findById(categorySubscriptionId);
            if(categorySubscription.get().getInitialAmount().equals(categorySubscriptionRequest.getInitialAmount())) {
                return categorySubscriptionMapper.mapEntityToDto(categorySubscriptionRepository
                        .save(categorySubscriptionMapper.mapDtoToEntity(categorySubscriptionRequest)));
            }else{
                throw new DataBadRequestException(String.format(DATA_WAS_NOT_FOUND_BY_ID, categorySubscription));
            }
        } else {
            throw new AccessDeniedException(ACCESS_DENIED);
        }
    }

    @Override
    public boolean deleteById(Short id, Authentication authentication) {
        if (Roles.hasAuthenticationRoleAdmin(authentication)) {
            categorySubscriptionRepository.deleteById(id);
            return ! categorySubscriptionRepository.existsById(id);
        } else {
            throw new AccessDeniedException(ACCESS_DENIED);
        }
    }

    @Override
    public boolean exist(Short categorySubscriptionId) {
        return categorySubscriptionRepository.existsById(categorySubscriptionId);
    }
}
