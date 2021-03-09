package ru.auheal.entities;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;

/**
 * Сущность Инвентарь
 */
@Entity
@Getter
@Setter
@NoArgsConstructor
@Table(name = "inventories")
public class Inventory {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", nullable = false, unique = true)
    private Short id;

    // Описание
    @Column(name = "description", nullable = false, unique = true, length = 100)
    private String description;

    // Профиль тренера
    @ManyToOne
    @JoinColumn(name = "training_id", nullable = false)
    private Training training;
}
