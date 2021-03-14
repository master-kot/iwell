package ru.auheal.dto;

import org.mapstruct.Mapper;
import org.mapstruct.ReportingPolicy;
import ru.auheal.entities.Accent;
import ru.auheal.entities.Review;

import java.util.List;


/**
 * Маппер, преобразующий классы Accent и AccentDto друг в друга
 */
@Mapper(componentModel = "spring", unmappedTargetPolicy = ReportingPolicy.IGNORE)
public interface AccentMapper  {

    AccentDto mapEntityToDto(Accent entity);

    List<AccentDto> mapEntityToDto(List<Accent> entities);

    Accent mapDtoToEntity(AccentDto dto);
}