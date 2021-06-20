package javacamp.hrms.entities.concretes;


import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Table(name = "confirmationByStaffForJobAd")
@Entity
public class ConfirmationByStaffForJobAd {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    int confirmationByStaffForJobAdId;

    @Column(name = "is_confirmed")
    boolean isConfirmed = false;

    @JsonIgnore
    @OneToOne(mappedBy = "confirmationByStaffForJobAd")
    JobAd jobAd;
}
