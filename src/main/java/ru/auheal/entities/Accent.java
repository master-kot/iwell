package ru.auheal.entities;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.util.List;

/**
 * Сущность Акцент тренировки
 */
@Entity
@Getter
@Setter
@NoArgsConstructor
@Table(name = "accents")
public class Accent {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", nullable = false, unique = true)
    private Short id;

    // Описание
    @Column(name = "description", nullable = false, unique = true, length = 150)
    private String description;

    @OneToMany(mappedBy = "accent")
    private List<Training> trainings;
}