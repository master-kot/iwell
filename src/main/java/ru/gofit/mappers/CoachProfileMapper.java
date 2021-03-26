package ru.gofit.mappers;

import org.mapstruct.Mapper;
import org.mapstruct.ReportingPolicy;
import ru.gofit.dto.CoachProfileRsDto;
import ru.gofit.entities.CoachProfile;

import java.util.List;


/**
 * Маппер, преобразующий классы CoachProfile и CoachProfileRsDto друг в друга
 */
@Mapper(componentModel = "spring", unmappedTargetPolicy = ReportingPolicy.IGNORE)
public interface CoachProfileMapper {

    CoachProfileRsDto mapEntityToDto(CoachProfile entity);

    List<CoachProfileRsDto> mapEntityToDto(List<CoachProfile> entities);

    CoachProfile mapDtoToEntity(CoachProfileRsDto dto);
}