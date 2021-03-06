package javacamp.hrms.business.concretes;

import javacamp.hrms.business.abstracts.CvSoftwareLangService;
import javacamp.hrms.business.abstracts.EmployeeCvService;
import javacamp.hrms.core.utilities.results.DataResult;
import javacamp.hrms.core.utilities.results.Result;
import javacamp.hrms.core.utilities.results.SuccessDataResult;
import javacamp.hrms.core.utilities.results.SuccessResult;
import javacamp.hrms.dataAccess.abstracts.CvSoftwareLangDao;
import javacamp.hrms.entities.concretes.CvSoftwareLang;
import javacamp.hrms.entities.concretes.EmployeeCv;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CvSoftwareLangManager implements CvSoftwareLangService {

    private EmployeeCvService employeeCvService;
    private CvSoftwareLangDao cvSoftwareLangDao;

    @Autowired
    public CvSoftwareLangManager(EmployeeCvService employeeCvService, CvSoftwareLangDao cvSoftwareLangDao) {
        this.employeeCvService = employeeCvService;
        this.cvSoftwareLangDao = cvSoftwareLangDao;
    }

    @Override
    public Result add(CvSoftwareLang cvSoftwareLang,int cvId) {
        EmployeeCv employeeCv =this.employeeCvService.getByEmployeeCvId(cvId).getData();
        cvSoftwareLang.setEmployeeCv(employeeCv);
        this.cvSoftwareLangDao.save(cvSoftwareLang);
        return new SuccessResult();
    }

    @Override
    public Result addAll(List<CvSoftwareLang> cvSoftwareLang) {
        this.cvSoftwareLangDao.saveAll(cvSoftwareLang);
        return new SuccessResult();
    }

    @Override
    public DataResult<List<CvSoftwareLang>> getAllByEmployeeCv_Employee_EmployeeId(int id) {
        return new SuccessDataResult<>(this.cvSoftwareLangDao.getAllByEmployeeCv_Employee_EmployeeId(id));
    }

    @Override
    public DataResult<List<CvSoftwareLang>> getAllByEmployeeCv_EmployeeCvId(int id) {
        return new SuccessDataResult<>(this.cvSoftwareLangDao.getAllByEmployeeCv_EmployeeCvId(id));
    }

    @Override
    public Result delete(int id) {
        this.cvSoftwareLangDao.deleteById(id);
        return new SuccessResult();
    }
}
