package javacamp.hrms.api.controllers;

import javacamp.hrms.business.abstracts.ConfirmationByStaffForEmployerService;
import javacamp.hrms.core.utilities.results.DataResult;
import javacamp.hrms.core.utilities.results.Result;
import javacamp.hrms.entities.concretes.ConfirmationByStaffForEmployer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@CrossOrigin
@RestController
@RequestMapping("/api/confirmationByStaffForEmployers")
public class ConfirmationByStaffForEmployersController {
    private ConfirmationByStaffForEmployerService confirmationByStaffForEmployerService;

    @Autowired
    public ConfirmationByStaffForEmployersController(ConfirmationByStaffForEmployerService confirmationByStaffForEmployerService) {
        this.confirmationByStaffForEmployerService = confirmationByStaffForEmployerService;
    }



    @GetMapping("/getAllNotConfirmed")
    public DataResult<List<ConfirmationByStaffForEmployer>> getAllNotConfirmed(){
        return this.confirmationByStaffForEmployerService.getAllNotConfirmed();
    }

    @PostMapping("/confirme")
    public Result confirme(@RequestParam int id){
       return  this.confirmationByStaffForEmployerService.confirme(id);
    }

}
