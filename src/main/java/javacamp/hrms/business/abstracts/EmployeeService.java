package javacamp.hrms.business.abstracts;


import javacamp.hrms.core.utilities.results.DataResult;
import javacamp.hrms.core.utilities.results.Result;
import javacamp.hrms.entities.concretes.Employee;
import javacamp.hrms.entities.concretes.EmployeeCv;

import java.util.List;

public interface EmployeeService {

     Result signIn(Employee employee);
     DataResult<List<Employee>> getAll();
     DataResult<EmployeeCv> getEmployeeCvByEmployeeId(int id);
}
