package ru.gofit.entities;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.time.LocalDateTime;

/**
 * Сущность Клиентская денежная операция
 */
@Entity
@Getter
@Setter
@NoArgsConstructor
@Table(name = "client_transactions")
public class ClientTransaction {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", nullable = false, unique = true)
    private Long Id;

    // Дата и время транзакции
    @Column(name = "date_time", nullable = false)
    private LocalDateTime dateTime;

    // Профиль клиента
    @ManyToOne
    @JoinColumn(name = "client_profile_id", nullable = false)
    private ClientProfile clientProfile;

    // Пакет тренировок, для покупки которого осуществлен перевод
    @ManyToOne
    @JoinColumn(name = "subscription_id", nullable = false)
    private Subscription subscription;
}
