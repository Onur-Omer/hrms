package javacamp.hrms.dataAccess.abstracts;

import javacamp.hrms.entities.concretes.JobAd;
import org.springframework.data.jpa.repository.JpaRepository;

import java.time.LocalDate;
import java.util.List;

public interface JobAdDao extends JpaRepository<JobAd,Integer> {

    List<JobAd> getAllByEmployer_EmployerId(int id);
    List<JobAd> getAllByCity_CityId(int id);
    List<JobAd> getAllByPosition_PositionId(int id);
    List<JobAd> getAllByLastDate(LocalDate date);
    JobAd getByJobAdId(int id);
}
