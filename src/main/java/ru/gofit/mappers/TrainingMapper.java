package ru.gofit.mappers;

import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.Mappings;
import org.mapstruct.ReportingPolicy;
import ru.gofit.dto.TrainingRqDto;
import ru.gofit.dto.TrainingRsDto;
import ru.gofit.entities.Training;

import java.util.List;
import java.util.Optional;

/**
 * Маппер, преобразующий классы Training и TrainingRsDto друг в друга
 */
@Mapper(componentModel = "spring", unmappedTargetPolicy = ReportingPolicy.IGNORE, uses =
        {InventoryMapper.class, SportLevelMapper.class})
public interface TrainingMapper   {

    @Mappings({
            @Mapping(target = "trainingId", source = "entity.id"),
            @Mapping(target = "trainingName", source = "entity.name"),
            @Mapping(target = "sportType", source = "entity.sportType.description"),
            @Mapping(target = "accent", source = "entity.accent.description"),
            @Mapping(target = "coachProfileId", source = "entity.coachProfile.id"),
    })
    TrainingRsDto mapEntityToDto(Training entity);

    List<TrainingRsDto> mapEntityToDto(List<Training> entities);

    @Mappings({
            @Mapping(target = "sportType", ignore = true),
            @Mapping(target = "accent", ignore = true),
            @Mapping(target = "inventories", ignore = true),
    })
    Training mapDtoToEntity(TrainingRqDto dto);

    TrainingRsDto mapEntityToDto(Optional<Training> byId);
}