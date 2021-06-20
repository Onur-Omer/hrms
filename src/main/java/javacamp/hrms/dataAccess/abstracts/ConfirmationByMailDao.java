package javacamp.hrms.dataAccess.abstracts;

import javacamp.hrms.entities.concretes.ConfirmationByMail;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface ConfirmationByMailDao extends JpaRepository<ConfirmationByMail,Integer> {
    ConfirmationByMail getByConfirmationByMailId(int Id);
    ConfirmationByMail getByConfirmationCode(String eMail);
    List<ConfirmationByMail> getByIsConfirmed(boolean isConfirmed);
}
