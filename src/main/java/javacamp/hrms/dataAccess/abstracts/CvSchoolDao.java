package javacamp.hrms.dataAccess.abstracts;

import javacamp.hrms.entities.concretes.CvSchool;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface CvSchoolDao extends JpaRepository<CvSchool,Integer> {
    List<CvSchool> getAllByEmployeeCv_Employee_EmployeeIdOrderByStartDateAsc(int id);

}