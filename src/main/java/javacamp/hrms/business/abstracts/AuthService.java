package javacamp.hrms.business.abstracts;

import javacamp.hrms.core.utilities.results.DataResult;
import javacamp.hrms.core.utilities.results.Result;
import javacamp.hrms.entities.concretes.Employee;
import javacamp.hrms.entities.concretes.Employer;
import javacamp.hrms.entities.dtos.EmployeeForLogin;
import javacamp.hrms.entities.dtos.EmployeeForRegister;
import javacamp.hrms.entities.dtos.EmployerForLogin;
import javacamp.hrms.entities.dtos.EmployerForRegister;

public interface AuthService {
    Result registerEmployee(EmployeeForRegister employeeForRegister);
    Result registerEmployer(EmployerForRegister employerForRegister);
    DataResult<Employee> loginEmployee(EmployeeForLogin employeeForLogin);
    DataResult<Employer> loginEmployer(EmployerForLogin employerForLogin);
}
