package javacamp.hrms.entities.concretes;


import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.List;

@Data
@Entity
@Table(name="employers")
@AllArgsConstructor
@NoArgsConstructor
@JsonIgnoreProperties({ "hibernateLazyInitializer", "handler", "jobAds" })

public class Employer {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "employer_id")
    private int employerId;

    @Column(name = "company_name")
    private String companyName;

    @Column(name = "website")
    private String website;

    @Column(name = "phone")
    private String phone;

    @Column(name = "email")
    private String email;

    @Column(name = "password")
    private String password;

    @Column(name = "status")
    private boolean status;

    @OneToMany(mappedBy = "employer")
    @JsonIgnore
    private List<JobAd> jobAds;

    @OneToOne()
    @JoinColumn(name =  "confirmationByMailId")
    @JsonIgnore
    ConfirmationByMail confirmationByMail;

    @OneToOne()
    @JoinColumn(name = "confirmationByStaffForEmployerId")
    @JsonIgnore
    ConfirmationByStaffForEmployer confirmationByStaffForEmployer;
}
