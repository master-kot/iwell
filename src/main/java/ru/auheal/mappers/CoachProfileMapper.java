package ru.auheal.mappers;

import org.mapstruct.Mapper;
import org.mapstruct.ReportingPolicy;
import ru.auheal.dto.CoachProfileDto;
import ru.auheal.entities.CoachProfile;

import java.util.List;


/**
 * Маппер, преобразующий классы CoachProfile и CoachProfileDto друг в друга
 */
@Mapper(componentModel = "spring", unmappedTargetPolicy = ReportingPolicy.IGNORE)
public interface CoachProfileMapper {

    CoachProfileDto mapEntityToDto(CoachProfile entity);

    List<CoachProfileDto> mapEntityToDto(List<CoachProfile> entities);

    CoachProfile mapDtoToEntity(CoachProfileDto dto);
}