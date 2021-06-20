package javacamp.hrms.dataAccess.abstracts;



import javacamp.hrms.entities.concretes.ConfirmationByStaffForJobAd;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface ConfirmationByStaffForJobAdDao extends JpaRepository<ConfirmationByStaffForJobAd,Integer> {
    List<ConfirmationByStaffForJobAd> getAllByIsConfirmed(boolean confirmed);
    ConfirmationByStaffForJobAd getByConfirmationByStaffForJobAdId(int id);
}
