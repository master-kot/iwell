package ru.auheal.entities;

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
    @Column(name = "id")
    private Integer id;

    // Текст отзыва
    @Column(name = "text", nullable = false, length = 500)
    private String text;

    // Профиль клиента, написавшего отзыв
    @ManyToOne
    @JoinColumn(name = "client_profile_id", nullable = false)
    private ClientProfile clientProfileId;

    // Профиль тренера
    @ManyToOne
    @JoinColumn(name = "coach_profile_id", nullable = false)
    private CoachProfile coachProfileId;

    // Оценка
    @Column(name = "rating")
    private Short rating;
}
