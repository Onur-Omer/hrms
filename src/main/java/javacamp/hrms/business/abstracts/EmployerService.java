package javacamp.hrms.business.abstracts;

import javacamp.hrms.core.utilities.results.DataResult;
import javacamp.hrms.core.utilities.results.Result;
import javacamp.hrms.entities.concretes.Employer;

import java.util.List;

public interface EmployerService {
    Result signIn(Employer employer);
    DataResult<List<Employer>> getAll();
}