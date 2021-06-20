package javacamp.hrms.entities.concretes;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToOne;
import javax.persistence.Table;


import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Table(name = "confirmationByStaff")
@Data
@AllArgsConstructor
@NoArgsConstructor
public class ConfirmationByMail {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    int confirmationByMailId;

    @Column(name = "confirmation_code")
    String confirmationCode;

    @Column(name = "is_confirmed")
    boolean isConfirmed;

    @JsonIgnore
    @OneToOne(mappedBy = "confirmationByMail")
    Employer employer;
}
