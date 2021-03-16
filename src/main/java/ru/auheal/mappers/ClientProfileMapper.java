package ru.auheal.mappers;

import org.mapstruct.Mapper;
import org.mapstruct.ReportingPolicy;
import ru.auheal.dto.ClientProfileDto;
import ru.auheal.entities.ClientProfile;

import java.util.List;


/**
 * Маппер, преобразующий классы ClientProfile и ClientProfileDto друг в друга
 */
@Mapper(componentModel = "spring", unmappedTargetPolicy = ReportingPolicy.IGNORE)
public interface ClientProfileMapper {

    ClientProfileDto mapEntityToDto(ClientProfile entity);

    List<ClientProfileDto> mapEntityToDto(List<ClientProfile> entities);

    ClientProfile mapDtoToEntity(ClientProfileDto dto);
}