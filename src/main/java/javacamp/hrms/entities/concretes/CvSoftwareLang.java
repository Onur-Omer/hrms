package javacamp.hrms.entities.concretes;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
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
@JsonIgnoreProperties({ "hibernateLazyInitializer", "handler", "employeeCv" })

public class CvSoftwareLang {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "cv_software_lang_id")
    private int cvSoftwareLangId;

    @NotBlank
    @NotNull
    @Column(name = "used_languages")
    private String usedLanguages;

    @ManyToOne()
    @JsonIgnore
    @JoinColumn(name = "employeeCvId")
    private EmployeeCv employeeCv;
}
