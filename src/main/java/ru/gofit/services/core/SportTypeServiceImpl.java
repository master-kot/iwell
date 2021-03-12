package ru.gofit.services.core;

import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import ru.gofit.dto.SportTypeRqDto;
import ru.gofit.dto.SportTypeRsDto;
import ru.gofit.entities.SportType;
import ru.gofit.exceptions.DataNotFoundException;
import ru.gofit.mappers.SportTypeMapper;
import ru.gofit.repositories.SportTypeRepository;
import ru.gofit.services.api.SportTypeService;

import static ru.gofit.helpers.Messages.DATA_WAS_NOT_FOUND_BY_ID;
import static ru.gofit.helpers.Messages.USER_NOT_FOUND_BY_ID;

@Service
@RequiredArgsConstructor
public class SportTypeServiceImpl implements SportTypeService {

    private final SportTypeRepository sportTypeRepository;
    private final SportTypeMapper sportTypeMapper;

    @Override
    public Page<SportTypeRsDto> getAll(Pageable pageable) {
        return sportTypeRepository.findAll(pageable)
                .map(sportTypeMapper::mapEntityToDto);
    }

    @Override
    public SportTypeRsDto getById(Short id) {
        return sportTypeRepository.findById(id)
                .map(sportTypeMapper::mapEntityToDto)
                .orElseThrow(() ->
                        new DataNotFoundException(String.format(DATA_WAS_NOT_FOUND_BY_ID, id))
                );
    }

    @Override
    @Transactional
    public SportTypeRsDto save(SportTypeRqDto sportTypeRqDto) {
        SportType newSportType = sportTypeRepository.save(sportTypeMapper.mapDtoToEntity(sportTypeRqDto));
        return sportTypeMapper.mapEntityToDto(newSportType);
    }

    @Override
    @Transactional
    public SportTypeRsDto update(Short id, SportTypeRqDto sportTypeRqDto) {
        SportType sportTypeFromDb = sportTypeRepository.findById(id)
                .orElseThrow(() -> new DataNotFoundException(String.format(USER_NOT_FOUND_BY_ID, id)));
        SportType updateSportType = sportTypeMapper.update(sportTypeFromDb, sportTypeRqDto);
        return sportTypeMapper.mapEntityToDto(sportTypeRepository.save(updateSportType));
    }

    @Override
    @Transactional
    public void deleteById(Short id) {
        sportTypeRepository.findById(id)
                .ifPresentOrElse(sportTypeRepository::delete,
                        () -> {
                            throw new DataNotFoundException(String.format(USER_NOT_FOUND_BY_ID, id));
                        }
                );
    }
}
