package ru.gofit.mappers;

import org.mapstruct.Mapper;
import org.mapstruct.ReportingPolicy;
import ru.gofit.enums.SportLevel;

/**
 * Маппер, преобразующий классы SportLevel и String друг в друга
 */
@Mapper(componentModel = "spring", unmappedTargetPolicy = ReportingPolicy.IGNORE)
public interface SportLevelMapper {

    default String mapEntityToString(SportLevel entity) {
        return entity.getDescription();
    }

    default SportLevel mapStringToEntity(String string) {
        SportLevel entity;
        switch (string) {
            case "Не выбран":
                entity = SportLevel.NOT_SELECTED;
                break;
            case "Начальный":
                entity = SportLevel.LOW;
                break;
            case "Средний":
                entity = SportLevel.MIDDLE;
                break;
            case "Подготовленный":
                entity = SportLevel.HI;
                break;
            default:
                entity = SportLevel.NOT_SELECTED;
        }
        return entity;
    }
}
