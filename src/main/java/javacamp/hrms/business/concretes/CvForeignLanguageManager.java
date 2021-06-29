package javacamp.hrms.business.concretes;

import javacamp.hrms.business.abstracts.CvForeignLanguageService;
import javacamp.hrms.business.abstracts.EmployeeCvService;
import javacamp.hrms.core.utilities.results.DataResult;
import javacamp.hrms.core.utilities.results.Result;
import javacamp.hrms.core.utilities.results.SuccessDataResult;
import javacamp.hrms.core.utilities.results.SuccessResult;
import javacamp.hrms.dataAccess.abstracts.CvForeignLanguageDao;
import javacamp.hrms.entities.concretes.CvForeignLanguage;
import javacamp.hrms.entities.concretes.EmployeeCv;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CvForeignLanguageManager implements CvForeignLanguageService {

    private EmployeeCvService employeeCvService;
    private CvForeignLanguageDao cvForeignLanguageDao;

    @Autowired
    public CvForeignLanguageManager(EmployeeCvService employeeCvService, CvForeignLanguageDao cvForeignLanguageDao) {
        this.employeeCvService = employeeCvService;
        this.cvForeignLanguageDao = cvForeignLanguageDao;
    }

    @Override
    public Result add(CvForeignLanguage cvForeignLanguage,int cvId) {
        EmployeeCv employeeCv=this.employeeCvService.getByEmployeeCvId(cvId).getData();
        cvForeignLanguage.setEmployeeCv(employeeCv);
        this.cvForeignLanguageDao.save(cvForeignLanguage);
        return null;
    }

    @Override
    public Result addAll(List<CvForeignLanguage> cvForeignLanguage) {
        this.cvForeignLanguageDao.saveAll(cvForeignLanguage);
        return new SuccessResult();
    }


    @Override
    public DataResult<List<CvForeignLanguage>> getAllByEmployeeCv_Employee_EmployeeId(int id) {
        return new SuccessDataResult<List<CvForeignLanguage>>(this.cvForeignLanguageDao.getAllByEmployeeCv_Employee_EmployeeId(id));
    }

    @Override
    public DataResult<List<CvForeignLanguage>> getAllByEmployeeCv_EmployeeCvId(int id) {
        return new SuccessDataResult<>(this.cvForeignLanguageDao.getAllByEmployeeCv_EmployeeCvId(id));
    }
}
