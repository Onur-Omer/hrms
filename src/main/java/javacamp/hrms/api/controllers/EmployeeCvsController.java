package javacamp.hrms.api.controllers;

import javacamp.hrms.business.abstracts.*;
import javacamp.hrms.core.utilities.results.DataResult;
import javacamp.hrms.core.utilities.results.Result;
import javacamp.hrms.entities.concretes.*;
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
        Employee employee=new Employee();
        EmployeeCv cv=employeeCv;
        List<CvExperiance> experiance=employeeCv.getExperiances();
        List<CvSoftwareLang> softwareLang=employeeCv.getLangs();
        List<CvSchool> school=employeeCv.getSchools();
        List<CvForeignLanguage> language=employeeCv.getForeignLanguages();

        employee=employeeService.getByEmployeeId(employeeId).getData();

        cv.setEmployee(employee);

        /*
        cv.setArticle(employeeCv.getArticle());
        cv.setActiveStatus(true);
        cv.setGithub(employeeCv.getGithub());
        cv.setLinkedln(employeeCv.getLinkedln());
        cv.setPhoto(employeeCv.getPhoto());
        */

        cvExperianceService.addAll(experiance);
        cvSchoolService.addAll(school);
        cvForeignLanguageService.addAll(language);
        cvSoftwareLangService.addAll(softwareLang);

        return this.employeeCvService.add(employeeCv);
    }

}
