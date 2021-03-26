package ru.gofit.entities;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.time.LocalDateTime;
import java.util.List;

/**
 * Сущность Пакет тренировок
 */
@Entity
@Getter
@Setter
@NoArgsConstructor
@Table(name = "subscriptions")
public class Subscription {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", nullable = false, unique = true)
    private Long id;

    // Время начала действия пакета
    @Column(name = "start_date_time", nullable = false)
    private LocalDateTime startDateTime;

    // Время завершения действия пакета
    @Column(name = "end_date_time")
    private LocalDateTime endDateTime;

    // Оставшееся количество тренировок
    @Column(name = "remaining_amount", nullable = false)
    private Short remainingAmount;

     // Профиль клиента
    @ManyToOne
    @JoinColumn(name = "client_profile_id", nullable = false)
    private ClientProfile clientProfile;

    @ManyToOne
    @JoinColumn(name = "category_subscription_id", nullable = false)
    private CategorySubscription categorySubscription;

    // Список тренировок, прошедших по данному пакету
    @OneToMany(mappedBy = "subscription")
    private List<Training> trainings;
}