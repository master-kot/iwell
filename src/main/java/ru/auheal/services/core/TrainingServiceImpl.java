package ru.auheal.services.core;

import lombok.RequiredArgsConstructor;
import org.springframework.security.access.AccessDeniedException;
import org.springframework.security.core.Authentication;
import org.springframework.stereotype.Service;
import ru.auheal.dto.TrainingDto;
import ru.auheal.dto.TrainingRequest;
import ru.auheal.entities.Training;
import ru.auheal.exceptions.DataBadRequestException;
import ru.auheal.helpers.Roles;
import ru.auheal.mappers.TrainingMapper;
import ru.auheal.repositories.TrainingRepository;
import ru.auheal.services.api.TrainingService;

import java.time.LocalDate;
import java.util.List;
import java.util.Optional;

import static ru.auheal.helpers.Messages.DATA_WAS_NOT_FOUND_BY_ID;

@Service
@RequiredArgsConstructor
public class TrainingServiceImpl implements TrainingService {

    private final TrainingRepository trainingRepository;
    private final TrainingMapper trainingMapper;


    @Override
    public TrainingDto readDtoByTrainingId(Long trainingId) {
        if (trainingRepository.findById(trainingId).isPresent()) {
            return trainingMapper.mapEntityToDto(trainingRepository.findById(trainingId));
        }else{
            throw new DataBadRequestException(String.format(DATA_WAS_NOT_FOUND_BY_ID, trainingId));
        }
    }

    @Override
    public List<TrainingDto> readAllDto() {
        return trainingMapper.mapEntityToDto(trainingRepository.findAll());
    }


    @Override
    public List<TrainingDto> readAllDtoByCoachId(Long coachId, Authentication authentication) {
        return null;
    }

    @Override
    public List<TrainingDto> readAllDtoByClientId(Long clientId, Authentication authentication) {
        return null;
    }

    @Override
    public TrainingDto save(TrainingRequest trainingRequest, Authentication authentication) {
        if (Roles.hasAuthenticationRoleAdmin(authentication)) {
            return trainingMapper.mapEntityToDto(trainingRepository
                    .save(trainingMapper.mapDtoToEntity(trainingRequest)));
        } else {
            throw new AccessDeniedException("У пользователя недостаточно прав доступа");
        }
    }

    @Override
    public TrainingDto update(TrainingRequest trainingRequest, Long trainingId, Authentication authentication) {
        if (Roles.hasAuthenticationRoleAdmin(authentication)) {
            Optional<Training> training = trainingRepository.findById(trainingId);
            if(trainingRequest.getName().equals(training.get().getName())) {
                return trainingMapper.mapEntityToDto(trainingRepository
                        .save(trainingMapper.mapDtoToEntity(trainingRequest)));
            }else{
                throw new DataBadRequestException(String.format(DATA_WAS_NOT_FOUND_BY_ID, trainingId));
            }
        } else {
            throw new AccessDeniedException("У пользователя недостаточно прав доступа");
        }
    }

    @Override
    public boolean deleteById(Long trainingId, Authentication authentication) {
        if (Roles.hasAuthenticationRoleAdmin(authentication)) {
            trainingRepository.deleteById(trainingId);
            return !trainingRepository.existsById(trainingId);
        } else {
            throw new AccessDeniedException("У пользователя недостаточно прав доступа");
        }
    }


    @Override
    public boolean isExists(Long trainingId) {
        return trainingRepository.existsById(trainingId);
    }

    @Override
    public List<TrainingDto> findAllEventDtoById(List<Long> idList) {
        return trainingMapper.mapEntityToDto(trainingRepository.findAllById(idList));
    }

    @Override
    public List<TrainingDto> readAllDtoByAuthFromTo(LocalDate from, LocalDate to, Authentication authentication) {
        return null;
    }
}

