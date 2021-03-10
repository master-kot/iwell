package ru.gofit.entities;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.time.LocalDateTime;

/**
 * Сущность Исходящая денежная операция профиля тренера
 */
@Entity
@Getter
@Setter
@NoArgsConstructor
@Table(name = "outcome_coach_transactions")
public class OutcomeCoachTransaction {

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

    // Денежный счет, на который осуществлен исходящий перевод
    @Column(name = "account", nullable = false, length = 100)
    private String account;
}
