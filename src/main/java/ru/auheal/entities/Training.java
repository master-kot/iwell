package ru.auheal.entities;

import lombok.*;
import org.hibernate.annotations.Fetch;
import org.hibernate.annotations.FetchMode;

import javax.persistence.*;
import java.util.List;

@Getter
@Setter
@ToString
@Builder
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "trainings")
public class Training {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Long Id;

    @Column(name = "kind_of_training")
    private String kindOfTraining;

    @OneToMany(mappedBy = "training")
    @Fetch(FetchMode.SUBSELECT)
    private List<Scheduled> schedulers;

    @ManyToMany(fetch = FetchType.EAGER)
    @Fetch(value = FetchMode.SUBSELECT)//MultipleBagFetchException
    @JoinTable(
            name = "coach_training_rel",
            joinColumns = @JoinColumn(name = "coach_id"),
            inverseJoinColumns = @JoinColumn(name = "training_id")
    )
    private List<Training> trainings;
}
