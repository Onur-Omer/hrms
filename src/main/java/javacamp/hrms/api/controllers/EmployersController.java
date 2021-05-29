package javacamp.hrms.api.controllers;

import javacamp.hrms.business.abstracts.EmployerService;
import javacamp.hrms.core.utilities.results.DataResult;
import javacamp.hrms.core.utilities.results.Result;
import javacamp.hrms.core.utilities.results.SuccessDataResult;
import javacamp.hrms.entities.concretes.Employer;
import javacamp.hrms.entities.concretes.JobAd;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(name = "/api/employers")
public class EmployersController {

    private EmployerService employerService;

    @Autowired
    public EmployersController(EmployerService employerService) {
        this.employerService = employerService;
    }

    @GetMapping("/getall")
    public DataResult<List<Employer>> getAll(){
        return this.employerService.getAll();
    }

    @PostMapping("/addjobad")
    public Result addJobAd(@RequestBody JobAd jobAd){
        return this.employerService.addJobAd(jobAd);
    }

    @PostMapping("/signin")
    public Result signIn(@RequestBody Employer employer){
        return this.employerService.signIn(employer);
    }

}
