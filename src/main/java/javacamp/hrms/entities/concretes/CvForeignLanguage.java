package javacamp.hrms.entities.concretes;

import javax.persistence.GenerationType;
import javax.persistence.Id;

import com.sun.istack.NotNull;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import javax.validation.constraints.Max;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotBlank;
import java.time.LocalDate;



@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
@Table(name="foreign_languages")
public class CvForeignLanguage {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name="cv_foreign_language_id")
    private int cv_foreign_language_id;

    @NotBlank
    @NotNull
    @Column(name = "language")
    private String language;

    @Min(1)
    @Max(5)
    @NotBlank
    @NotNull
    @Column(name = "level")
    private int level;

    @ManyToOne()
    @JoinColumn(name="employee_cv_id")
    private EmployeeCv employeeCv;
}
