package javacamp.hrms.business.concretes;

import javacamp.hrms.business.abstracts.EmployeeCvService;
import javacamp.hrms.core.utilities.results.DataResult;
import javacamp.hrms.core.utilities.results.Result;
import javacamp.hrms.core.utilities.results.SuccessDataResult;
import javacamp.hrms.core.utilities.results.SuccessResult;
import javacamp.hrms.dataAccess.abstracts.EmployeeCvDao;
import javacamp.hrms.entities.concretes.EmployeeCv;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class EmployeeCvManager implements EmployeeCvService {

    private EmployeeCvDao employeeCvDao;

    @Autowired
    public EmployeeCvManager(EmployeeCvDao employeeCvDao) {
        this.employeeCvDao = employeeCvDao;
    }

    @Override
    public DataResult<EmployeeCv> getByEmployee_Id(int id) {
        return new SuccessDataResult<EmployeeCv>(this.employeeCvDao.getByEmployee_Id(id));
    }

    @Override
    public Result add(EmployeeCv employeeCv) {
        this.employeeCvDao.save(employeeCv);
        return new SuccessResult("Eklendi");
    }
}
