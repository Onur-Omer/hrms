package javacamp.hrms.business.abstracts;

import javacamp.hrms.core.utilities.results.DataResult;
import javacamp.hrms.core.utilities.results.Result;
import javacamp.hrms.entities.concretes.Position;

import javax.xml.crypto.Data;
import java.util.List;

public interface PositionService {
    DataResult<List<Position>> getall();
    Result add(Position position);
    DataResult<Position> getByPositionId(int id);

}

