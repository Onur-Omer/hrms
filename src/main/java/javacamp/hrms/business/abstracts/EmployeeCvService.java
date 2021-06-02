package javacamp.hrms.business.abstracts;

import javacamp.hrms.core.utilities.results.DataResult;
import javacamp.hrms.core.utilities.results.Result;
import javacamp.hrms.entities.concretes.EmployeeCv;


public interface EmployeeCvService {
    DataResult<EmployeeCv> getByEmployee_Id(int id);
    Result add(EmployeeCv employeeCv);
}
