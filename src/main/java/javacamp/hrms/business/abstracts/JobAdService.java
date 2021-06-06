package javacamp.hrms.business.abstracts;

import javacamp.hrms.core.utilities.results.DataResult;
import javacamp.hrms.core.utilities.results.Result;
import javacamp.hrms.entities.concretes.JobAd;

import java.util.Date;
import java.util.List;

public interface JobAdService {

    Result add(JobAd jobAd);
    Result updateActive(int jobAdId,boolean active);
    DataResult<List<JobAd>> getAll();
    DataResult<List<JobAd>> getAllByEmployerEmail(String email);
    DataResult<List<JobAd>> getAllByCity(String city);
    DataResult<List<JobAd>> getAllByPosition_PositionName(String positionName);
    DataResult<List<JobAd>> getAllByLastDate(Date date);
}
