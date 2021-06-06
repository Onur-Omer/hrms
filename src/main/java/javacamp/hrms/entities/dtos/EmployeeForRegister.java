package javacamp.hrms.entities.dtos;


import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
@Data
public class EmployeeForRegister {

    private String firstName;

    private String lastName;

    private String identityNumber;

    private String birthday;

    private String email;

    private String password;

}
