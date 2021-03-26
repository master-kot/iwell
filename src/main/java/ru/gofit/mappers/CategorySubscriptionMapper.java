package ru.gofit.mappers;

import org.mapstruct.Mapper;
import org.mapstruct.ReportingPolicy;
import ru.gofit.dto.CategorySubscriptionRqDto;
import ru.gofit.dto.CategorySubscriptionRsDto;
import ru.gofit.entities.CategorySubscription;

import java.util.List;
import java.util.Optional;


/**
 * Маппер, преобразующий классы CategorySubscription и CategorySubscriptionRsDto друг в друга
 */
@Mapper(componentModel = "spring", unmappedTargetPolicy = ReportingPolicy.IGNORE)
public interface CategorySubscriptionMapper {

    CategorySubscriptionRsDto mapEntityToDto(Optional<CategorySubscription> entity);

    CategorySubscriptionRsDto mapEntityToDto(CategorySubscription entity);

    List<CategorySubscriptionRsDto> mapEntityToDto(List<CategorySubscription> entities);

    CategorySubscription mapDtoToEntity(CategorySubscriptionRqDto dto);

}