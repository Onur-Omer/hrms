package javacamp.hrms.business.abstracts;

import javacamp.hrms.core.utilities.results.DataResult;
import javacamp.hrms.core.utilities.results.Result;
import javacamp.hrms.entities.concretes.JobAd;
import javacamp.hrms.entities.concretes.JobAdForAdd;

import java.util.List;

public interface JobAdService {

    Result add(JobAdForAdd jobAdForAdd);
    Result updateActive(int jobAdId);
    DataResult<List<JobAd>> getAll();
    DataResult<List<JobAd>> getAllByEmployer_EmployerId(int id);
    DataResult<List<JobAd>> getAllByCity_CityId(int id);
    DataResult<List<JobAd>> getAllByPosition_PositionId(int id);
    DataResult<List<JobAd>> getAllByLastDate(String date);
    DataResult<JobAd> getByJobAdId(int id);
}
