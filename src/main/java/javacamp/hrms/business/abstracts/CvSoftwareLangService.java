package javacamp.hrms.business.abstracts;

import javacamp.hrms.core.utilities.results.DataResult;
import javacamp.hrms.core.utilities.results.Result;
import javacamp.hrms.entities.concretes.CvSoftwareLang;

import java.util.List;

public interface CvSoftwareLangService {
    Result add(CvSoftwareLang cvSoftwareLang,int cvId);
    Result addAll(List<CvSoftwareLang> cvSoftwareLang);
    DataResult<List<CvSoftwareLang>> getAllByEmployeeCv_Employee_EmployeeId(int id);
    DataResult<List<CvSoftwareLang>> getAllByEmployeeCv_EmployeeCvId(int id);
}
