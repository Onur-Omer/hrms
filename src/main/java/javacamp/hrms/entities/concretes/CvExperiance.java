package javacamp.hrms.entities.concretes;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.sun.istack.NotNull;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import javax.validation.constraints.NotBlank;
import java.time.LocalDate;


@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
@Table(name="job_experiances")
//@JsonIgnoreProperties({ "hibernateLazyInitializer", "handler", "employeeCv" })

public class CvExperiance {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name="cv_experiance_id")
    private int cvExperianceId;

    @NotBlank
    @NotNull
    @Column(name = "workplace_name")
    private String workplaceName;

    @NotBlank
    @NotNull
    @Column(name = "position")
    private String position;

    @NotBlank
    @NotNull
    @Column(name = "start_date")
    private LocalDate startDate;

    @Column(name = "finish_date")
    private LocalDate finishDate;

    @ManyToOne()
    @JsonIgnore
    @JoinColumn(name="employeeCvId")
    private EmployeeCv employeeCv;
}
