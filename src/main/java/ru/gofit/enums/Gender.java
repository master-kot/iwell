package ru.gofit.enums;

import lombok.Getter;
import lombok.RequiredArgsConstructor;

/**
 * Пол пользователя
 */
@Getter
@RequiredArgsConstructor
public enum Gender {

    NOT_SELECTED("Не выбран"),
    FEMALE("Женский"),
    MALE("Мужской");

    private final String description;
}
