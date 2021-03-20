package ru.auheal.mappers;

import org.mapstruct.Mapper;
import org.mapstruct.ReportingPolicy;
import ru.auheal.dto.SubscriptionDto;
import ru.auheal.dto.SubscriptionRequest;
import ru.auheal.entities.Subscription;

import java.util.List;
import java.util.Optional;

/**
 * Маппер, преобразующий классы Subscription и SubscriptionDto друг в друга
 */
@Mapper(componentModel = "spring", unmappedTargetPolicy = ReportingPolicy.IGNORE)
public interface SubscriptionMapper {

    SubscriptionDto mapEntityToDto(Subscription entity);

    List<SubscriptionDto> mapEntityToDto(List<Subscription> entities);

    Subscription mapDtoToEntity(SubscriptionRequest dto);

    SubscriptionDto mapEntityToDto(Optional<Subscription> entity);
}
