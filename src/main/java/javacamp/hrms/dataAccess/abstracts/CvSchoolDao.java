package javacamp.hrms.dataAccess.abstracts;

import javacamp.hrms.entities.concretes.CvSchool;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CvSchoolDao extends JpaRepository<CvSchool,Integer> {
}
