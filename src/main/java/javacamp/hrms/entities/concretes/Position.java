package javacamp.hrms.entities.concretes;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.List;

@Data
@Entity
@Table(name = "positions")
@JsonIgnoreProperties({ "hibernateLazyInitializer", "handler", "jobAds" })
@AllArgsConstructor
@NoArgsConstructor
public class Position {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "position_id")
    private int position_id;

    @Column(name = "position_name")
    private String positionName;

    @OneToMany(mappedBy = "position")
    private List<JobAd> jobAds;
}
