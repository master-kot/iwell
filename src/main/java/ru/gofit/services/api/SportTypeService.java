package ru.gofit.services.api;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import ru.gofit.dto.SportTypeRqDto;
import ru.gofit.dto.SportTypeRsDto;

public interface SportTypeService {

    Page<SportTypeRsDto> getAll(Pageable pageable);

    SportTypeRsDto getById(Short id);

    SportTypeRsDto create(SportTypeRqDto sportTypeRqDto);
}
