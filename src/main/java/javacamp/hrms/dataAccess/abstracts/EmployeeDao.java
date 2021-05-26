package javacamp.hrms.dataAccess.abstracts;

import javacamp.hrms.entities.concretes.Employee;
import org.springframework.data.jpa.repository.JpaRepository;

public interface EmployeeDao extends JpaRepository<Employee,Integer> {

    boolean findByEmail(String email);
    boolean findByIdentityNumber(String identityNumber);
}
