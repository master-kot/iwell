package ru.gofit.entities;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import ru.gofit.enums.Duration;

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

    // Общее количество тренировок
    @Column(name = "initial_amount", nullable = false)
    private Short initialAmount;

    // Оставшееся количество тренировок
    @Column(name = "remaining_amount", nullable = false)
    private Short remainingAmount;

    // Стоимость пакета
    @Column(name = "total_price", nullable = false)
    private Integer totalPrice;

    // Цена за одну тренировку, оплачиваемая тренеру
    @Column(name = "unit_price", nullable = false)
    private Integer unitPrice;

    // Продолжительность тренировки
    @Column(name = "duration", nullable = false)
    @Enumerated(EnumType.ORDINAL)
    private Duration duration;

    // Профиль клиента
    @ManyToOne
    @JoinColumn(name = "client_profile_id", nullable = false)
    private ClientProfile clientProfile;

    // Список тренировок, прошедших по данному пакету
    @OneToMany(mappedBy = "subscription", cascade = CascadeType.ALL)
    private List<Training> trainings;
}
