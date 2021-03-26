package ru.gofit.entities;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.time.LocalDateTime;

/**
 * Сущность Входящая денежная операция профиля тренера
 */
@Entity
@Getter
@Setter
@NoArgsConstructor
@Table(name = "income_coach_transactions")
public class IncomeCoachTransaction {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", nullable = false, unique = true)
    private Long Id;

    // Дата и время транзакции
    @Column(name = "date_time", nullable = false)
    private LocalDateTime dateTime;

    // Профиль тренера
    @ManyToOne
    @JoinColumn(name = "coach_profile_id", nullable = false)
    private CoachProfile coachProfile;

    // Пакет тренировок, с которого осуществлен входящий перевод
    @ManyToOne
    @JoinColumn(name = "subscription_id", nullable = false)
    private Subscription subscription;
}
