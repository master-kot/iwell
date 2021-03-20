package ru.auheal.mappers;

import org.mapstruct.Mapper;
import org.mapstruct.ReportingPolicy;
import ru.auheal.dto.CategorySubscriptionDto;
import ru.auheal.dto.CategorySubscriptionRequest;
import ru.auheal.dto.SubscriptionDto;
import ru.auheal.entities.CategorySubscription;

import java.util.List;
import java.util.Optional;


/**
 * Маппер, преобразующий классы CategorySubscription и CategorySubscriptionDto друг в друга
 */
@Mapper(componentModel = "spring", unmappedTargetPolicy = ReportingPolicy.IGNORE)
public interface CategorySubscriptionMapper {

    CategorySubscriptionDto mapEntityToDto(Optional<CategorySubscription> entity);

    CategorySubscriptionDto mapEntityToDto(CategorySubscription entity);

    List<CategorySubscriptionDto> mapEntityToDto(List<CategorySubscription> entities);

    CategorySubscription mapDtoToEntity(CategorySubscriptionRequest dto);

}