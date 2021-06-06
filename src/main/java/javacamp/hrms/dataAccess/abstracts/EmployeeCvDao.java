package javacamp.hrms.dataAccess.abstracts;

import javacamp.hrms.entities.concretes.EmployeeCv;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface EmployeeCvDao extends JpaRepository<EmployeeCv,Integer> {
    List<EmployeeCv> getAllByEmployee_Email(String email);
}
