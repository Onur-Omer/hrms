package javacamp.hrms.dataAccess.abstracts;

import javacamp.hrms.entities.concretes.CvSoftwareLang;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CvSoftwareLangDao extends JpaRepository<CvSoftwareLang,Integer> {
}
