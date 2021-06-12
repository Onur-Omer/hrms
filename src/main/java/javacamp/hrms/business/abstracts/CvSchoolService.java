package javacamp.hrms.business.abstracts;

import javacamp.hrms.core.utilities.results.DataResult;
import javacamp.hrms.core.utilities.results.Result;
import javacamp.hrms.entities.concretes.CvSchool;

import java.util.List;

public interface CvSchoolService {
    Result add(CvSchool cvSchool);
    DataResult<List<CvSchool>> getAllByEmployeeCv_Employee_EmployeeIdOrderByStartDateAsc(int id);
}