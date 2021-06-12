package javacamp.hrms.core.adapters.concretes;

import javacamp.hrms.core.adapters.abstracts.MernisService;
import javacamp.hrms.entities.concretes.Employee;
import javacamp.hrms.mernis.AJSKPSPublicSoap;
import javacamp.hrms.mernis.AJSKPSPublicSoap12;
import org.springframework.stereotype.Service;

@Service
public class MernisAdapter implements MernisService {
    @Override
    public boolean checkRealUser(Employee employee) {

        AJSKPSPublicSoap client= new AJSKPSPublicSoap();
        try {
            return  client.TCKimlikNoDogrula(Long.valueOf(employee.getIdentityNumber())
                    ,employee.getFirstName()
                    ,employee.getLastName()
                    ,Integer.valueOf(employee.getBirthday()));
        } catch (Exception e) {
            e.printStackTrace();
            return false;
        }

    }
}
