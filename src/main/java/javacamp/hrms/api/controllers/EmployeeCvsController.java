package javacamp.hrms.api.controllers;

import javacamp.hrms.business.abstracts.EmployeeCvService;
import javacamp.hrms.business.abstracts.EmployeeService;
import javacamp.hrms.core.utilities.results.DataResult;
import javacamp.hrms.core.utilities.results.Result;
import javacamp.hrms.entities.concretes.EmployeeCv;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(name = "/api/employees")
public class EmployeeCvsController {

    private EmployeeService employeeService;
    private EmployeeCvService employeeCvService;

    @Autowired
    public EmployeeCvsController(EmployeeService employeeService) {
        this.employeeService = employeeService;
    }

    @GetMapping("/getByEmployeeId")
    public DataResult<EmployeeCv> getByEmployeeId(@RequestParam int id){
        return this.employeeCvService.getByEmployee_Id(id);
    }

    @PostMapping("/addCv")
    public Result add(@RequestBody EmployeeCv employeeCv){
        return this.employeeCvService.add(employeeCv);
    }

}
