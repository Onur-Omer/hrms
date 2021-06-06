package javacamp.hrms.business.abstracts;


import javacamp.hrms.core.utilities.results.DataResult;
import javacamp.hrms.core.utilities.results.Result;
import javacamp.hrms.entities.concretes.Employee;

import java.util.List;

public interface EmployeeService {

     Result add(Employee employee);
     DataResult<List<Employee>> getAll();
     DataResult<Employee> getByEmail(String email);
}
