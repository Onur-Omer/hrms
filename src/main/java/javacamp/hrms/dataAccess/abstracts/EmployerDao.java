package javacamp.hrms.dataAccess.abstracts;

import javacamp.hrms.entities.concretes.Employer;
import org.springframework.data.jpa.repository.JpaRepository;

public interface EmployerDao extends JpaRepository<Employer,Integer> {

    boolean findByEmail(String email);
    Employer getByEmployerId(int id);
    Employer getByEmail(String email);
}
