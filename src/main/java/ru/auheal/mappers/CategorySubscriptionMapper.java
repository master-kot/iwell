package ru.auheal.mappers;

import org.mapstruct.Mapper;
import org.mapstruct.ReportingPolicy;
import ru.auheal.dto.CategorySubscriptionDto;
import ru.auheal.entities.CategorySubscription;

import java.util.List;


/**
 * Маппер, преобразующий классы CategorySubscription и CategorySubscriptionDto друг в друга
 */
@Mapper(componentModel = "spring", unmappedTargetPolicy = ReportingPolicy.IGNORE)
public interface CategorySubscriptionMapper {

    CategorySubscriptionDto mapEntityToDto(CategorySubscription entity);

    List<CategorySubscriptionDto> mapEntityToDto(List<CategorySubscription> entities);

    CategorySubscription mapDtoToEntity(CategorySubscriptionDto dto);
}