package ru.gofit.enums;

import lombok.Getter;
import lombok.RequiredArgsConstructor;

/**
 * Сущность Уровень владения спортом
 */
@Getter
@RequiredArgsConstructor
public enum SportLevel {

    NOT_SELECTED("Не выбран"),
    LOW("Начальный"),
    MIDDLE("Средний"),
    HI("Подготовленный");

    private final String description;
}
