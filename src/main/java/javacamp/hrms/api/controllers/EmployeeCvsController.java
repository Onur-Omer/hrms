package javacamp.hrms.api.controllers;

import com.cloudinary.Cloudinary;
import javacamp.hrms.business.abstracts.EmployeeCvService;
import javacamp.hrms.business.abstracts.EmployeeService;
import javacamp.hrms.core.utilities.results.DataResult;
import javacamp.hrms.core.utilities.results.Result;
import javacamp.hrms.entities.concretes.EmployeeCv;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@RestController
@RequestMapping(name = "/api/employeeCvs")
public class EmployeeCvsController {

    private EmployeeService employeeService;
    private EmployeeCvService employeeCvService;

    @Autowired
    public EmployeeCvsController(EmployeeService employeeService, EmployeeCvService employeeCvService) {
        this.employeeService = employeeService;
        this.employeeCvService = employeeCvService;
    }

    @GetMapping(value = "/getAllByEmployeeEmail")
    public DataResult<List<EmployeeCv>> getAllByEmployee_Email(@RequestParam String email){
        return this.employeeCvService.getAllByEmployee_Email(email);
    }

    @PostMapping(value = "/addCv")
    public Result add(@Valid @RequestBody EmployeeCv employeeCv){
        return this.employeeCvService.add(employeeCv);
    }

}
