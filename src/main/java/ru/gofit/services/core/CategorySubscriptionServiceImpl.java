package ru.gofit.services.core;

import lombok.RequiredArgsConstructor;
import org.springframework.security.access.AccessDeniedException;
import org.springframework.security.core.Authentication;
import org.springframework.stereotype.Service;
import ru.gofit.dto.CategorySubscriptionRsDto;
import ru.gofit.dto.CategorySubscriptionRqDto;
import ru.gofit.entities.CategorySubscription;
import ru.gofit.exceptions.DataBadRequestException;
import ru.gofit.helpers.Roles;
import ru.gofit.mappers.CategorySubscriptionMapper;
import ru.gofit.repositories.CategorySubscriptionRepository;
import ru.gofit.services.api.CategorySubscriptionService;

import java.util.List;
import java.util.Optional;

import static ru.gofit.helpers.Messages.ACCESS_DENIED;
import static ru.gofit.helpers.Messages.DATA_WAS_NOT_FOUND_BY_ID;

@Service
@RequiredArgsConstructor
public class CategorySubscriptionServiceImpl implements CategorySubscriptionService {

    private final CategorySubscriptionRepository categorySubscriptionRepository;
    private final CategorySubscriptionMapper categorySubscriptionMapper;

    @Override
    public CategorySubscriptionRsDto getDtoById(Short id) {
        if (categorySubscriptionRepository.findById(id).isPresent()) {
            return categorySubscriptionMapper.mapEntityToDto(categorySubscriptionRepository.findById(id));
        }else{
            throw new DataBadRequestException(String.format(DATA_WAS_NOT_FOUND_BY_ID, id));
        }
    }

    @Override
    public List<CategorySubscriptionRsDto> getAllDto() {
        return categorySubscriptionMapper.mapEntityToDto(categorySubscriptionRepository.findAll());
    }

    @Override
    public CategorySubscriptionRsDto save(CategorySubscriptionRqDto categorySubscriptionRqDto,
                                          Authentication authentication) {
        if (Roles.hasAuthenticationRoleAdmin(authentication)) {
            return categorySubscriptionMapper.mapEntityToDto(categorySubscriptionRepository
                    .save(categorySubscriptionMapper.mapDtoToEntity(categorySubscriptionRqDto)));
        } else {
            throw new AccessDeniedException(ACCESS_DENIED);
        }
    }

    //TODO придумать, как определить метод equals для сущностей и Dto
    @Override
    public CategorySubscriptionRsDto update(CategorySubscriptionRqDto categorySubscriptionRqDto, Short categorySubscriptionId, Authentication authentication) {
        if (Roles.hasAuthenticationRoleAdmin(authentication)) {
            Optional<CategorySubscription> categorySubscription = categorySubscriptionRepository.findById(categorySubscriptionId);
            if(categorySubscription.get().getInitialAmount().equals(categorySubscriptionRqDto.getInitialAmount())) {
                return categorySubscriptionMapper.mapEntityToDto(categorySubscriptionRepository
                        .save(categorySubscriptionMapper.mapDtoToEntity(categorySubscriptionRqDto)));
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
