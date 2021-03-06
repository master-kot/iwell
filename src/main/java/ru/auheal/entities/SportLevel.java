package ru.auheal.entities;

import lombok.Getter;
import lombok.RequiredArgsConstructor;

/**
 * Сущность Уровень владения спортом
 */
@Getter
@RequiredArgsConstructor
public enum SportLevel {

    LOW("Начальный"),
    MIDDLE("Средний"),
    HI("Подготовленный");

    private final String description;
}
