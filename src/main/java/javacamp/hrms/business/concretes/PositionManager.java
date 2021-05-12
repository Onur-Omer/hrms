package javacamp.hrms.business.concretes;

import javacamp.hrms.business.abstracts.PositionService;
import javacamp.hrms.dataAccess.abstracts.PositionDao;
import javacamp.hrms.entities.concretes.Position;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PositionManager implements PositionService {

    private PositionDao positionDao;

    @Autowired
    public PositionManager(PositionDao positionDao) {
        this.positionDao = positionDao;
    }

    @Override
    public List<Position> getall() {
        return positionDao.findAll();
    }
}
