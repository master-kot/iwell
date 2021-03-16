package ru.auheal.services.core;

import lombok.RequiredArgsConstructor;
import org.springframework.security.core.Authentication;
import org.springframework.stereotype.Service;
import ru.auheal.dto.AccentDto;
import ru.auheal.mappers.AccentMapper;
import ru.auheal.exceptions.DataBadRequestException;
import ru.auheal.helpers.Roles;
import ru.auheal.repositories.AccentRepository;
import ru.auheal.services.api.AccentService;

import java.util.List;

import static ru.auheal.helpers.Messages.*;

@Service
@RequiredArgsConstructor
public class AccentServiceImpl implements AccentService {
    private final AccentRepository accentRepository;
    private final AccentMapper accentMapper;

    @Override
    public AccentDto readAccentDtoByDescription(String description) {
        return accentMapper.mapEntityToDto(accentRepository.findByDescription(description));
    }

    @Override
    public List<AccentDto> readAllAccentesDto()
    {
        return accentMapper.mapEntityToDto(accentRepository.findAll());
    }

    @Override
    public AccentDto saveAccent(AccentDto accentDto, Authentication authentication) {
        if (Roles.hasAuthenticationRoleAdmin(authentication)) {
            var accent = accentMapper.mapDtoToEntity(accentDto);
            return accentMapper.mapEntityToDto(accentRepository.save(accent));
        }else {
            throw new DataBadRequestException(DATA_WAS_NOT_SAVED);
        }
    }

    @Override
    public AccentDto updateAccent(AccentDto accentDto, Authentication authentication) {
        if (Roles.hasAuthenticationRoleAdmin(authentication)){
            var accent = accentMapper.mapDtoToEntity(accentDto);
            accentRepository.save(accent);
            return accentMapper.mapEntityToDto(accent);
        }
        throw new DataBadRequestException(DATA_NOT_UPDATED);
    }

    @Override
    public Boolean deleteById(Short accentId, Authentication authentication) {
        if (Roles.hasAuthenticationRoleAdmin(authentication)){
            var accent = accentRepository.findById(accentId);
            accentRepository.deleteById(accentId);
            return accentRepository.existsById(accentId);
        }else {
            throw new DataBadRequestException(DATA_WAS_NOT_FOUND_BY_ID);
        }
    }
}
