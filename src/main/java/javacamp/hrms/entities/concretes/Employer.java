package javacamp.hrms.entities.concretes;


import lombok.Data;

import javax.persistence.*;

@Data
@Entity
@Table(name="employers")
public class Employer {

    @Id
    @GeneratedValue
    @Column(name = "id")
    private int id;

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
}
