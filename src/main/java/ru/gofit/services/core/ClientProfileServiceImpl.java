package ru.gofit.services.core;

import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import ru.gofit.dto.ClientProfileRqDto;
import ru.gofit.dto.ClientProfileRsDto;
import ru.gofit.entities.ClientProfile;
import ru.gofit.entities.User;
import ru.gofit.exceptions.DataNotFoundException;
import ru.gofit.mappers.ClientProfileMapper;
import ru.gofit.repositories.ClientProfileRepository;
import ru.gofit.repositories.UserRepository;
import ru.gofit.services.api.ClientProfileService;

import static ru.gofit.helpers.Messages.DATA_WAS_NOT_FOUND_BY_ID;
import static ru.gofit.helpers.Messages.USER_NOT_FOUND_BY_ID;

@Service
@RequiredArgsConstructor
public class ClientProfileServiceImpl implements ClientProfileService {

    private final ClientProfileRepository clientProfileRepository;
    private final ClientProfileMapper clientProfileMapper;
    private final UserRepository userRepository;

    @Override
    public Page<ClientProfileRsDto> getAll(Pageable pageable) {
        return clientProfileRepository.findAll(pageable)
                .map(clientProfileMapper::mapEntityToDto);
    }

    @Override
    public ClientProfileRsDto getById(Long id) {
        return clientProfileRepository.findById(id)
                .map(clientProfileMapper::mapEntityToDto)
                .orElseThrow(() ->
                        new DataNotFoundException(String.format(DATA_WAS_NOT_FOUND_BY_ID, id))
                );
    }

    @Override
    @Transactional
    public ClientProfileRsDto save(ClientProfileRqDto clientProfileRqDto) {
        ClientProfile entity = clientProfileMapper.mapDtoToEntity(clientProfileRqDto);
        Long userId = clientProfileRqDto.getUserId();
        User user = userRepository.findById(userId)
                .orElseThrow(() ->
                        new DataNotFoundException(String.format(DATA_WAS_NOT_FOUND_BY_ID, userId))
                );
        entity.setUser(user);
        ClientProfile newClientProfile = clientProfileRepository.save(entity);
        return clientProfileMapper.mapEntityToDto(newClientProfile);
    }

    @Override
    @Transactional
    public ClientProfileRsDto update(Long id, ClientProfileRqDto clientProfileRqDto) {
        ClientProfile clientProfileFromDb = clientProfileRepository.findById(id)
                .orElseThrow(() -> new DataNotFoundException(String.format(USER_NOT_FOUND_BY_ID, id)));
        ClientProfile updateClientProfile = clientProfileMapper.update(clientProfileFromDb, clientProfileRqDto);
        Long userId = clientProfileRqDto.getUserId();
        User user = userRepository.findById(userId)
                .orElseThrow(() ->
                        new DataNotFoundException(String.format(DATA_WAS_NOT_FOUND_BY_ID, userId))
                );
        updateClientProfile.setUser(user);
        return clientProfileMapper.mapEntityToDto(clientProfileRepository.save(updateClientProfile));
    }

    @Override
    public void deleteById(Long id) {
        clientProfileRepository.findById(id)
                .ifPresentOrElse(clientProfileRepository::delete,
                        () -> {
                            throw new DataNotFoundException(String.format(USER_NOT_FOUND_BY_ID, id));
                        }
                );
    }

    @Override
    public ClientProfileRsDto getByUserId(Long id) {
        return clientProfileRepository.getByUserId(id)
                .map(clientProfileMapper::mapEntityToDto)
                .orElseThrow(() ->
                        new DataNotFoundException(String.format(DATA_WAS_NOT_FOUND_BY_ID, id))
                );
    }
}
