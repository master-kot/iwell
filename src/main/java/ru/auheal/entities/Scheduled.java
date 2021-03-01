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
@Table(name = "schedulers")
public class Scheduled {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Long Id;

    @Column(name = "start_Event", columnDefinition = "TIMESTAMP")
    private Instant startEvent;

    @Column(name = "end_Event", columnDefinition = "TIMESTAMP")
    private Instant endEvent;

    @ManyToOne
    @JoinColumn(name = "coach_id", nullable = false)
    private Coach coach;

    @ManyToOne
    @JoinColumn(name = "training_id", nullable = false)
    private Training training;

    @OneToMany(mappedBy = "scheduled")
    @Fetch(FetchMode.SUBSELECT)
    private List<Visit> visits;
}
