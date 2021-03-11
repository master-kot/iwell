package ru.gofit.mappers;

import org.mapstruct.Mapper;
import org.mapstruct.MappingTarget;
import org.mapstruct.ReportingPolicy;
import ru.gofit.dto.SportTypeRqDto;
import ru.gofit.dto.SportTypeRsDto;
import ru.gofit.entities.SportType;


@Mapper(componentModel = "spring", unmappedTargetPolicy = ReportingPolicy.IGNORE)
public interface SportTypeMapper {

    SportTypeRsDto mapEntityToDto(SportType entity);

    SportType mapDtoToEntity(SportTypeRqDto sportTypeRqDto);

    SportType update(@MappingTarget SportType entity, SportTypeRqDto sportTypeRqDto);
}
