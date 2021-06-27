package javacamp.hrms.business.concretes;

import javacamp.hrms.business.abstracts.CvExperianceService;
import javacamp.hrms.core.utilities.results.DataResult;
import javacamp.hrms.core.utilities.results.Result;
import javacamp.hrms.core.utilities.results.SuccessDataResult;
import javacamp.hrms.core.utilities.results.SuccessResult;
import javacamp.hrms.dataAccess.abstracts.CvExperianceDao;
import javacamp.hrms.entities.concretes.CvExperiance;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CvExperianceManager implements CvExperianceService {

    private CvExperianceDao cvExperianceDao;

    @Autowired
    public CvExperianceManager(CvExperianceDao cvExperianceDao) {
        this.cvExperianceDao = cvExperianceDao;
    }


    @Override
    public Result add(CvExperiance cvExperiance) {
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
}
