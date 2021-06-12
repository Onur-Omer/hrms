package javacamp.hrms.business.concretes;

import javacamp.hrms.business.abstracts.CvSoftwareLangService;
import javacamp.hrms.core.utilities.results.DataResult;
import javacamp.hrms.core.utilities.results.Result;
import javacamp.hrms.core.utilities.results.SuccessDataResult;
import javacamp.hrms.core.utilities.results.SuccessResult;
import javacamp.hrms.dataAccess.abstracts.CvSoftwareLangDao;
import javacamp.hrms.entities.concretes.CvSoftwareLang;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CvSoftwareLangManager implements CvSoftwareLangService {

    private CvSoftwareLangDao cvSoftwareLangDao;

    @Autowired
    public CvSoftwareLangManager(CvSoftwareLangDao cvSoftwareLangDao) {
        this.cvSoftwareLangDao = cvSoftwareLangDao;
    }

    @Override
    public Result add(CvSoftwareLang cvSoftwareLang) {

        this.cvSoftwareLangDao.save(cvSoftwareLang);
        return new SuccessResult();
    }

    @Override
    public DataResult<List<CvSoftwareLang>> getAllByEmployeeCv_Employee_EmployeeId(int id) {
        return new SuccessDataResult<>(this.cvSoftwareLangDao.getAllByEmployeeCv_Employee_EmployeeId(id));
    }
}
