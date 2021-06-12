package javacamp.hrms.api.controllers;

import javacamp.hrms.business.abstracts.CvSchoolService;
import javacamp.hrms.core.utilities.results.DataResult;
import javacamp.hrms.core.utilities.results.Result;
import javacamp.hrms.entities.concretes.CvSchool;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/cvSchools")
public class CvSchoolsController {
    private CvSchoolService cvSchoolService;

    @Autowired
    public CvSchoolsController(CvSchoolService cvSchoolService) {
        this.cvSchoolService = cvSchoolService;
    }

    @PostMapping("/add")
    public Result add(@RequestBody CvSchool cvSchool) {
        return this.cvSchoolService.add(cvSchool);
    }

    @GetMapping("/getAllByEmployeeCv_Employee_EmployeeIdOrderByStartDateAsc")
    public DataResult<List<CvSchool>> getAllByEmployeeCv_Employee_EmployeeIdOrderByStartDateAsc(int id){
        return this.cvSchoolService.getAllByEmployeeCv_Employee_EmployeeIdOrderByStartDateAsc(id);
    }
}
