package ru.gofit.mappers;

import org.mapstruct.Mapper;
import org.mapstruct.ReportingPolicy;
import ru.gofit.dto.AccentRsDto;
import ru.gofit.entities.Accent;

import java.util.List;


/**
 * Маппер, преобразующий классы Accent и AccentRsDto друг в друга
 */
@Mapper(componentModel = "spring", unmappedTargetPolicy = ReportingPolicy.IGNORE)
public interface AccentMapper  {

    AccentRsDto mapEntityToDto(Accent entity);

    List<AccentRsDto> mapEntityToDto(List<Accent> entities);

    Accent mapDtoToEntity(AccentRsDto dto);
}