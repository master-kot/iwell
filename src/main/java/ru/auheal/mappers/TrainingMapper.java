package ru.auheal.mappers;

import org.mapstruct.Mapper;
import org.mapstruct.ReportingPolicy;
import ru.auheal.dto.TrainingDto;
import ru.auheal.dto.TrainingRequest;
import ru.auheal.entities.Training;

import java.util.List;
import java.util.Optional;

/**
 * Маппер, преобразующий классы Training и TrainingDto друг в друга
 */
@Mapper(componentModel = "spring", unmappedTargetPolicy = ReportingPolicy.IGNORE)
public interface TrainingMapper   {

    TrainingDto mapEntityToDto(Training entity);

    List<TrainingDto> mapEntityToDto(List<Training> entities);

    Training mapDtoToEntity(TrainingRequest dto);

    TrainingDto mapEntityToDto(Optional<Training> byId);
}