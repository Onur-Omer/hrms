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
@Table(name="schools")
@JsonIgnoreProperties({ "hibernateLazyInitializer", "handler", "employeeCv" })

public class CvSchool {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name="cv_school_id")
    private int cvSchoolId;

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
    private String startDateSchool;

    @Column(name = "finish_date")
    private String finishDateSchool;

    @ManyToOne()
    @JsonIgnore
    @JoinColumn(name="employeeCvId")
    private EmployeeCv employeeCv;
}
