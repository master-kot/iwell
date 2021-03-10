package ru.gofit.entities;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;

/**
 * Сущность Отзыв о тренере
 */
@Entity
@Setter
@Getter
@NoArgsConstructor
@Table(name = "reviews")
public class Review {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", nullable = false, unique = true)
    private Integer id;

    // Текст отзыва
    @Column(name = "text", nullable = false, length = 500)
    private String text;

    // Оценка
    @Column(name = "rating", nullable = false)
    private Short rating;

    // Профиль тренера
    @ManyToOne
    @JoinColumn(name = "coach_profile_id", nullable = false)
    private CoachProfile coachProfile;

    // Профиль клиента, написавшего отзыв
    @ManyToOne
    @JoinColumn(name = "client_profile_id", nullable = false)
    private ClientProfile clientProfile;
}
