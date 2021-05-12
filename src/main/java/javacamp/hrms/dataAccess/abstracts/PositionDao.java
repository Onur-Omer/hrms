package javacamp.hrms.dataAccess.abstracts;

import javacamp.hrms.entities.concretes.Position;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PositionDao extends JpaRepository<Position,Integer> {
}
