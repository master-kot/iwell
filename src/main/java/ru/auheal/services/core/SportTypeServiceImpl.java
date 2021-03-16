package ru.auheal.services.core;


import lombok.RequiredArgsConstructor;
import org.springframework.security.core.Authentication;
import org.springframework.stereotype.Service;
import ru.auheal.dto.SportTypeDto;
import ru.auheal.exceptions.DataBadRequestException;
import ru.auheal.helpers.Roles;
import ru.auheal.mappers.SportTypeMapper;
import ru.auheal.repositories.SportTypeRepository;
import ru.auheal.services.api.SportTypeService;

import java.util.List;

import static ru.auheal.helpers.Messages.*;

@Service
@RequiredArgsConstructor
public class SportTypeServiceImpl implements SportTypeService {
    private final SportTypeRepository sportTypeRepository;
    private final SportTypeMapper sportTypeMapper;

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
