package javacamp.hrms.business.concretes;

import javacamp.hrms.business.abstracts.ConfirmationByStaffForEmployerService;
import javacamp.hrms.business.abstracts.EmployerService;
import javacamp.hrms.core.utilities.results.DataResult;
import javacamp.hrms.core.utilities.results.Result;
import javacamp.hrms.core.utilities.results.SuccessDataResult;
import javacamp.hrms.dataAccess.abstracts.ConfirmationByStaffForEmployerDao;
import javacamp.hrms.entities.concretes.ConfirmationByStaffForEmployer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ConfirmationByStaffForEmployerManager implements ConfirmationByStaffForEmployerService {

    private ConfirmationByStaffForEmployerDao confirmationByStaffForEmployerDao;

    @Autowired
    public ConfirmationByStaffForEmployerManager(ConfirmationByStaffForEmployerDao confirmationByStaffForEmployerDao) {
        this.confirmationByStaffForEmployerDao = confirmationByStaffForEmployerDao;
    }

    @Override
    public DataResult<List<ConfirmationByStaffForEmployer>> getAllNotConfirmed() {
        return new SuccessDataResult<>(this.confirmationByStaffForEmployerDao.getAllByIsConfirmed(false));
    }

    @Override
    public Result confirme(int id) {

        ConfirmationByStaffForEmployer temp=this.confirmationByStaffForEmployerDao.getByConfirmationByStaffForEmployerId(id);
        temp.setConfirmed(true);
        this.confirmationByStaffForEmployerDao.save(temp);
        return null;
    }
}
