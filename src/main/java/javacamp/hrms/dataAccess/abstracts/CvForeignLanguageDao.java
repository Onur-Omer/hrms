package javacamp.hrms.dataAccess.abstracts;

import javacamp.hrms.entities.concretes.CvForeignLanguage;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CvForeignLanguageDao extends JpaRepository<CvForeignLanguage,Integer> {
}
