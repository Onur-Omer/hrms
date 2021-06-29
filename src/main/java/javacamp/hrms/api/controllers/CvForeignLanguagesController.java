package javacamp.hrms.api.controllers;

import javacamp.hrms.business.abstracts.CvForeignLanguageService;
import javacamp.hrms.core.utilities.results.DataResult;
import javacamp.hrms.core.utilities.results.Result;
import javacamp.hrms.entities.concretes.CvExperiance;
import javacamp.hrms.entities.concretes.CvForeignLanguage;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@CrossOrigin
@RestController
@RequestMapping("/api/cvForeignLanguage")
public class CvForeignLanguagesController {

    private CvForeignLanguageService cvForeignLanguageService;

    @Autowired
    public CvForeignLanguagesController(CvForeignLanguageService cvForeignLanguageService) {
        this.cvForeignLanguageService = cvForeignLanguageService;
    }

    @PostMapping("/add")
    public Result add(@RequestBody CvForeignLanguage cvForeignLanguage,@RequestParam int cvId){
        return this.cvForeignLanguageService.add(cvForeignLanguage,cvId);
    }

    @GetMapping("/getAllByEmployeeCv_EmployeeCvId")
    public DataResult<List<CvForeignLanguage>> getAllByEmployeeCv_EmployeeCvId(@RequestParam int id){
        return this.cvForeignLanguageService.getAllByEmployeeCv_EmployeeCvId(id);
    }

    @GetMapping("/getAllByEmployeeCv_Employee_EmployeeId")
    public DataResult<List<CvForeignLanguage>> getAllByEmployeeCv_Employee_EmployeeId(int id){
        return this.cvForeignLanguageService.getAllByEmployeeCv_Employee_EmployeeId(id);
    }
}
