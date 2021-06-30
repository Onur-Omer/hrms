package javacamp.hrms.business.concretes;

import javacamp.hrms.business.abstracts.CvExperianceService;
import javacamp.hrms.business.abstracts.EmployeeCvService;
import javacamp.hrms.core.utilities.results.DataResult;
import javacamp.hrms.core.utilities.results.Result;
import javacamp.hrms.core.utilities.results.SuccessDataResult;
import javacamp.hrms.core.utilities.results.SuccessResult;
import javacamp.hrms.dataAccess.abstracts.CvExperianceDao;
import javacamp.hrms.entities.concretes.CvExperiance;
import javacamp.hrms.entities.concretes.EmployeeCv;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CvExperianceManager implements CvExperianceService {

    private EmployeeCvService employeeCvService;
    private CvExperianceDao cvExperianceDao;

    @Autowired
    public CvExperianceManager(EmployeeCvService employeeCvService, CvExperianceDao cvExperianceDao) {
        this.employeeCvService = employeeCvService;
        this.cvExperianceDao = cvExperianceDao;
    }


    @Override
    public Result add(CvExperiance cvExperiance,int cvId) {
        EmployeeCv employeeCv=this.employeeCvService.getByEmployeeCvId(cvId).getData();
        cvExperiance.setEmployeeCv(employeeCv);
        this.cvExperianceDao.save(cvExperiance);
        return new SuccessResult();
    }

    @Override
    public Result addAll(List<CvExperiance> cvExperiance) {
        this.cvExperianceDao.saveAll(cvExperiance);
        return new SuccessResult();
    }

    @Override
    public DataResult<List<CvExperiance>> getAllByEmployeeCv_Employee_EmployeeIdOrderByFinishDateDesc(int id) {
        return new SuccessDataResult<List<CvExperiance>>(this.cvExperianceDao.getAllByEmployeeCv_Employee_EmployeeIdOrderByFinishDateDesc(id));
    }

    @Override
    public DataResult<List<CvExperiance>> getAllByEmployeeCv_EmployeeCvId(int id) {

        return new SuccessDataResult<>(this.cvExperianceDao.getAllByEmployeeCv_EmployeeCvId(id));
    }

    @Override
    public Result delete(int id) {
        this.cvExperianceDao.deleteById(id);
        return new SuccessResult();
    }
}
