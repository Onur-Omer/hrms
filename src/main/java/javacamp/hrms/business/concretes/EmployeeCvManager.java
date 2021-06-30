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

import java.util.List;

@Service
public class EmployeeCvManager implements EmployeeCvService {

    private EmployeeCvDao employeeCvDao;

    @Autowired
    public EmployeeCvManager(EmployeeCvDao employeeCvDao) {
        this.employeeCvDao = employeeCvDao;
    }


    @Override
    public DataResult<List<EmployeeCv>> getAllByEmployee_EmployeeId(int id) {
        return new SuccessDataResult<>(this.employeeCvDao.getAllByEmployee_EmployeeId(id));
    }

    @Override
    public Result add(EmployeeCv employeeCv) {
        this.employeeCvDao.save(employeeCv);
        return new SuccessResult("Eklendi");
    }

    @Override
    public DataResult<EmployeeCv> getByEmployeeCvId(int id) {
        return new SuccessDataResult<>(this.employeeCvDao.getByEmployeeCvId(id));
    }

    @Override
    public Result delete(int id) {

        this.employeeCvDao.deleteById(id);
        return new SuccessResult();
    }
}
