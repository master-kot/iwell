package ru.auheal.mappers;

import org.mapstruct.Mapper;
import org.mapstruct.ReportingPolicy;
import ru.auheal.dto.ReviewDto;
import ru.auheal.dto.ReviewRequest;
import ru.auheal.entities.Review;

import java.util.List;

/**
 * Маппер, преобразующий классы Review и ReviewDto друг в друга
 */
@Mapper(componentModel = "spring", unmappedTargetPolicy = ReportingPolicy.IGNORE)
public interface ReviewMapper  {

    ReviewDto mapEntityToDto(Review entity);

    List<ReviewDto> mapEntityToDto(List<Review> entities);

    Review mapDtoToEntity(ReviewRequest dto);
}