package javacamp.hrms.business.concretes;

import javacamp.hrms.business.abstracts.CvSchoolService;
import javacamp.hrms.business.abstracts.EmployeeCvService;
import javacamp.hrms.core.utilities.results.DataResult;
import javacamp.hrms.core.utilities.results.Result;
import javacamp.hrms.core.utilities.results.SuccessDataResult;
import javacamp.hrms.core.utilities.results.SuccessResult;
import javacamp.hrms.dataAccess.abstracts.CvSchoolDao;
import javacamp.hrms.entities.concretes.CvSchool;
import javacamp.hrms.entities.concretes.EmployeeCv;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CvSchoolManager implements CvSchoolService {

    private EmployeeCvService employeeCvService;
    private CvSchoolDao cvSchoolDao;

    @Autowired
    public CvSchoolManager(EmployeeCvService employeeCvService, CvSchoolDao cvSchoolDao) {
        this.employeeCvService = employeeCvService;
        this.cvSchoolDao = cvSchoolDao;
    }

    @Override
    public Result add(CvSchool cvSchool,int cvId) {
        EmployeeCv employeeCv=this.employeeCvService.getByEmployeeCvId(cvId).getData();
        cvSchool.setEmployeeCv(employeeCv);
        this.cvSchoolDao.save(cvSchool);
        return new SuccessResult();
    }

    @Override
    public Result addAll(List<CvSchool> cvSchool) {
        this.cvSchoolDao.saveAll(cvSchool);
        return new SuccessResult();
    }

    @Override
    public DataResult<List<CvSchool>> getAllByEmployeeCv_Employee_EmployeeIdOrderByStartDateSchoolAsc(int id) {
        return new SuccessDataResult<>(this.cvSchoolDao.getAllByEmployeeCv_Employee_EmployeeIdOrderByStartDateSchoolAsc(id));
    }

    @Override
    public DataResult<List<CvSchool>> getAllByEmployeeCv_EmployeeCvId(int id) {
        return new SuccessDataResult<>(this.cvSchoolDao.getAllByEmployeeCv_EmployeeCvId(id));
    }
}
