package javacamp.hrms.dataAccess.abstracts;

import javacamp.hrms.entities.concretes.CvForeignLanguage;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface CvForeignLanguageDao extends JpaRepository<CvForeignLanguage,Integer> {
    List<CvForeignLanguage> getAllByEmployeeCv_Employee_EmployeeId(int id);
}
