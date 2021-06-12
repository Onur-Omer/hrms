package javacamp.hrms.dataAccess.abstracts;

import javacamp.hrms.entities.concretes.City;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CityDao extends JpaRepository<City,Integer> {
    City getByCityId(int id);
}
