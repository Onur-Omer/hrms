package javacamp.hrms.entities.concretes;

import javax.persistence.GenerationType;
import javax.persistence.Id;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
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
@JsonIgnoreProperties({ "hibernateLazyInitializer", "handler", "employeeCv" })

public class CvForeignLanguage {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name="cv_foreign_language_id")
    private int cvForeignLanguageId;

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
    @JsonIgnore
    @JoinColumn(name="employeeCvId")
    private EmployeeCv employeeCv;
}
