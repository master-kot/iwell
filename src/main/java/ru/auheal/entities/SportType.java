package ru.auheal.entities;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.util.List;

/**
 * Сущность Вид спорта
 */
@Entity
@Setter
@Getter
@NoArgsConstructor
@Table(name = "sport_types")
public class SportType {
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Short id;

    // Описание
    @Column(name = "description", nullable = false, unique = true, length = 50)
    private String description;

    // Профили клиентов
    @JoinTable(
            name = "client_sport_types",
            joinColumns = @JoinColumn(name = "sport_type_id"),
            inverseJoinColumns = @JoinColumn(name = "client_id"))
    private List<ClientProfile> clientProfiles;

    // Профили тренеров
    @JoinTable(
            name = "coach_sport_types",
            joinColumns = @JoinColumn(name = "sport_type_id"),
            inverseJoinColumns = @JoinColumn(name = "coach_id"))
    private List<ClientProfile> coachProfiles;
}
