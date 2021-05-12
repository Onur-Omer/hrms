package javacamp.hrms.entities.concretes;

import lombok.Data;

import javax.persistence.*;

@Data
@Entity
@Table(name = "personels")
public class Personel {
    @Id
    @GeneratedValue
    @Column(name = "id")
    private int id;

    @Column(name = "first_name")
    private String firstName;

    @Column(name = "last_name")
    private String lastName;

    @Column(name = "email")
    private String email;

    @Column(name = "password")
    private String password;
}
