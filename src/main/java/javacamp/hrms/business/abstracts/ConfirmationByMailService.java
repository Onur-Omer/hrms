package javacamp.hrms.business.abstracts;

import javacamp.hrms.core.utilities.results.DataResult;
import javacamp.hrms.core.utilities.results.Result;
import javacamp.hrms.entities.concretes.ConfirmationByMail;

import java.util.List;

public interface ConfirmationByMailService {
    DataResult<List<ConfirmationByMail>> getAllNotConfirmed();
    Result confirme(int id);
}
