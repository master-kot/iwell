package ru.gofit.mappers;

import org.mapstruct.Mapper;
import org.mapstruct.ReportingPolicy;
import ru.gofit.enums.Gender;

/**
 * Маппер, преобразующий классы Gender и String друг в друга
 */
@Mapper(componentModel = "spring", unmappedTargetPolicy = ReportingPolicy.IGNORE)
public interface GenderMapper {

    default String mapEntityToString(Gender entity) {
        return entity.getDescription();
    }

    default Gender mapStringToEntity(String string) {
        Gender entity;
        switch (string) {
            case "Не выбран":
                entity = Gender.NOT_SELECTED;
                break;
            case "Женский":
                entity = Gender.FEMALE;
                break;
            case "Мужской":
                entity = Gender.MALE;
                break;
            default:
                entity = Gender.NOT_SELECTED;
        }
        return entity;
    }
}
