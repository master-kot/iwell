package ru.gofit.mappers;

import org.mapstruct.Mapper;
import org.mapstruct.ReportingPolicy;
import ru.gofit.dto.CategorySubscriptionDto;
import ru.gofit.dto.CategorySubscriptionRequest;
import ru.gofit.entities.CategorySubscription;

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