package javacamp.hrms.dataAccess.abstracts;

import javacamp.hrms.entities.concretes.JobAd;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Date;
import java.util.List;

public interface JobAdDao extends JpaRepository<JobAd,Integer> {

    List<JobAd> getAllByEmployerEmail(String email);
    List<JobAd> getAllByCity(String city);
    List<JobAd> getAllByPosition_PositionName(String positionName);
    List<JobAd> getAllByLastDate(Date date);
    JobAd getById(int id);
}
