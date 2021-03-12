package ru.gofit.entities;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.util.List;
import java.util.Set;

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
    @OneToOne(optional = false, mappedBy = "clientProfile", cascade = CascadeType.ALL)
    private User user;

    // Короткая информация о себе
    @Column(name = "client_info", length = 500)
    private String clientInfo;

    // Спортивные достижения
    @Column(name = "sports_achivments", length = 150)
    private String sportsAchivments;

    // Спортивный разряд
    @Column(name = "sports_grade", length = 150)
    private String sportsGrade;

    // Список пакетов тренировок
    @OneToMany(mappedBy = "clientProfile", cascade = CascadeType.ALL)
    private List<Subscription> subscriptions;

    // Список тренировок для данного клиента
    @OneToMany(mappedBy = "clientProfile", cascade = CascadeType.ALL)
    private List<Training> trainings;

    // Список денежных операций
    @OneToMany(mappedBy = "clientProfile", cascade = CascadeType.ALL)
    private List<ClientTransaction> clientTransactions;

    // Виды спорта
    @ManyToMany
    @JoinTable(
            name = "client_sport_types",
            joinColumns = @JoinColumn(name = "client_profile_id"),
            inverseJoinColumns = @JoinColumn(name = "sport_type_id"))
    private Set<SportType> sportTypes;
}
