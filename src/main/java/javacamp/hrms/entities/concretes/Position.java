package javacamp.hrms.entities.concretes;

import lombok.Data;

import javax.persistence.*;
import java.util.List;

@Data
@Entity
@Table(name = "positions")
public class Position {
    @Id
    @GeneratedValue
    @Column(name = "id")
    private int id;

    @Column(name = "position_name")
    private String positionName;

    @OneToMany(mappedBy = "position")
    private List<JobAd> jobAds;
}
