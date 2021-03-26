package ru.gofit.mappers;

import org.mapstruct.Mapper;
import org.mapstruct.MappingTarget;
import org.mapstruct.ReportingPolicy;
import ru.gofit.dto.SportTypeDto;
import ru.gofit.dto.SportTypeRqDto;
import ru.gofit.dto.SportTypeRsDto;
import ru.gofit.entities.SportType;

import java.util.List;


@Mapper(componentModel = "spring", unmappedTargetPolicy = ReportingPolicy.IGNORE)
public interface SportTypeMapper {

    SportTypeRsDto mapEntityToDto(SportType entity);

    SportType mapDtoToEntity(SportTypeRqDto sportTypeRqDto);

    SportType update(@MappingTarget SportType entity, SportTypeRqDto sportTypeRqDto);

    SportTypeDto mapEntityToDto(SportType entity);

    List<SportTypeDto> mapEntityToDto(List<SportType> entities);

    SportType mapDtoToEntity(SportTypeDto dto);
}
