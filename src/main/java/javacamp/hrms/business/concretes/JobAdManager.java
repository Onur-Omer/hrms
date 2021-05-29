package javacamp.hrms.business.concretes;

import javacamp.hrms.business.abstracts.JobAdService;
import javacamp.hrms.core.utilities.results.DataResult;
import javacamp.hrms.core.utilities.results.Result;
import javacamp.hrms.core.utilities.results.SuccessDataResult;
import javacamp.hrms.core.utilities.results.SuccessResult;
import javacamp.hrms.dataAccess.abstracts.JobAdDao;
import javacamp.hrms.entities.concretes.JobAd;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;

@Service
public class JobAdManager implements JobAdService {

    private JobAdDao jobAdDao;

    @Autowired
    public JobAdManager(JobAdDao jobAdDao) {
        this.jobAdDao = jobAdDao;
    }

    @Override
    public Result add(JobAd jobAd) {
        jobAdDao.save(jobAd);
        return new SuccessResult();
    }

    @Override
    public DataResult<List<JobAd>> getAll() {
        return new SuccessDataResult<List<JobAd>>(this.jobAdDao.findAll());
    }

    @Override
    public DataResult<List<JobAd>> getAllByEmployerId(int employerId) {
        return new SuccessDataResult<List<JobAd>>(this.jobAdDao.getAllByEmployerId(employerId));
    }

    @Override
    public DataResult<List<JobAd>> getAllByCity(String city) {
        return new SuccessDataResult<List<JobAd>>(this.jobAdDao.getAllByCity(city));
    }

    @Override
    public DataResult<List<JobAd>> getAllByPositionId(int positionId) {
        return new SuccessDataResult<List<JobAd>>(this.jobAdDao.getAllByPositionId(positionId));
    }

    @Override
    public DataResult<List<JobAd>> getAllByLastDate(Date date) {
        return new SuccessDataResult<List<JobAd>>(this.jobAdDao.getAllByLastDate(date));
    }
}
