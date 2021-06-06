package javacamp.hrms.entities.concretes;
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
public class CvExperiance {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name="cv_experiance_id")
    private int cv_experiance_id;

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
    @JoinColumn(name="employee_cv_id")
    private EmployeeCv employeeCv;
}
