package javacamp.hrms.business.abstracts;

import javacamp.hrms.core.utilities.results.DataResult;
import javacamp.hrms.core.utilities.results.Result;
import javacamp.hrms.entities.concretes.*;

public interface AuthService {
    Result registerEmployee(EmployeeForRegister employeeForRegister);
    Result registerEmployer(EmployerForRegister employerForRegister);
    Result registerPersonel(Personel personel);
    DataResult<Employee> loginEmployee(EmployeeForLogin employeeForLogin);
    DataResult<Employer> loginEmployer(EmployerForLogin employerForLogin);
    DataResult<Personel> loginPersonel(PersonelForLogin personelForLogin);
}
