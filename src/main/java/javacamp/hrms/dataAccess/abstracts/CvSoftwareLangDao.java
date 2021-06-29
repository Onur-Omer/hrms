package javacamp.hrms.dataAccess.abstracts;

import javacamp.hrms.entities.concretes.CvSoftwareLang;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface CvSoftwareLangDao extends JpaRepository<CvSoftwareLang,Integer> {
    List<CvSoftwareLang> getAllByEmployeeCv_Employee_EmployeeId(int id);
    List<CvSoftwareLang> getAllByEmployeeCv_EmployeeCvId(int id);
}
