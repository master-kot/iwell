package ru.auheal.entities;

import lombok.*;
import org.hibernate.annotations.Fetch;
import org.hibernate.annotations.FetchMode;

import javax.persistence.*;
import java.time.Instant;
import java.util.List;

@Getter
@Setter
@ToString
@Builder
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "cards")
public class Card {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Long Id;

    @Column(name = "time_start", columnDefinition = "TIMESTAMP")
    private Instant timeStart;

    @Column(name = "time_stop", columnDefinition = "TIMESTAMP")
    private Instant timeStop;

    @Column(name = "lost_visits")
    private Integer lostVisits;

    @ManyToOne
    @JoinColumn(name = "subscription_id", nullable = false)
    private Subscription subscription;

    @ManyToOne
    @JoinColumn(name = "user_id", nullable = false)
    private User user;

    @OneToMany(mappedBy = "card")
    @Fetch(FetchMode.SUBSELECT)
    private List<Visit> visits;
}