package ru.gofit.mappers;

import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.Mappings;
import org.mapstruct.ReportingPolicy;
import ru.gofit.dto.ReviewRsDto;
import ru.gofit.dto.ReviewRqDto;
import ru.gofit.entities.Review;

import java.util.List;

/**
 * Маппер, преобразующий классы Review и ReviewRsDto друг в друга
 */
@Mapper(componentModel = "spring", unmappedTargetPolicy = ReportingPolicy.IGNORE,
        uses = {CoachProfileMapper.class, ClientProfileMapper.class})
public interface ReviewMapper  {

    @Mappings({
            @Mapping(target = "text", source = "text"),
            @Mapping(target = "rating", source = "rating"),
            @Mapping(target = "coachProfileId", source = "coachProfile.id"),
            @Mapping(target = "clientProfileId", source = "clientProfile.id")
    })
    ReviewRsDto mapEntityToDto(Review entity);

    List<ReviewRsDto> mapEntityToDto(List<Review> entities);

    @Mappings({
            @Mapping(target = "text", source = "text"),
            @Mapping(target = "rating", source = "rating"),
            @Mapping(target = "coachProfile.id", source = "coachProfileId"),
            @Mapping(target = "clientProfile.id", source = "clientProfileId")
    })
    Review mapDtoToEntity(ReviewRqDto dto);
}