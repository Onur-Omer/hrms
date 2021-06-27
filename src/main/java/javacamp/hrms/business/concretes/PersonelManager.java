package javacamp.hrms.business.concretes;

import javacamp.hrms.business.abstracts.PersonelService;
import javacamp.hrms.core.utilities.results.DataResult;
import javacamp.hrms.core.utilities.results.Result;
import javacamp.hrms.core.utilities.results.SuccessDataResult;
import javacamp.hrms.core.utilities.results.SuccessResult;
import javacamp.hrms.dataAccess.abstracts.PersonelDao;
import javacamp.hrms.entities.concretes.Personel;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class PersonelManager implements PersonelService {

    private PersonelDao personelDao;

    @Autowired
    public PersonelManager(PersonelDao personelDao) {
        this.personelDao = personelDao;
    }

    @Override
    public Result add(Personel personel) {
        this.personelDao.save(personel);
        return new SuccessResult();
    }

    @Override
    public DataResult<Personel> getByPersonelId(int id) {
        return new SuccessDataResult<>(this.personelDao.getByPersonelId(id));
    }

    @Override
    public DataResult<Personel> getByEmail(String email) {
        return new SuccessDataResult<>(this.personelDao.getByEmail(email));
    }
}
