package javacamp.hrms.business.abstracts;

import javacamp.hrms.core.utilities.results.DataResult;
import javacamp.hrms.core.utilities.results.Result;
import javacamp.hrms.entities.concretes.CvExperiance;


import java.util.List;

public interface CvExperianceService {
    Result add(CvExperiance cvExperiance,int cvId);
    Result addAll(List<CvExperiance> cvExperiance);
    DataResult<List<CvExperiance>> getAllByEmployeeCv_Employee_EmployeeIdOrderByFinishDateDesc(int id);
    DataResult<List<CvExperiance>> getAllByEmployeeCv_EmployeeCvId(int id);
}
