package javacamp.hrms.business.abstracts;

import javacamp.hrms.core.utilities.results.DataResult;
import javacamp.hrms.core.utilities.results.Result;
import javacamp.hrms.entities.concretes.JobAd;

import java.util.Date;
import java.util.List;

public interface JobAdService {

    Result add(JobAd jobAd);
    DataResult<List<JobAd>> getAll();
    DataResult<List<JobAd>> getAllByEmployerId(int employerId);
    DataResult<List<JobAd>> getAllByCity(String city);
    DataResult<List<JobAd>> getAllByPositionId(int positionId);
    DataResult<List<JobAd>> getAllByLastDate(Date date);
}
