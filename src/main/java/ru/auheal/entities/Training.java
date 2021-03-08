package ru.auheal.entities;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import ru.auheal.enums.Duration;
import ru.auheal.enums.SportLevel;

import javax.persistence.*;
import java.time.LocalDateTime;

/**
 * Сущность Тренировка
 */
@Entity
@Getter
@Setter
@NoArgsConstructor
@Table(name = "trainings")
public class Training {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", nullable = false, unique = true)
    private Long Id;

    // Название тренировки
    @Column(name = "name", length = 50)
    private String name;

    // Время начала мероприятия
    @Column(name = "start_date_time", nullable = false)
    private LocalDateTime startDateTime;

    // Время завершения мероприятия
    @Column(name = "end_date_time")
    private LocalDateTime endDateTime;

    // Вид спорта тренировки
    @ManyToOne
    @JoinColumn(name = "sport_type_id")
    private SportType sportType;

    // Требуемый уровень пользователя
    @Column(name = "sport_level_id", nullable = false)
    @Enumerated(EnumType.ORDINAL)
    private SportLevel sportLevel;

    // Инвентарь
    @ManyToOne
    @JoinColumn(name = "inventory_id")
    private Inventory inventory;

    // Акцент на который направлено занятие
    @ManyToOne
    @JoinColumn(name = "accent_id")
    private Accent accent;

    // Профиль тренера
    @ManyToOne
    @JoinColumn(name = "coach_profile_id", nullable = false)
    private CoachProfile coachProfile;

    // Ссылка на онлайн трансляцию тренировки
    @Column(name = "video_link", length = 150)
    private String videoLink;

    // Количество участников тренировки (за исключением тренера)
    @Column(name = "capacity")
    private Short capacity;

    // Продолжительность тренировки
    @Column(name = "duration", nullable = false)
    @Enumerated(EnumType.ORDINAL)
    private Duration duration;

    // Клиентский пакет тренировок, по которому проводится тренировка
    @ManyToOne
    @JoinColumn(name = "subscription_id")
    private Subscription subscription;

    // Профиль клиента-участника тренировки
    @ManyToOne
    @JoinColumn(name = "client_profile_id")
    private ClientProfile clientProfile;

    // Статус завершения тренировки
    @Column(name = "was_completed", nullable = false)
    private Boolean wasCompleted;

    // Комментарий, оставленный тренером, не видимый пользователю
    @Column(name = "comment", length = 100)
    private String comment;
}
