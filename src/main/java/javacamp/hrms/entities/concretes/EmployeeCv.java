package javacamp.hrms.entities.concretes;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.List;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
@Table(name = "employee_info")
public class EmployeeCv {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private int id;

    @ManyToOne
    @JoinColumn(name = "id")
    private Employee employee;

    @Column(name = "photo")
    private String photo;

    @Column(name = "github")
    private String github;

    @Column(name = "linkedln")
    private String linkedln;

    @Column(name = "first_article")
    private String firstArticle;

    @Column(name = "active_status")
    private boolean activeStatus;

    @OneToMany(mappedBy = "employeeCv")
    private List<CvExperiance> experiances;

    @OneToMany(mappedBy = "employeeCv")
    private List<CvSchool> schools;

    @OneToMany(mappedBy = "employeeCv")
    private List<CvSoftwareLang> langs;

    @OneToMany(mappedBy = "employeeCv")
    private List<CvForeignLanguage> foreignLanguages;

}
