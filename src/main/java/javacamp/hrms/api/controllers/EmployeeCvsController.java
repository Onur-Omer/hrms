package javacamp.hrms.api.controllers;

import javacamp.hrms.business.abstracts.*;
import javacamp.hrms.core.utilities.results.DataResult;
import javacamp.hrms.core.utilities.results.Result;
import javacamp.hrms.entities.concretes.EmployeeCv;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@CrossOrigin
@RestController
@RequestMapping("/api/employeeCvs")
public class EmployeeCvsController {

    private EmployeeService employeeService;
    private EmployeeCvService employeeCvService;
    private CvExperianceService cvExperianceService;
    private CvForeignLanguageService cvForeignLanguageService;
    private CvSchoolService cvSchoolService;
    private CvSoftwareLangService cvSoftwareLangService;

    @Autowired
    public EmployeeCvsController(EmployeeService employeeService, EmployeeCvService employeeCvService, CvExperianceService cvExperianceService, CvForeignLanguageService cvForeignLanguageService, CvSchoolService cvSchoolService, CvSoftwareLangService cvSoftwareLangService) {
        this.employeeService = employeeService;
        this.employeeCvService = employeeCvService;
        this.cvExperianceService = cvExperianceService;
        this.cvForeignLanguageService = cvForeignLanguageService;
        this.cvSchoolService = cvSchoolService;
        this.cvSoftwareLangService = cvSoftwareLangService;
    }

    @GetMapping( "/getAllByEmployee_EmployeeId")
    public DataResult<List<EmployeeCv>> getAllByEmployee_EmployeeId(@RequestParam int id){
        return this.employeeCvService.getAllByEmployee_EmployeeId(id);
    }

    @GetMapping("/getByEmployeeCvId")
    public DataResult<EmployeeCv> getByEmployeeCvId(int id){
        return this.employeeCvService.getByEmployeeCvId(id);
    }

    @PostMapping( "/add")
    public Result add(@Valid @RequestBody EmployeeCv employeeCv,@RequestParam int employeeId){
        employeeCv.setEmployee(employeeService.getByEmployeeId(employeeId).getData());
        cvExperianceService.add(employeeCv.getExperiances().get(0));
        return this.employeeCvService.add(employeeCv);
    }

}
