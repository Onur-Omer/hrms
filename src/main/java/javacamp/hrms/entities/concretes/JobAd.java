package javacamp.hrms.entities.concretes;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;


import javax.persistence.*;


@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "job_ads")
public class JobAd {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "job_ad_id")
    private int jobAdId;

    @Column(name = "title")
    private String title;

    @Column(name = "description")
    private String description;


    @Column(name = "max_salary")
    private int maxSalary;

    @Column(name = "min_salary")
    private int minSalary;

    @Column(name = "number_of_employee")
    private int numberOfEmployee;

    @Column(name = "last_date")
    private String lastDate;

    @Column(name = "first_date")
    private String firstDate;

    @Column(name = "work_time")
    private String workTime;

    @Column(name = "work_place")
    private String workPlace;

    @Column(name = "active")
    private boolean active;

    @ManyToOne()
    @JoinColumn(name = "employerId")
    private Employer employer;

    @ManyToOne()
    @JoinColumn(name = "positionId")
    private Position position;

    @ManyToOne()
    @JoinColumn(name = "cityId")
    private  City city;

    @OneToOne()
    @JoinColumn(name = "confirmationByStaffForJobAdId")
    ConfirmationByStaffForEmployer confirmationByStaffForJobAd;
}
