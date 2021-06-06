package javacamp.hrms.business.abstracts;

import javacamp.hrms.core.utilities.results.Result;
import javacamp.hrms.entities.dtos.EmployeeForLogin;
import javacamp.hrms.entities.dtos.EmployeeForRegister;
import javacamp.hrms.entities.dtos.EmployerForRegister;

public interface AuthService {
    Result registerEmployee(EmployeeForRegister employeeForRegister);
    Result registerEmployer(EmployerForRegister employerForRegister);
}
