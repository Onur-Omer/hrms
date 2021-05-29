package javacamp.hrms.dataAccess.abstracts;

import javacamp.hrms.entities.concretes.JobAd;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Date;
import java.util.List;

public interface JobAdDao extends JpaRepository<JobAd,Integer> {

    List<JobAd> getAllByEmployerId(int employerId);
    List<JobAd> getAllByCity(String city);
    List<JobAd> getAllByPositionId(int positionId);
    List<JobAd> getAllByLastDate(Date date);
}
