package ru.gofit.entities;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.util.Set;

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
    @Column(name = "id", nullable = false, unique = true)
    private Short id;

    // Описание
    @Column(name = "description", nullable = false, unique = true, length = 50)
    private String description;

    // Профили клиентов
    @ManyToMany
    @JoinTable(
            name = "client_sport_types",
            joinColumns = @JoinColumn(name = "sport_type_id"),
            inverseJoinColumns = @JoinColumn(name = "client_profile_id"))
    private Set<ClientProfile> clientProfiles;

    // Профили тренеров
    @ManyToMany
    @JoinTable(
            name = "coach_sport_types",
            joinColumns = @JoinColumn(name = "sport_type_id"),
            inverseJoinColumns = @JoinColumn(name = "coach_profile_id"))
    private Set<CoachProfile> coachProfiles;
}
