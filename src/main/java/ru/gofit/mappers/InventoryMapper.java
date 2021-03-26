package ru.gofit.mappers;

import org.mapstruct.*;
import ru.gofit.dto.SportTypeRqDto;
import ru.gofit.dto.SportTypeRsDto;
import ru.gofit.entities.Inventory;
import ru.gofit.entities.SportType;

import java.util.List;
import java.util.Set;


@Mapper(componentModel = "spring", unmappedTargetPolicy = ReportingPolicy.IGNORE)
public interface InventoryMapper {

    default String mapEntityToString(Inventory entity) {
        return entity.getDescription();
    }

    List<String> mapEntityToDto(Set<Inventory> entities);
}
