package ru.gofit.services.api;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import ru.gofit.dto.ClientProfileRqDto;
import ru.gofit.dto.ClientProfileRsDto;

public interface ClientProfileService {

    /**
     * Найти все профили клиентов
     *
     * @param pageable количество страниц и количество профилей клиентов на странице
     * @return список профилей клиентов
     */
    Page<ClientProfileRsDto> getAll(Pageable pageable);

    /**
     * Найти профиль клиента по его идентификатору
     *
     * @param id идентификатор профиля клиента
     * @return профиль клиента
     */
    ClientProfileRsDto getById(Long id);

    /**
     * Создать профиль клиента
     *
     * @param clientProfileRqDto запрос с данными профиля клиента
     * @return новый профиль клиента, сохраненный в репозитории
     */
    ClientProfileRsDto save(ClientProfileRqDto clientProfileRqDto);

    /**
     * Изменить описание профиля клиента
     *
     * @param id                 профиль клиента
     * @param clientProfileRqDto изиененное описание профиля клиента
     * @return измененный профиль клиента, сохраненный в репозитории
     */
    ClientProfileRsDto update(Long id, ClientProfileRqDto clientProfileRqDto);

    /**
     * Удалить профиль клиента по его идентификатору
     *
     * @param id идентификатор профиля клиента
     */
    void deleteById(Long id);

    /**
     * Найти профиль клиента по его идентификатору клиента
     *
     * @param id идентификатор клиента
     * @return профиль клиента
     */
    ClientProfileRsDto getByUserId(Long id);
}
