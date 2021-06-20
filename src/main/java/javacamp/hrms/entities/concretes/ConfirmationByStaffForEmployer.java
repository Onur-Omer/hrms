package javacamp.hrms.entities.concretes;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Entity
@Table(name = "confirmationByStaffForEmployer")
@Data
@AllArgsConstructor
@NoArgsConstructor
public class ConfirmationByStaffForEmployer {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    int confirmationByStaffForEmployerId;

    @Column(name = "is_confirmed")
    boolean isConfirmed = false;

    @JsonIgnore
    @OneToOne(mappedBy = "confirmationByStaffForEmployer")
    Employer employer;

}
