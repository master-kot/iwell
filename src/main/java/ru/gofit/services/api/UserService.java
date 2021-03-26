package ru.gofit.services.api;

import org.springframework.security.core.Authentication;
import ru.gofit.dto.PasswordRequest;
import ru.gofit.dto.UserRqDto;
import ru.gofit.dto.UserRsDto;
import ru.gofit.security.JwtUser;

import java.util.List;

/**
 * Сервис пользователей
 */
public interface UserService {

    /*
     * СОГЛАШЕНИЕ О НАИМЕНОВАНИИ МЕТОДОВ СЕРВИСОВ
     * User getById(Long id) найти объект по параметру
     * UserRsDto getDtoById(Long id) найти Dto объект по параметру
     * List<User> getAll() найти все объекты
     * List<UserRsDto> getAllDto() найти все Dto объекты
     * List<UserRsDto> getAllDtoByObject(ObjectDto objectDto) найти все Dto объекты по параметру
     * UserRsDto update(UserRsDto userDto) изменить объект
     * UserRsDto save(UserRsDto userDto) сохранить объект
     * List<UserRsDto> saveAll(List<UserRsDto> userDtoList) сохранить список объектов
     * void delete(UserRsDto userDto) удалить конкретный объект
     * void deleteById(Long id) удалить объект по параметру
     * void deleteAll(List<UserRsDto> userDtoList) удалить список объектов
     *
     * ДОПОЛНИТЕЛЬНЫЕ ПОЛОЖЕНИЯ
     * 1. JavaDoc создается:
     * 1.1. на кажном методе в интерфейсе
     * 1.2. на каждом НЕ переопределяемом методе в имплиментации
     * 1.3. на полях класса
     *
     */

    /**
     * Найти пользователя по его идентификатору
     *
     * @param id идентификатор пользователя
     * @return пользователь
     */
    UserRsDto getDtoById(Long id);

    /**
     * Найти пользователя по данным авторизации
     *
     * @param authentication данные авторизации
     * @return пользователь
     */
    UserRsDto getDtoByAuthentication(Authentication authentication);

    /**
     * Найти Jwt пользователя
     *
     * @param username логин пользователя
     * @return Jwt Пользователь
     */
    JwtUser getJwtByUsername(String username);

    /**
     * Получить id пользователя по авторизации
     *
     * @param authentication данные авторизации
     * @return id Пользователя
     */
    Long getIdByAuthentication(Authentication authentication);

    /**
     * Найти всех пользователей
     *
     * @return список пользователей
     */
    List<UserRsDto> getAllDto();

    /**
     * Создать нового пользователя
     *
     * @param userRqDto запрос с данными пользователя
     * @return новый пользователь, сохраненный в репозитории
     */
    UserRsDto save(UserRqDto userRqDto);

    /**
     * Изменить данные пользователя
     *
     * @param userRsDto пользователь с измененными данными
     * @param authentication данные авторизации
     */
    UserRsDto update(UserRsDto userRsDto, Authentication authentication);

    /**
     * Удалить пользователя по его идентификатору
     *
     * @param id идентификатор пользователя
     * @return удален ли пользователь
     */
    boolean deleteById(Long id);

    /**
     * Изменить пароль пользователя
     *
     * @param passwordRequest данные для изменения пароля
     * @param authentication данные авторизации
     * @return измененен ли пользователь
     */
    boolean updatePassword(PasswordRequest passwordRequest, Authentication authentication);
}
