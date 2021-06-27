package javacamp.hrms.dataAccess.abstracts;

import javacamp.hrms.entities.concretes.Personel;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PersonelDao extends JpaRepository<Personel,Integer>{
    Personel getByPersonelId(int id);
    Personel getByEmail(String email);
}
