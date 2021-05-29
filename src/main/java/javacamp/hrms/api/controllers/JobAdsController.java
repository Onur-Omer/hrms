package javacamp.hrms.api.controllers;


import javacamp.hrms.business.abstracts.JobAdService;
import javacamp.hrms.core.utilities.results.DataResult;
import javacamp.hrms.core.utilities.results.Result;
import javacamp.hrms.entities.concretes.Employer;
import javacamp.hrms.entities.concretes.JobAd;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.Date;
import java.util.List;

@RestController
@RequestMapping(name = "/api/jobads")
public class JobAdsController {

    private JobAdService jobAdService;

    @Autowired
    public JobAdsController(JobAdService jobAdService) {
        this.jobAdService = jobAdService;
    }

    @GetMapping("/getallbyemployerid")
    public DataResult<List<JobAd>> getAllByEmployerId(@RequestParam int employerId){
        return this.jobAdService.getAllByEmployerId(employerId);
    }

    @GetMapping("/getallbycity")
    public DataResult<List<JobAd>> getAllByCity(@RequestParam String city){
        return this.jobAdService.getAllByCity(city);
    }

    @GetMapping("/getallbypositionid")
    public DataResult<List<JobAd>> getAllByPositionId(@RequestParam int positionId){
        return this.jobAdService.getAllByPositionId(positionId);
    }

    @GetMapping("/getallbylastdate")
    public DataResult<List<JobAd>> getAllByLastDate(@RequestParam Date date){
        return this.jobAdService.getAllByLastDate(date);
    }
}
