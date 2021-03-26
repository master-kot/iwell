package ru.gofit.services.core;

import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.security.core.Authentication;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import ru.gofit.dto.SportTypeDto;
import ru.gofit.dto.SportTypeRqDto;
import ru.gofit.dto.SportTypeRsDto;
import ru.gofit.entities.SportType;
import ru.gofit.exceptions.DataBadRequestException;
import ru.gofit.exceptions.DataNotFoundException;
import ru.gofit.helpers.Roles;
import ru.gofit.mappers.SportTypeMapper;
import ru.gofit.repositories.SportTypeRepository;
import ru.gofit.services.api.SportTypeService;

import java.util.List;

import static ru.gofit.helpers.Messages.*;

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

    @Override
    public SportTypeDto readSportTypeDtoByDescription(String description) {
        return sportTypeMapper.mapEntityToDto(sportTypeRepository.findByDescription(description));
    }

    @Override
    public List<SportTypeDto> readAllSportTypesDto() {
        return sportTypeMapper.mapEntityToDto(sportTypeRepository.findAll());
    }

    @Override
    public SportTypeDto saveAccent(SportTypeDto sportTypeDto, Authentication authentication) {
        if (Roles.hasAuthenticationRoleAdmin(authentication)) {
            var sportType = sportTypeMapper.mapDtoToEntity(sportTypeDto);
            return sportTypeMapper.mapEntityToDto(sportTypeRepository.save(sportType));
        }else {
            throw new DataBadRequestException(DATA_WAS_NOT_SAVED);
        }
    }

    @Override
    public SportTypeDto updateAccent(SportTypeDto sportTypeDto, Authentication authentication) {
        if (Roles.hasAuthenticationRoleAdmin(authentication)){
            var sportType = sportTypeMapper.mapDtoToEntity(sportTypeDto);
            sportTypeRepository.save(sportType);
            return sportTypeMapper.mapEntityToDto(sportType);
        }
        throw new DataBadRequestException(DATA_NOT_UPDATED);
    }

    @Override
    public Boolean deleteById(Short sportTypeId, Authentication authentication) {
        if (Roles.hasAuthenticationRoleAdmin(authentication)){
            var sportType = sportTypeRepository.findById(sportTypeId);
            sportTypeRepository.deleteById(sportTypeId);
            return sportTypeRepository.existsById(sportTypeId);
        }else {
            throw new DataBadRequestException(DATA_WAS_NOT_FOUND_BY_ID);
        }
    }
}
