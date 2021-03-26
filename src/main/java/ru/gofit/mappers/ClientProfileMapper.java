package ru.gofit.mappers;

import org.mapstruct.*;
import ru.gofit.dto.ClientProfileRqDto;
import ru.gofit.dto.ClientProfileRsDto;
import ru.gofit.entities.ClientProfile;

import java.util.List;

@Mapper(componentModel = "spring", unmappedTargetPolicy = ReportingPolicy.IGNORE)
public interface ClientProfileMapper {

    @Mappings({
            @Mapping(target = "user", ignore = true)
    })
    ClientProfile mapDtoToEntity(ClientProfileRqDto clientProfileRqDto);

    @Mappings({
            @Mapping(target = "user", ignore = true)
    })
    ClientProfile update(@MappingTarget ClientProfile entity, ClientProfileRqDto clientProfileRqDto);

    ClientProfileRsDto mapEntityToDto(ClientProfile entity);

    List<ClientProfileRsDto> mapEntityToDto(List<ClientProfile> entities);

}
