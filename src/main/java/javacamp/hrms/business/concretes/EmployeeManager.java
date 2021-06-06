package javacamp.hrms.business.concretes;

import javacamp.hrms.business.abstracts.EmployeeService;
import javacamp.hrms.core.adapters.abstracts.MernisService;
import javacamp.hrms.core.utilities.EmailValidation.EmailValidation;
import javacamp.hrms.core.utilities.results.*;
import javacamp.hrms.dataAccess.abstracts.EmployeeCvDao;
import javacamp.hrms.dataAccess.abstracts.EmployeeDao;
import javacamp.hrms.entities.concretes.Employee;
import javacamp.hrms.entities.concretes.EmployeeCv;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class EmployeeManager implements EmployeeService {

    private EmployeeDao employeeDao;
    private MernisService mernisService;
    private EmailValidation emailValidation;

    @Autowired
    public EmployeeManager(EmployeeDao employeeDao, MernisService mernisService, EmailValidation emailValidation) {
        this.employeeDao = employeeDao;
        this.mernisService = mernisService;
        this.emailValidation = emailValidation;
    }

    @Override
    public Result add(Employee employee) {

        if(employee.getFirstName().isEmpty() ||
                employee.getEmail().isEmpty() ||
                employee.getBirthday().isEmpty() ||
                employee.getLastName().isEmpty() ||
                employee.getIdentityNumber().isEmpty() ||
                employee.getPassword().isEmpty())
        {
            return new ErrorResult("Eksik bilgi var");
        }

        if(!mernisService.checkRealUser(employee)){
            return new ErrorResult("Gerçek kişi değil");
        }

        if(employeeDao.findByIdentityNumber(employee.getIdentityNumber()) ||
                employeeDao.findByEmail(employee.getEmail()))
        {
            return new ErrorResult("Var olan kullanıcı");
        }

        if (!emailValidation.validate(employee.getEmail())){
            return new ErrorResult("Email onaylanmadı");
        }

        employeeDao.save(employee);
        return new SuccessResult("Eklendi");
    }

    @Override
    public DataResult<List<Employee>> getAll() {
        return new SuccessDataResult<List<Employee>>(employeeDao.findAll());
    }

    @Override
    public DataResult<Employee> getByEmail(String email) {
        return new SuccessDataResult<Employee>(this.employeeDao.getByEmail(email));
    }


}
