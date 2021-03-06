package ru.auheal.entities;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.util.List;

/**
 * Сущность Профиль клиента
 */
@Entity
@Getter
@Setter
@NoArgsConstructor
@Table(name = "client_profiles")
public class ClientProfile {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", nullable = false, unique = true)
    private Long id;

    // Пользователь, которому соответствует данный профиль
    @OneToOne
    @JoinColumn(name = "user_id", nullable = false)
    private User user;

    // Виды спорта
    @ManyToMany
    @JoinTable(
            name = "client_sport_types",
            joinColumns = @JoinColumn(name = "client_id"),
            inverseJoinColumns = @JoinColumn(name = "sport_type_id"))
    private List<SportType> sportTypes;

    // Короткая информация о себе
    @Column(name = "user_info", length = 500)
    private String userInfo;

    // Спортивные достижения
    @Column(name = "sports_achivments", length = 150)
    private String sportsAchivments;

    // Спортивный разряд
    @Column(name = "sports_grade", length = 150)
    private String sportsGrade;

    // Список пакетов тренировок
    @OneToMany(mappedBy = "clientProfile")
    private List<Subscription> subscriptions;

    // Список тренировок для данного клиента
    @OneToMany(mappedBy = "clientProfile")
    private List<Training> trainings;

    // Список денежных операций
    @OneToMany(mappedBy = "clientProfile")
    private List<ClientTransaction> clientTransactions;
}
