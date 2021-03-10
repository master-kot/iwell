package ru.gofit.mappers;

import org.mapstruct.Mapper;
import org.mapstruct.ReportingPolicy;
import ru.gofit.dto.FeedbackDto;
import ru.gofit.dto.FeedbackRequest;
import ru.gofit.entities.Feedback;

import java.util.List;

/**
 * Маппер, преобразующий классы Feedback и FeedbackDto друг в друга
 */
@Mapper(componentModel = "spring", unmappedTargetPolicy = ReportingPolicy.IGNORE)
public interface FeedbackMapper {

    FeedbackDto mapEntityToDto(Feedback entity);

    List<FeedbackDto> mapEntityToDto(List<Feedback> entities);

    Feedback mapDtoToEntity(FeedbackRequest dto);
}
