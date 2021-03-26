package ru.gofit.mappers;

import org.mapstruct.Mapper;
import org.mapstruct.ReportingPolicy;
import ru.gofit.dto.FeedbackRsDto;
import ru.gofit.dto.FeedbackRqDto;
import ru.gofit.entities.Feedback;

import java.util.List;

/**
 * Маппер, преобразующий классы Feedback и FeedbackRsDto друг в друга
 */
@Mapper(componentModel = "spring", unmappedTargetPolicy = ReportingPolicy.IGNORE)
public interface FeedbackMapper {

    FeedbackRsDto mapEntityToDto(Feedback entity);

    List<FeedbackRsDto> mapEntityToDto(List<Feedback> entities);

    Feedback mapDtoToEntity(FeedbackRqDto dto);
}
