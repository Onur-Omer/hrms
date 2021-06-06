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
@Table(name="schools")
public class CvSchool {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name="cv_school_id")
    private int cv_school_id;

    @NotBlank
    @NotNull
    @Column(name = "name")
    private String name;

    @NotBlank
    @NotNull
    @Column(name = "department")
    private String department;

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
