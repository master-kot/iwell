package ru.gofit.services.core;

import lombok.RequiredArgsConstructor;
import org.springframework.security.core.Authentication;
import org.springframework.stereotype.Service;
import ru.gofit.dto.AccentRsDto;
import ru.gofit.mappers.AccentMapper;
import ru.gofit.exceptions.DataBadRequestException;
import ru.gofit.helpers.Roles;
import ru.gofit.repositories.AccentRepository;
import ru.gofit.services.api.AccentService;

import java.util.List;

import static ru.gofit.helpers.Messages.*;

@Service
@RequiredArgsConstructor
public class AccentServiceImpl implements AccentService {
    private final AccentRepository accentRepository;
    private final AccentMapper accentMapper;

    @Override
    public AccentRsDto readAccentDtoByDescription(String description) {
        return accentMapper.mapEntityToDto(accentRepository.findByDescription(description));
    }

    @Override
    public List<AccentRsDto> readAllAccentesDto()
    {
        return accentMapper.mapEntityToDto(accentRepository.findAll());
    }

    @Override
    public AccentRsDto saveAccent(AccentRsDto accentRsDto, Authentication authentication) {
        if (Roles.hasAuthenticationRoleAdmin(authentication)) {
            var accent = accentMapper.mapDtoToEntity(accentRsDto);
            return accentMapper.mapEntityToDto(accentRepository.save(accent));
        }else {
            throw new DataBadRequestException(DATA_WAS_NOT_SAVED);
        }
    }

    @Override
    public AccentRsDto updateAccent(AccentRsDto accentRsDto, Authentication authentication) {
        if (Roles.hasAuthenticationRoleAdmin(authentication)){
            var accent = accentMapper.mapDtoToEntity(accentRsDto);
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
