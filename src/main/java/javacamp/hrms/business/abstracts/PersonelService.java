package javacamp.hrms.business.abstracts;

import javacamp.hrms.core.utilities.results.Result;
import javacamp.hrms.entities.concretes.Personel;

public interface PersonelService {
    Result add(Personel personel);

}
