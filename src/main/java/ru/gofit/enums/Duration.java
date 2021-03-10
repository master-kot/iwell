package ru.gofit.enums;

import lombok.Getter;
import lombok.RequiredArgsConstructor;

/**
 * Продолжительность тренировки
 */
@Getter
@RequiredArgsConstructor
public enum Duration {

    HALF_AN_HOUR("30 минут"),
    HOUR("60 минут");

    private final String description;
}
