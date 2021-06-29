package javacamp.hrms.api.controllers;


import javacamp.hrms.business.abstracts.CvSoftwareLangService;
import javacamp.hrms.core.utilities.results.DataResult;
import javacamp.hrms.core.utilities.results.Result;
import javacamp.hrms.entities.concretes.CvExperiance;
import javacamp.hrms.entities.concretes.CvSoftwareLang;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@CrossOrigin
@RestController
@RequestMapping("/api/cvSoftwareLangs")
public class CvSoftwareLangController {
    private CvSoftwareLangService cvSoftwareLangService;


    @Autowired
    public CvSoftwareLangController(CvSoftwareLangService cvSoftwareLangService) {
        this.cvSoftwareLangService = cvSoftwareLangService;
    }

    @GetMapping("getAllByEmployeeCv_Employee_EmployeeId")
    public DataResult<List<CvSoftwareLang>> getAllByEmployeeCv_Employee_EmployeeId(int id){
        return this.cvSoftwareLangService.getAllByEmployeeCv_Employee_EmployeeId(id);
    }

    @GetMapping("/getAllByEmployeeCv_EmployeeCvId")
    public DataResult<List<CvSoftwareLang>> getAllByEmployeeCv_EmployeeCvId(@RequestParam int id){
        return this.cvSoftwareLangService.getAllByEmployeeCv_EmployeeCvId(id);
    }

    @PostMapping("/add")
    public Result add(@RequestBody CvSoftwareLang cvSoftwareLang,@RequestParam int cvId){
        return this.cvSoftwareLangService.add(cvSoftwareLang,cvId);
    }
}
