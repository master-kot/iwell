package ru.gofit.mappers;

import org.mapstruct.Mapper;
import org.mapstruct.ReportingPolicy;
import ru.gofit.enums.Duration;

/**
 * Маппер, преобразующий классы Duration и String друг в друга
 */
@Mapper(componentModel = "spring", unmappedTargetPolicy = ReportingPolicy.IGNORE)
public interface DurationMapper {

    default String mapEntityToString(Duration entity) {
        return entity.getDescription();
    }

    default Duration mapStringToEntity(String string) {
        Duration entity;
        switch (string) {
            case "30 минут":
                entity = Duration.HALF_AN_HOUR;
                break;
            case "60 минут":
                entity = Duration.HOUR;
                break;
            default:
                entity = Duration.HALF_AN_HOUR;
        }
        return entity;
    }
}
