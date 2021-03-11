package ru.auheal.entities;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import ru.auheal.enums.Duration;

import javax.persistence.*;
import java.util.List;


/**
 * Сущность Категория абонемента
 */
@Entity
@Getter
@Setter
@NoArgsConstructor
@Table(name = "category_subscriptions")
public class CategorySubscription {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", nullable = false, unique = true)
    private Short id;

    // Общее количество тренировок
    @Column(name = "initial_amount", nullable = false)
    private Short initialAmount;

    @OneToMany(mappedBy = "accent")
    private List<Training> trainings;

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

    @OneToMany(mappedBy = "categorySubscription")
    private List<Subscription> subscriptions;
}
