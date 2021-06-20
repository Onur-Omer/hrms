package javacamp.hrms.dataAccess.abstracts;

import javacamp.hrms.entities.concretes.ConfirmationByStaffForEmployer;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface ConfirmationByStaffForEmployerDao extends JpaRepository<ConfirmationByStaffForEmployer,Integer> {
    List<ConfirmationByStaffForEmployer> getAllByIsConfirmed(boolean confirmed);
    ConfirmationByStaffForEmployer getByConfirmationByStaffForEmployerId(int id);
}
