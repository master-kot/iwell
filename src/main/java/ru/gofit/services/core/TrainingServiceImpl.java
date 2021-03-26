package ru.gofit.services.core;

import lombok.RequiredArgsConstructor;
import org.springframework.security.access.AccessDeniedException;
import org.springframework.security.core.Authentication;
import org.springframework.stereotype.Service;
import ru.gofit.dto.TrainingDto;
import ru.gofit.dto.TrainingRequest;
import ru.gofit.entities.Training;
import ru.gofit.exceptions.DataBadRequestException;
import ru.gofit.helpers.Roles;
import ru.gofit.mappers.TrainingMapper;
import ru.gofit.repositories.TrainingRepository;
import ru.gofit.services.api.TrainingService;
import ru.gofit.services.api.UserService;

import java.util.List;
import java.util.Optional;

import static ru.gofit.helpers.Messages.DATA_WAS_NOT_FOUND_BY_ID;

@Service
@RequiredArgsConstructor
public class TrainingServiceImpl implements TrainingService {

    private final TrainingRepository trainingRepository;
    private final TrainingMapper trainingMapper;
    private final UserService userService;


    @Override
    public TrainingDto readDtoByTrainingId(Long trainingId) {
        if (trainingRepository.findById(trainingId).isPresent()) {
            return trainingMapper.mapEntityToDto(trainingRepository.findById(trainingId));
        }else{
            throw new DataBadRequestException(String.format(DATA_WAS_NOT_FOUND_BY_ID, trainingId));
        }
    }

    @Override
    public List<TrainingDto> getAllDto() {
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
    public List<TrainingDto> findAllTrainingDtoById(List<Long> idList) {
        return trainingMapper.mapEntityToDto(trainingRepository.findAllById(idList));
    }

    @Override
    public List<TrainingDto> findAllDtoByAuth(Authentication authentication) {
        return null;
    }
}

