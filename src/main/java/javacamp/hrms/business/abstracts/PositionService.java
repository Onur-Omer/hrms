package javacamp.hrms.business.abstracts;

import javacamp.hrms.core.utilities.results.DataResult;
import javacamp.hrms.core.utilities.results.Result;
import javacamp.hrms.entities.concretes.Position;

import java.util.List;

public interface PositionService {
    DataResult<List<Position>> getall();
    Result add(Position position);
}

