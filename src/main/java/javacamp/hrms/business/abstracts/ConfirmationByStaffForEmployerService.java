package javacamp.hrms.business.abstracts;

import javacamp.hrms.core.utilities.results.DataResult;
import javacamp.hrms.core.utilities.results.Result;
import javacamp.hrms.entities.concretes.ConfirmationByStaffForEmployer;

import java.util.List;

public interface ConfirmationByStaffForEmployerService {
    DataResult<List<ConfirmationByStaffForEmployer>> getAllNotConfirmed();
    Result confirme(int id);
}
