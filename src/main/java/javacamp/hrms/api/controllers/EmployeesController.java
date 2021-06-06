package javacamp.hrms.api.controllers;

import javacamp.hrms.business.abstracts.EmployeeService;
import javacamp.hrms.core.utilities.results.DataResult;
import javacamp.hrms.entities.concretes.Employee;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping(name = "/api/employees")
public class EmployeesController {

    private EmployeeService employeeService;

    @Autowired
    public EmployeesController(EmployeeService employeeService) {
        this.employeeService = employeeService;
    }

    @GetMapping(value = "/getAllEmployees")
    public DataResult<List<Employee>> getAll(){
        return this.employeeService.getAll();
    }

    @GetMapping(value = "/getByEmailEmployee")
    public DataResult<Employee> getByEmail(@RequestParam String email){
        return this.employeeService.getByEmail(email);
    }

}
