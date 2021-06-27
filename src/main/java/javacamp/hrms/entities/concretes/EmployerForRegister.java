package javacamp.hrms.entities.concretes;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;


@Data
@AllArgsConstructor
@NoArgsConstructor
public class EmployerForRegister {

    private String companyName;

    private String website;

    private String phone;

    private String email;

    private String password;
}

