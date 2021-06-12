package javacamp.hrms.api.controllers;

import javacamp.hrms.business.abstracts.EmployeeService;
import javacamp.hrms.core.utilities.results.DataResult;
import javacamp.hrms.core.utilities.results.ErrorDataResult;
import javacamp.hrms.entities.concretes.Employee;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/api/employees")
public class EmployeesController {

    private EmployeeService employeeService;

    @Autowired
    public EmployeesController(EmployeeService employeeService) {
        this.employeeService = employeeService;
    }



    @GetMapping("/getAllEmployees")
    public DataResult<List<Employee>> getAll(){
        return this.employeeService.getAll();
    }


    @GetMapping( "/getByEmployeeId")
    public DataResult<Employee> getByEmployee_id(@RequestParam int id){
        return this.employeeService.getByEmployeeId(id);
    }

}
