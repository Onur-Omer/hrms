package javacamp.hrms.dataAccess.abstracts;

import javacamp.hrms.entities.concretes.CvExperiance;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface CvExperianceDao extends JpaRepository<CvExperiance,Integer> {
    List<CvExperiance> getAllByEmployeeCv_Employee_EmployeeIdOrderByFinishDateDesc(int id);
    List<CvExperiance> getAllByEmployeeCv_EmployeeCvId(int id);
}
