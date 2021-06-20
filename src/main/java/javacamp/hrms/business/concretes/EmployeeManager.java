package javacamp.hrms.business.concretes;

import javacamp.hrms.business.abstracts.EmployeeService;
import javacamp.hrms.core.utilities.results.*;
import javacamp.hrms.dataAccess.abstracts.EmployeeDao;
import javacamp.hrms.entities.concretes.Employee;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class EmployeeManager implements EmployeeService {

    private EmployeeDao employeeDao;


    @Autowired
    public EmployeeManager(EmployeeDao employeeDao) {
        this.employeeDao = employeeDao;

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
        employeeDao.save(employee);
        return new SuccessResult("Eklendi");
    }

    @Override
    public DataResult<List<Employee>> getAll() {
        return new SuccessDataResult<List<Employee>>(employeeDao.findAll());
    }

    @Override
    public DataResult<Employee> getByEmployeeId(int id) {
        return new SuccessDataResult<Employee>(this.employeeDao.getByEmployeeId(id));
    }

    @Override
    public DataResult<Employee> getByEmail(String email) {
        return new SuccessDataResult<Employee>(this.employeeDao.getByEmail(email));
    }


}
