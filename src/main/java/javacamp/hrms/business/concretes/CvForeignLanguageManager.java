package javacamp.hrms.business.concretes;

import javacamp.hrms.business.abstracts.CvForeignLanguageService;
import javacamp.hrms.core.utilities.results.DataResult;
import javacamp.hrms.core.utilities.results.Result;
import javacamp.hrms.core.utilities.results.SuccessDataResult;
import javacamp.hrms.dataAccess.abstracts.CvForeignLanguageDao;
import javacamp.hrms.entities.concretes.CvForeignLanguage;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CvForeignLanguageManager implements CvForeignLanguageService {

    private CvForeignLanguageDao cvForeignLanguageDao;

    @Autowired
    public CvForeignLanguageManager(CvForeignLanguageDao cvForeignLanguageDao) {
        this.cvForeignLanguageDao = cvForeignLanguageDao;
    }

    @Override
    public Result add(CvForeignLanguage cvForeignLanguage) {
        this.cvForeignLanguageDao.save(cvForeignLanguage);
        return null;
    }


    @Override
    public DataResult<List<CvForeignLanguage>> getAllByEmployeeCv_Employee_EmployeeId(int id) {
        return new SuccessDataResult<List<CvForeignLanguage>>(this.cvForeignLanguageDao.getAllByEmployeeCv_Employee_EmployeeId(id));
    }
}
