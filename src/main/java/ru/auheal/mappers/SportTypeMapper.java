package ru.auheal.mappers;

import org.mapstruct.Mapper;
import org.mapstruct.ReportingPolicy;
import ru.auheal.dto.SportTypeDto;
import ru.auheal.entities.SportType;

import java.util.List;


/**
 * Маппер, преобразующий классы SportType и SportTypeDto друг в друга
 */
@Mapper(componentModel = "spring", unmappedTargetPolicy = ReportingPolicy.IGNORE)
public interface SportTypeMapper  {

    SportTypeDto mapEntityToDto(SportType entity);

    List<SportTypeDto> mapEntityToDto(List<SportType> entities);

    SportType mapDtoToEntity(SportTypeDto dto);
}