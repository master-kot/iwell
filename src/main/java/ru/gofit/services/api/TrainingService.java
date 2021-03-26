package ru.gofit.services.api;

import org.springframework.security.core.Authentication;
import ru.gofit.dto.TrainingRsDto;
import ru.gofit.dto.TrainingRqDto;

import java.util.List;


/**
 * Сервис Тренировок
 */
public interface TrainingService {

    /**
     * Возвращает тренировку по ее идентификатору
     *
     * @param trainingId идентификатор тренировки
     * @return dto тренировки
     */
    TrainingRsDto readDtoByTrainingId(Long trainingId);

    /**
     * Возвращает все тренировки
     *
     * @return список dto тренировок
     */
    List<TrainingRsDto> getAllDto();



    /**
     * Получить список тренировок определенного тренера
     * @param  coachId тренера, для которой получаем список тренировок
     * @param authentication данные авторизации
     * @return список тренировок
     */
    List<TrainingRsDto> readAllDtoByCoachId(Long coachId, Authentication authentication);


    /**
     * Получить список тренировок определенного клиента
     * @param  clientId тренера, для которой получаем список тренировок
     * @param authentication данные авторизации
     * @return список тренировок
     */
    List<TrainingRsDto> readAllDtoByClientId(Long clientId, Authentication authentication);

    /**
     * Создать новую тренировку
     *
     * @param trainingRqDto запрос, содержащий данные тренировки
     * @param authentication данные авторизации
     * @return новое мероприятие, сохраненное в репозитории
     */
    TrainingRsDto save(TrainingRqDto trainingRqDto, Authentication authentication);

    /**
     * Изменить данные мероприятия по его id
     *
     * @param trainingRqDto мероприятие с измененными данными
     * @param trainingId индекс мероприятия
     * @param authentication данные авторизации
     */
    TrainingRsDto update(TrainingRqDto trainingRqDto, Long trainingId, Authentication authentication);

    /**
     * Удалить тренировку по его идентификатору
     *
     * @param trainingId идентификатор тренировки
     * @param authentication данные авторизации
     * @return удалено ли мероприятие
     */
    boolean deleteById(Long trainingId, Authentication authentication);

    /**
     * Проверяет существует ли сущность.
     * @param trainingId идентификатор мероприятия
     * @return true/false
     */
    boolean isExists(Long trainingId);


    /**
     * Возращает список мероприятий по списку идентификаторов
     * @param idList списк идентификаторов
     * @return список тренировок
     */
    List<TrainingRsDto> findAllTrainingDtoById(List<Long> idList);



    /**
     * Возвращает тренировки пользователя по аутентификации и за заданный интервал времени с заданной даты
     *
     */
    List<TrainingRsDto> findAllDtoByAuth(Authentication authentication);
}