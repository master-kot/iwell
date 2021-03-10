package ru.gofit.entities;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.util.List;

/**
 * Сущность Профиль тренера
 */
@Entity
@Getter
@Setter
@NoArgsConstructor
@Table(name = "coach_profiles")
public class CoachProfile {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", nullable = false, unique = true)
    private Long id;

    // Пользователь, которому соответствует данный профиль
    @OneToOne
    @JoinColumn(name = "user_id", nullable = false)
    private User user;

    // Короткая информация о себе
    @Column(name = "coach_info", length = 500)
    private String userInfo;

    // Спортивные достижения
    @Column(name = "sports_achivments", length = 150)
    private String sportsAchivments;

    // Спортивный разряд
    @Column(name = "sports_grade", length = 150)
    private String sportsGrade;

    // Список тренировок
    @OneToMany(mappedBy = "coachProfile")
    private List<Training> trainings;

    // Количество завершенных тренировок
    @Column(name = "training_amount", nullable = false)
    private Integer trainingAmount;

    // Средняя оценка (рейтинг тренера)
    @Column(name = "rating")
    private Float rating;

    // Количество денег на счете
    @Column(name = "money_amount", nullable = false)
    private Integer moneyAmount;

    // Отзывы о тренере
    @OneToMany(mappedBy = "coachProfile")
    private List<Review> reviews;

    // Список входящих денежных операций (приход денег за тренировку)
    @OneToMany(mappedBy = "coachProfile")
    private List<IncomeCoachTransaction> incomeCoachTransactions;

    // Список исходящих денежных операций (вывод денег)
    @OneToMany(mappedBy = "coachProfile")
    private List<OutcomeCoachTransaction> outcomeCoachTransactions;

    // Виды спорта
    @ManyToMany
    @JoinTable(
            name = "coach_sport_types",
            joinColumns = @JoinColumn(name = "coach_profile_id"),
            inverseJoinColumns = @JoinColumn(name = "sport_type_id"))
    private List<SportType> sportTypes;
}
