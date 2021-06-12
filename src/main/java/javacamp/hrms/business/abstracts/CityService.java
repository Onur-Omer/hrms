package javacamp.hrms.business.abstracts;

import javacamp.hrms.core.utilities.results.DataResult;
import javacamp.hrms.entities.concretes.City;

import java.util.List;

public interface CityService {
    DataResult<City> getByCityId(int id);
    DataResult<List<City>> getAll();
}
