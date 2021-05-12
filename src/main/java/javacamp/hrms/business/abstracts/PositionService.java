package javacamp.hrms.business.abstracts;

import javacamp.hrms.entities.concretes.Position;

import java.util.List;

public interface PositionService {
    List<Position> getall();
}

