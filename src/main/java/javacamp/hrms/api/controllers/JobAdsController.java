package javacamp.hrms.api.controllers;


import javacamp.hrms.business.abstracts.JobAdService;
import javacamp.hrms.core.utilities.results.DataResult;
import javacamp.hrms.core.utilities.results.Result;
import javacamp.hrms.core.utilities.results.SuccessResult;
import javacamp.hrms.entities.concretes.JobAd;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.Date;
import java.util.List;

@RestController
@RequestMapping(name = "/api/jobAds")
public class JobAdsController {

    private JobAdService jobAdService;

    @Autowired
    public JobAdsController(JobAdService jobAdService) {
        this.jobAdService = jobAdService;
    }

    @GetMapping( "/getAllJobAds")
    public DataResult<List<JobAd>> getAll(){
        return this.jobAdService.getAll();
    }

    @GetMapping(value = "/getAllByEmployerEmail")
    public DataResult<List<JobAd>> getAllByEmployerEmail(@RequestParam String email){
        return this.jobAdService.getAllByEmployerEmail(email);
    }

    @GetMapping(value = "/getAllByCity")
    public DataResult<List<JobAd>> getAllByCity(@RequestParam String city){
        return this.jobAdService.getAllByCity(city);
    }

    @GetMapping(value = "/getAllByPositionName")
    public DataResult<List<JobAd>> getAllByPosition_PositionName(@RequestParam String positionName){
        return this.jobAdService.getAllByPosition_PositionName(positionName);
    }

    @GetMapping(value = "/getAllByLastDate")
    public DataResult<List<JobAd>> getAllByLastDate(@RequestParam Date date){
        return this.jobAdService.getAllByLastDate(date);
    }

    @PostMapping(value = "/addJobAd")
    public Result add(@Valid @RequestBody JobAd jobAd){
        this.jobAdService.add(jobAd);
        return new SuccessResult();
    }

    @PostMapping(value = "/updateActive")
    public Result updateActive(@Valid @RequestParam int id,@RequestParam boolean active){
        this.jobAdService.updateActive(id,active);
        return new SuccessResult();
    }
}
