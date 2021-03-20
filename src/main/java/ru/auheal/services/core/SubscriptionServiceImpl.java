package ru.auheal.services.core;

import lombok.RequiredArgsConstructor;
import org.springframework.security.access.AccessDeniedException;
import org.springframework.security.core.Authentication;
import org.springframework.stereotype.Service;
import ru.auheal.dto.SubscriptionDto;
import ru.auheal.dto.SubscriptionRequest;
import ru.auheal.entities.Subscription;
import ru.auheal.exceptions.DataBadRequestException;
import ru.auheal.helpers.Roles;
import ru.auheal.mappers.SubscriptionMapper;
import ru.auheal.repositories.SubscriptionRepository;
import ru.auheal.services.api.SubscriptionService;

import java.util.List;
import java.util.Optional;

import static ru.auheal.helpers.Messages.ACCESS_DENIED;
import static ru.auheal.helpers.Messages.DATA_WAS_NOT_FOUND_BY_ID;

@Service
@RequiredArgsConstructor
public class SubscriptionServiceImpl implements SubscriptionService {

    private final SubscriptionRepository subscriptionRepository;
    private final SubscriptionMapper subscriptionMapper;

    @Override
    public SubscriptionDto getDtoById(Long id) {
        if (subscriptionRepository.findById(id).isPresent()) {
            return subscriptionMapper.mapEntityToDto(subscriptionRepository.findById(id));
        }else{
            throw new DataBadRequestException(String.format(DATA_WAS_NOT_FOUND_BY_ID, id));
        }
    }

    @Override
    public List<SubscriptionDto> getAllDto() {
            return subscriptionMapper.mapEntityToDto(subscriptionRepository.findAll());
    }

    @Override
    public SubscriptionDto save(SubscriptionRequest subscriptionRequest, Authentication authentication) {
        if (Roles.hasAuthenticationRoleAdmin(authentication)) {
            return subscriptionMapper.mapEntityToDto(subscriptionRepository
                    .save(subscriptionMapper.mapDtoToEntity(subscriptionRequest)));
        } else {
            throw new AccessDeniedException(ACCESS_DENIED);
        }
    }

    //TODO придумать, как определить метод equals для сущностей и Dto
    @Override
    public SubscriptionDto update(SubscriptionRequest subscriptionRequest, Long subscriptionId, Authentication authentication) {
        if (Roles.hasAuthenticationRoleAdmin(authentication)) {
            Optional<Subscription> subscription = subscriptionRepository.findById(subscriptionId);
            if(subscriptionRequest.getClientProfile().equals(subscription.get().getClientProfile())) {
                return subscriptionMapper.mapEntityToDto(subscriptionRepository
                        .save(subscriptionMapper.mapDtoToEntity(subscriptionRequest)));
            }else{
                throw new DataBadRequestException(String.format(DATA_WAS_NOT_FOUND_BY_ID, subscriptionId));
            }
        } else {
            throw new AccessDeniedException(ACCESS_DENIED);
        }
    }

    @Override
    public boolean deleteById(Long id, Authentication authentication) {
        if (Roles.hasAuthenticationRoleAdmin(authentication)) {
            subscriptionRepository.deleteById(id);
            return ! subscriptionRepository.existsById(id);
        } else {
            throw new AccessDeniedException(ACCESS_DENIED);
        }
    }

    @Override
    public boolean exist(Long id) {
        return subscriptionRepository.existsById(id);
    }

}
