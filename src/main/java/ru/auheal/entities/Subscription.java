package ru.auheal.entities;

import lombok.*;
import org.hibernate.annotations.Fetch;
import org.hibernate.annotations.FetchMode;

import javax.persistence.*;
import java.math.BigDecimal;
import java.util.List;


@Getter
@Setter
@ToString
@Builder
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "subscriptions")
public class Subscription {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Long id;

    @Column(name = "training_name", nullable = false)
    private String trainingName;

    @Column(name = "price_subscription", nullable = false)
    private BigDecimal priceSubscription;

    @Column(name = "count_visits")
    private Integer countVisits;

    @Column(name = "kind_service")
    private String kindService;

    @OneToMany(mappedBy = "subscription")
    @Fetch(FetchMode.SUBSELECT)
    private List<Card> cards;
}
