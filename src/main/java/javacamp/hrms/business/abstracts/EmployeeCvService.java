package javacamp.hrms.business.abstracts;

import javacamp.hrms.core.utilities.results.DataResult;
import javacamp.hrms.core.utilities.results.Result;
import javacamp.hrms.entities.concretes.EmployeeCv;

import java.util.List;


public interface EmployeeCvService {
    DataResult<List<EmployeeCv>> getAllByEmployee_EmployeeId(int id);
    Result add(EmployeeCv employeeCv);
    DataResult<EmployeeCv> getByEmployeeCvId(int id);

}
