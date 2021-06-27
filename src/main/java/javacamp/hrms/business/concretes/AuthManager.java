package javacamp.hrms.business.concretes;

import javacamp.hrms.business.abstracts.AuthService;
import javacamp.hrms.business.abstracts.EmployeeService;
import javacamp.hrms.business.abstracts.EmployerService;
import javacamp.hrms.business.abstracts.PersonelService;
import javacamp.hrms.core.utilities.results.DataResult;
import javacamp.hrms.core.utilities.results.Result;
import javacamp.hrms.core.utilities.results.SuccessDataResult;
import javacamp.hrms.core.utilities.results.SuccessResult;
import javacamp.hrms.entities.concretes.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class AuthManager implements AuthService {

    private EmployeeService employeeService;
    private EmployerService employerService;
    private PersonelService personelService;

    @Autowired
    public AuthManager(EmployeeService employeeService, EmployerService employerService, PersonelService personelService) {

        this.employeeService = employeeService;
        this.employerService = employerService;
        this.personelService = personelService;
    }

    @Override
    public Result registerEmployee(EmployeeForRegister employeeForRegister) {
        Employee employee= new Employee();
        employee.setFirstName(employeeForRegister.getFirstName());
        employee.setLastName(employeeForRegister.getLastName());
        employee.setIdentityNumber(employeeForRegister.getIdentityNumber());
        employee.setBirthday(employeeForRegister.getBirthday());
        employee.setEmail(employeeForRegister.getEmail());
        employee.setStatus(true);
        employee.setPassword(employeeForRegister.getPassword());

        this.employeeService.add(employee);
        return new SuccessResult();
    }

    @Override
    public Result registerEmployer(EmployerForRegister employerForRegister) {
        Employer employer= new Employer();
        employer.setCompanyName(employerForRegister.getCompanyName());
        employer.setWebsite(employerForRegister.getWebsite());
        employer.setPhone(employerForRegister.getPhone());
        employer.setEmail(employerForRegister.getEmail());
        employer.setPassword(employerForRegister.getPassword());
        employer.setStatus(true);

        this.employerService.add(employer);

        return new SuccessResult();
    }

    @Override
    public Result registerPersonel(Personel personel) {
        this.personelService.add(personel);
        return new SuccessResult();
    }

    @Override
    public DataResult<Employee> loginEmployee(EmployeeForLogin employeeForLogin) {
        DataResult<Employee> employee=employeeService.getByEmail(employeeForLogin.getEmail());
        if(employee==null){
            return new SuccessDataResult<>("Email Yok");
        }
        if(!employee.getData().getPassword().equals(employeeForLogin.getPassword())){
            return new SuccessDataResult<>("Parola Yanlış");
        }

        return new SuccessDataResult<Employee>(employee.getData());
    }

    @Override
    public DataResult<Employer> loginEmployer(EmployerForLogin employerForLogin) {
        DataResult<Employer> employer=employerService.getByEmail(employerForLogin.getEmail());
        if(employer==null){
            return new SuccessDataResult<>("Email Yok");
        }
        if(employer.getData().getPassword()!=employerForLogin.getPassword()){
            return new SuccessDataResult<>("Parola Yanlış");
        }

        return new SuccessDataResult<Employer>(employer.getData());
    }

    @Override
    public DataResult<Personel> loginPersonel(PersonelForLogin personelForLogin) {
        DataResult<Personel> personel=personelService.getByEmail(personelForLogin.getEmail());
        if(personel==null){
            return new SuccessDataResult<>("Email Yok");
        }
        if(personel.getData().getPassword()!=personelForLogin.getPassword()){
            return new SuccessDataResult<>("Parola Yanlış");
        }

        return new SuccessDataResult<Personel>(personel.getData());
    }

}
