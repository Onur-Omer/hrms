package javacamp.hrms.business.abstracts;

import javacamp.hrms.core.utilities.results.DataResult;
import javacamp.hrms.core.utilities.results.Result;
import javacamp.hrms.entities.concretes.CvForeignLanguage;


import java.util.List;

public interface CvForeignLanguageService {
    Result add(CvForeignLanguage cvForeignLanguage,int cvId);
    Result addAll(List<CvForeignLanguage> cvForeignLanguage);
    DataResult<List<CvForeignLanguage>> getAllByEmployeeCv_Employee_EmployeeId(int id);
    DataResult<List<CvForeignLanguage>> getAllByEmployeeCv_EmployeeCvId(int id);
}
