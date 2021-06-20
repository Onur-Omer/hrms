package javacamp.hrms.api.controllers;


import javacamp.hrms.business.abstracts.JobAdService;
import javacamp.hrms.core.utilities.results.DataResult;
import javacamp.hrms.core.utilities.results.Result;
import javacamp.hrms.core.utilities.results.SuccessResult;
import javacamp.hrms.entities.concretes.JobAd;
import javacamp.hrms.entities.dtos.JobAdForAdd;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.time.LocalDate;
import java.util.Date;
import java.util.List;

@CrossOrigin
@RestController
@RequestMapping("/api/jobAds")
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

    @GetMapping( "/getAllByEmployer_EmployerId")
    public DataResult<List<JobAd>> getAllByEmployer_EmployerId(@RequestParam int id){
        return this.jobAdService.getAllByEmployer_EmployerId(id);
    }

    @GetMapping("/getAllByCity_CityId")
    public DataResult<List<JobAd>> getAllByCity_CityId(@RequestParam int id){
        return this.jobAdService.getAllByCity_CityId(id);
    }

    @GetMapping("/getAllByPosition_PositionId")
    public DataResult<List<JobAd>> getAllByPosition_PositionId(@RequestParam int id){
        return this.jobAdService.getAllByPosition_PositionId(id);
    }

    @GetMapping( "/getAllByLastDate")
    public DataResult<List<JobAd>> getAllByLastDate(@RequestParam String date){
        return this.jobAdService.getAllByLastDate(date);
    }

    @PostMapping("/addJobAd")
    public Result add(@Valid @RequestBody JobAdForAdd jobAdForAdd){
        this.jobAdService.add(jobAdForAdd);
        return new SuccessResult();
    }

    @PostMapping( "/updateActive")
    public Result updateActive(@Valid @RequestParam int id){
        this.jobAdService.updateActive(id);
        return new SuccessResult();
    }
}
