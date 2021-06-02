package javacamp.hrms.dataAccess.abstracts;

import javacamp.hrms.entities.concretes.EmployeeCv;
import org.springframework.data.jpa.repository.JpaRepository;

public interface EmployeeCvDao extends JpaRepository<EmployeeCv,Integer> {
    EmployeeCv getByEmployee_Id(int id);
}
