package ru.auheal.services.api;

import org.springframework.security.core.Authentication;
import ru.auheal.dto.TrainingDto;
import ru.auheal.dto.TrainingRequest;

import java.time.LocalDate;
import java.time.LocalDateTime;
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
    TrainingDto readDtoByTrainingId(Long trainingId);

    /**
     * Возвращает все тренировки
     *
     * @return список dto тренировок
     */
    List<TrainingDto> getAllDto();



    /**
     * Получить список тренировок определенного тренера
     * @param  coachId тренера, для которой получаем список тренировок
     * @param authentication данные авторизации
     * @return список тренировок
     */
    List<TrainingDto> readAllDtoByCoachId(Long coachId, Authentication authentication);


    /**
     * Получить список тренировок определенного клиента
     * @param  clientId тренера, для которой получаем список тренировок
     * @param authentication данные авторизации
     * @return список тренировок
     */
    List<TrainingDto> readAllDtoByClientId(Long clientId, Authentication authentication);

    /**
     * Создать новую тренировку
     *
     * @param trainingRequest запрос, содержащий данные тренировки
     * @param authentication данные авторизации
     * @return новое мероприятие, сохраненное в репозитории
     */
    TrainingDto save(TrainingRequest trainingRequest, Authentication authentication);

    /**
     * Изменить данные мероприятия по его id
     *
     * @param trainingRequest мероприятие с измененными данными
     * @param trainingId индекс мероприятия
     * @param authentication данные авторизации
     */
    TrainingDto update(TrainingRequest trainingRequest, Long trainingId, Authentication authentication);

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
    List<TrainingDto> findAllEventDtoById(List<Long> idList);



    /**
     * Возвращает тренировки пользователя по аутентификации и за заданный интервал времени с заданной даты
     *
     * @param from дата начала интервала времени, за который показывают мероприятия
     * @param to дата конца интервала времени
     */
    List<TrainingDto> readAllDtoByAuthFromTo( LocalDate from, LocalDate to, Authentication authentication);
}