package javacamp.hrms.api.controllers;

import javacamp.hrms.business.abstracts.AuthService;
import javacamp.hrms.core.utilities.results.ErrorDataResult;
import javacamp.hrms.core.utilities.results.Result;
import javacamp.hrms.entities.dtos.EmployeeForRegister;
import javacamp.hrms.entities.dtos.EmployerForRegister;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.HashMap;
import java.util.Map;

@RestController
@RequestMapping(name = "/api/auth")
public class AuthController {

    private AuthService authService;

    @Autowired
    public AuthController(AuthService authService) {
        this.authService = authService;
    }

    @PostMapping(value = "/registerEmployee")
    public ResponseEntity<?> registerEmployee(@Valid @RequestBody EmployeeForRegister employeeForRegister){

        return ResponseEntity.ok(this.authService.registerEmployee(employeeForRegister));
    }

    @PostMapping(value = "/registerEmployer")
    public ResponseEntity<?> registerEmployer(@Valid @RequestBody EmployerForRegister employerForRegister){

        return ResponseEntity.ok(this.authService.registerEmployer(employerForRegister));
    }

    @ExceptionHandler(MethodArgumentNotValidException.class)
    @ResponseStatus(HttpStatus.BAD_REQUEST)
    public ErrorDataResult<Object> handleValidationException
            (MethodArgumentNotValidException exceptions){
        Map<String,String> validationErrors = new HashMap<String, String>();
        for(FieldError fieldError : exceptions.getBindingResult().getFieldErrors()) {
            validationErrors.put(fieldError.getField(), fieldError.getDefaultMessage());
        }

        ErrorDataResult<Object> errors
                = new ErrorDataResult<Object>(validationErrors,"Doğrulama hataları");
        return errors;
    }

}
