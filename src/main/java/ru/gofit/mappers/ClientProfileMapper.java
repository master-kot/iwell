package ru.gofit.mappers;

import org.mapstruct.*;
import ru.gofit.dto.ClientProfileDto;
import ru.gofit.dto.ClientProfileRqDto;
import ru.gofit.dto.ClientProfileRsDto;
import ru.gofit.dto.SportTypeRqDto;
import ru.gofit.dto.SportTypeRsDto;
import ru.gofit.entities.ClientProfile;
import ru.gofit.entities.SportType;

import java.util.List;

@Mapper(componentModel = "spring", unmappedTargetPolicy = ReportingPolicy.IGNORE)
public interface ClientProfileMapper {

    ClientProfileRsDto mapEntityToDto(ClientProfile entity);

    @Mappings({
            @Mapping(target = "user", ignore = true)
    })
    ClientProfile mapDtoToEntity(ClientProfileRqDto clientProfileRqDto);

    @Mappings({
            @Mapping(target = "user", ignore = true)
    })
    ClientProfile update(@MappingTarget ClientProfile entity, ClientProfileRqDto clientProfileRqDto);

    ClientProfileDto mapEntityToDto(ClientProfile entity);

    List<ClientProfileDto> mapEntityToDto(List<ClientProfile> entities);

    ClientProfile mapDtoToEntity(ClientProfileDto dto);
}
