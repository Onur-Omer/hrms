package javacamp.hrms.api.controllers;

import javacamp.hrms.business.abstracts.ConfirmationByStaffForJobAdService;
import javacamp.hrms.core.utilities.results.DataResult;
import javacamp.hrms.core.utilities.results.Result;
import javacamp.hrms.entities.concretes.ConfirmationByStaffForJobAd;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@CrossOrigin
@RestController
@RequestMapping("/api/confirmationByStaffForJobAds")
public class ConfirmationByStaffForJobAdsController {
    private ConfirmationByStaffForJobAdService confirmationByStaffForJobAdService;

    @Autowired
    public ConfirmationByStaffForJobAdsController(ConfirmationByStaffForJobAdService confirmationByStaffForJobAdService) {
        this.confirmationByStaffForJobAdService = confirmationByStaffForJobAdService;
    }

    @GetMapping("/getAllNotConfirmed")
    public DataResult<List<ConfirmationByStaffForJobAd>> getAllNotConfirmed(){
        return this.confirmationByStaffForJobAdService.getAllNotConfirmed();
    }

    @PostMapping("/confirme")
    public Result confirme(@RequestParam int id){
        return this.confirmationByStaffForJobAdService.confirme(id);
    }
}
