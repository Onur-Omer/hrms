package javacamp.hrms.dataAccess.abstracts;

import javacamp.hrms.entities.concretes.CvExperiance;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CvExperianceDao extends JpaRepository<CvExperiance,Integer> {
}
