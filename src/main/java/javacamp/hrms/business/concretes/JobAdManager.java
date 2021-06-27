package javacamp.hrms.business.concretes;

import javacamp.hrms.business.abstracts.CityService;
import javacamp.hrms.business.abstracts.EmployerService;
import javacamp.hrms.business.abstracts.JobAdService;
import javacamp.hrms.business.abstracts.PositionService;
import javacamp.hrms.core.utilities.results.DataResult;
import javacamp.hrms.core.utilities.results.Result;
import javacamp.hrms.core.utilities.results.SuccessDataResult;
import javacamp.hrms.core.utilities.results.SuccessResult;
import javacamp.hrms.dataAccess.abstracts.JobAdDao;
import javacamp.hrms.entities.concretes.JobAd;
import javacamp.hrms.entities.concretes.JobAdForAdd;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class JobAdManager implements JobAdService {

    private JobAdDao jobAdDao;
    private EmployerService employerService;
    private PositionService positionService;
    private CityService cityService;

    @Autowired
    public JobAdManager(JobAdDao jobAdDao, EmployerService employerService, PositionService positionService, CityService cityService) {
        this.jobAdDao = jobAdDao;
        this.employerService = employerService;
        this.positionService = positionService;
        this.cityService = cityService;
    }

    @Override
    public Result add(JobAdForAdd jobAdForAdd) {
        JobAd jobAd=new JobAd();
        jobAd.setTitle(jobAdForAdd.getTitle());
        jobAd.setDescription(jobAdForAdd.getDescription());
        jobAd.setMaxSalary(jobAdForAdd.getMaxSalary());
        jobAd.setMinSalary(jobAdForAdd.getMinSalary());
        jobAd.setNumberOfEmployee(jobAdForAdd.getNumberOfEmployee());
        jobAd.setLastDate(jobAdForAdd.getLastDate());
        jobAd.setFirstDate(jobAdForAdd.getFirstDate());
        jobAd.setActive(true);
        jobAd.setEmployer(employerService.getByEmployerId(jobAdForAdd.getEmployerId()).getData());
        jobAd.setCity(cityService.getByCityId(jobAdForAdd.getCityId()).getData());
        jobAd.setPosition(positionService.getByPositionId(jobAdForAdd.getPositionId()).getData());

        jobAdDao.save(jobAd);
        return new SuccessResult();
    }

    @Override
    public Result updateActive(int jobAdId) {
        JobAd jobAd=this.jobAdDao.getByJobAdId(jobAdId);
        jobAd.setActive(!jobAd.isActive());
        this.jobAdDao.save(jobAd);
        return new SuccessResult();
    }


    @Override
    public DataResult<List<JobAd>> getAll() {
        return new SuccessDataResult<List<JobAd>>(this.jobAdDao.findAll());
    }

    @Override
    public DataResult<List<JobAd>> getAllByEmployer_EmployerId(int id) {
        return new SuccessDataResult<List<JobAd>>(this.jobAdDao.getAllByEmployer_EmployerId(id));
    }

    @Override
    public DataResult<List<JobAd>> getAllByCity_CityId(int id) {
        return new SuccessDataResult<List<JobAd>>(this.jobAdDao.getAllByCity_CityId(id));
    }

    @Override
    public DataResult<List<JobAd>> getAllByPosition_PositionId(int id) {
        return new SuccessDataResult<List<JobAd>>(this.jobAdDao.getAllByPosition_PositionId(id));
    }

    @Override
    public DataResult<List<JobAd>> getAllByLastDate(String date) {
        return new SuccessDataResult<List<JobAd>>(this.jobAdDao.getAllByLastDate(date));
    }

    @Override
    public DataResult<JobAd> getByJobAdId(int id) {
        return new SuccessDataResult<JobAd>(this.jobAdDao.getByJobAdId(id));
    }

}
