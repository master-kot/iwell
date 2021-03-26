package ru.gofit.mappers;

import org.mapstruct.Mapper;
import org.mapstruct.ReportingPolicy;
import ru.gofit.dto.SubscriptionDto;
import ru.gofit.dto.SubscriptionRqDto;
import ru.gofit.entities.Subscription;

import java.util.List;
import java.util.Optional;

/**
 * Маппер, преобразующий классы Subscription и SubscriptionDto друг в друга
 */
@Mapper(componentModel = "spring", unmappedTargetPolicy = ReportingPolicy.IGNORE)
public interface SubscriptionMapper {

    SubscriptionDto mapEntityToDto(Subscription entity);

    List<SubscriptionDto> mapEntityToDto(List<Subscription> entities);

    Subscription mapDtoToEntity(SubscriptionRqDto dto);

    SubscriptionDto mapEntityToDto(Optional<Subscription> entity);
}
