package ru.auheal.mappers;

import org.mapstruct.Mapper;
import org.mapstruct.ReportingPolicy;
import ru.auheal.dto.SubscriptionDto;
import ru.auheal.entities.Subscription;
import ru.auheal.entities.Training;

import java.util.List;

/**
 * Маппер, преобразующий классы Subscription и SubscriptionDto друг в друга
 */
@Mapper(componentModel = "spring", unmappedTargetPolicy = ReportingPolicy.IGNORE)
public interface SubscriptionMapper {

    SubscriptionDto mapEntityToDto(Subscription entity);

    List<SubscriptionDto> mapEntityToDto(List<Subscription> entities);

    Subscription mapDtoToEntity(SubscriptionDto dto);
}
