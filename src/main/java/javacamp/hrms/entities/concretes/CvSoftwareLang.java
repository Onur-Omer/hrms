package javacamp.hrms.entities.concretes;
import com.sun.istack.NotNull;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import javax.validation.constraints.NotBlank;

@Data
@Entity
@AllArgsConstructor
@NoArgsConstructor
@Table(name="software_langs")
public class CvSoftwareLang {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "cv_software_lang")
    private int cv_software_lang;

    @NotBlank
    @NotNull
    @Column(name = "used_languages")
    private String usedLanguages;

    @ManyToOne()
    @JoinColumn(name = "employee_cv_id")
    private EmployeeCv employeeCv;
}
