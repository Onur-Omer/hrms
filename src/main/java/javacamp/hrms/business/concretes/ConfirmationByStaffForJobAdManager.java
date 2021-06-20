package javacamp.hrms.business.concretes;

import javacamp.hrms.business.abstracts.ConfirmationByStaffForJobAdService;
import javacamp.hrms.core.utilities.results.DataResult;
import javacamp.hrms.core.utilities.results.Result;
import javacamp.hrms.core.utilities.results.SuccessDataResult;
import javacamp.hrms.core.utilities.results.SuccessResult;
import javacamp.hrms.dataAccess.abstracts.ConfirmationByStaffForJobAdDao;
import javacamp.hrms.entities.concretes.ConfirmationByStaffForJobAd;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ConfirmationByStaffForJobAdManager implements ConfirmationByStaffForJobAdService {

    private ConfirmationByStaffForJobAdDao confirmationByStaffForJobAdDao;

    @Autowired
    public ConfirmationByStaffForJobAdManager(ConfirmationByStaffForJobAdDao confirmationByStaffForJobAdDao) {
        this.confirmationByStaffForJobAdDao = confirmationByStaffForJobAdDao;
    }

    @Override
    public DataResult<List<ConfirmationByStaffForJobAd>> getAllNotConfirmed() {
        return new SuccessDataResult<>(this.confirmationByStaffForJobAdDao.getAllByIsConfirmed(false));
    }

    @Override
    public Result confirme(int id) {

        ConfirmationByStaffForJobAd temp=this.confirmationByStaffForJobAdDao.getByConfirmationByStaffForJobAdId(id);
        temp.setConfirmed(true);
        this.confirmationByStaffForJobAdDao.save(temp);

        return new SuccessResult();
    }
}
