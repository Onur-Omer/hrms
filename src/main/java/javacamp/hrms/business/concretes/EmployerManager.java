package javacamp.hrms.business.concretes;

import javacamp.hrms.business.abstracts.EmployerService;
import javacamp.hrms.business.abstracts.JobAdService;
import javacamp.hrms.core.utilities.EmailValidation.EmailValidation;
import javacamp.hrms.core.utilities.results.*;
import javacamp.hrms.dataAccess.abstracts.EmployerDao;
import javacamp.hrms.entities.concretes.Employer;
import javacamp.hrms.entities.concretes.JobAd;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class EmployerManager implements EmployerService {

    private EmployerDao employerDao;
    private EmailValidation emailValidation;
    private JobAdService jobAdService;

    @Autowired
    public EmployerManager(EmployerDao employerDao, EmailValidation emailValidation, JobAdService jobAdService) {
        this.employerDao = employerDao;
        this.emailValidation = emailValidation;
        this.jobAdService = jobAdService;
    }

    @Override
    public Result signIn(Employer employer) {

        if(employer.getCompanyName().isEmpty()||
            employer.getEmail().isEmpty()||
                employer.getPassword().isEmpty()||
                employer.getWebsite().isEmpty()||
                employer.getPhone().isEmpty()
        ){
            return new ErrorResult("Eksik bilgi var");
        }


        if(employerDao.findByEmail(employer.getEmail())){
            return new ErrorResult("Var olan kullanıcı");
        }

        if (!emailValidation.validate(employer.getEmail())){
            return new ErrorResult("Email onaylanmadı");
        }

        employerDao.save(employer);

        return new SuccessResult("Eklendi");
    }

    @Override
    public DataResult<List<Employer>> getAll() {
        return new SuccessDataResult<List<Employer>>(employerDao.findAll());
    }

    @Override
    public Result addJobAd(JobAd jobAd) {
        this.jobAdService.add(jobAd);
        return new SuccessResult();
    }
}
