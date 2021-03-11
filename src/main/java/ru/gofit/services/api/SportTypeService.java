package ru.gofit.services.api;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import ru.gofit.dto.SportTypeRqDto;
import ru.gofit.dto.SportTypeRsDto;

import java.util.Optional;

public interface SportTypeService {

    Page<SportTypeRsDto> getAll(Pageable pageable);

    Optional<SportTypeRsDto> getById(Short id);

    SportTypeRsDto create(SportTypeRqDto sportTypeRqDto);
}
