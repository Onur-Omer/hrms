package javacamp.hrms.entities.concretes;

import lombok.Data;

import javax.persistence.*;
import java.util.Date;

@Data
@Entity
@Table(name = "employees")
public class Employee {

    @Id
    @GeneratedValue
    @Column(name = "id")
    private int id;

    @Column(name = "first_name")
    private String firstName;

    @Column(name = "last_name")
    private String lastName;

    @Column(name = "identity_number")
    private String identityNumber;

    @Column(name = "birthday")
    private Date birthday;

    @Column(name = "email")
    private String email;

    @Column(name = "password")
    private String password;

}
