package ru.gofit.services.core;

import lombok.RequiredArgsConstructor;
import org.springframework.security.access.AccessDeniedException;
import org.springframework.security.core.Authentication;
import org.springframework.stereotype.Service;
import ru.gofit.dto.TrainingRqDto;
import ru.gofit.dto.TrainingRsDto;
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
    public TrainingRsDto readDtoByTrainingId(Long trainingId) {
        if (trainingRepository.findById(trainingId).isPresent()) {
            return trainingMapper.mapEntityToDto(trainingRepository.findById(trainingId));
        }else{
            throw new DataBadRequestException(String.format(DATA_WAS_NOT_FOUND_BY_ID, trainingId));
        }
    }

    @Override
    public List<TrainingRsDto> getAllDto() {
        return trainingMapper.mapEntityToDto(trainingRepository.findAll());
    }


    @Override
    public List<TrainingRsDto> readAllDtoByCoachId(Long coachId, Authentication authentication) {
        return null;
    }

    @Override
    public List<TrainingRsDto> readAllDtoByClientId(Long clientId, Authentication authentication) {
        return null;
    }

    @Override
    public TrainingRsDto save(TrainingRqDto trainingRqDto, Authentication authentication) {
        if (Roles.hasAuthenticationRoleAdmin(authentication)) {
            return trainingMapper.mapEntityToDto(trainingRepository
                    .save(trainingMapper.mapDtoToEntity(trainingRqDto)));
        } else {
            throw new AccessDeniedException("У пользователя недостаточно прав доступа");
        }
    }

    @Override
    public TrainingRsDto update(TrainingRqDto trainingRqDto, Long trainingId, Authentication authentication) {
        if (Roles.hasAuthenticationRoleAdmin(authentication)) {
            Optional<Training> training = trainingRepository.findById(trainingId);
            if(trainingRqDto.getName().equals(training.get().getName())) {
                return trainingMapper.mapEntityToDto(trainingRepository
                        .save(trainingMapper.mapDtoToEntity(trainingRqDto)));
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
    public List<TrainingRsDto> findAllTrainingDtoById(List<Long> idList) {
        return trainingMapper.mapEntityToDto(trainingRepository.findAllById(idList));
    }

    @Override
    public List<TrainingRsDto> findAllDtoByAuth(Authentication authentication) {
        return null;
    }
}

