package javacamp.hrms.business.abstracts;

import javacamp.hrms.core.utilities.results.DataResult;
import javacamp.hrms.core.utilities.results.Result;
import javacamp.hrms.entities.concretes.ConfirmationByStaffForJobAd;

import java.util.List;

public interface ConfirmationByStaffForJobAdService {
    DataResult<List<ConfirmationByStaffForJobAd>> getAllNotConfirmed();
    Result confirme(int id);
}
