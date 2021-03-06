package javacamp.hrms.api.controllers;

import javacamp.hrms.business.abstracts.CvExperianceService;
import javacamp.hrms.core.utilities.results.DataResult;
import javacamp.hrms.core.utilities.results.Result;
import javacamp.hrms.entities.concretes.CvExperiance;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@CrossOrigin
@RestController
@RequestMapping("/api/cvExperiances")
public class CvExperiancesController {
    private CvExperianceService cvExperianceService;

    @Autowired
    public CvExperiancesController(CvExperianceService cvExperianceService) {
        this.cvExperianceService = cvExperianceService;
    }

    @PostMapping("/add")
    public Result add(@RequestBody CvExperiance cvExperiance,@RequestParam int cvId){
        return this.cvExperianceService.add(cvExperiance,cvId);
    }

    @PostMapping("/delete")
    public Result delete(@RequestParam int id){
        return this.cvExperianceService.delete(id);
    }

    @GetMapping("/getAllByEmployeeCv_Employee_EmployeeIdOrderByFinishDateDesc")
    public DataResult<List<CvExperiance>> getAllByEmployeeCv_Employee_EmployeeIdOrderByFinishDateDesc(@RequestParam int id){
        return this.cvExperianceService.getAllByEmployeeCv_Employee_EmployeeIdOrderByFinishDateDesc(id);
    }

    @GetMapping("/getAllByEmployeeCv_EmployeeCvId")
    public DataResult<List<CvExperiance>> getAllByEmployeeCv_EmployeeCvId(@RequestParam int id){
        return this.cvExperianceService.getAllByEmployeeCv_EmployeeCvId(id);
    }
}
