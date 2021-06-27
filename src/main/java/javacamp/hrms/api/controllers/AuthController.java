package javacamp.hrms.api.controllers;


import javacamp.hrms.business.abstracts.AuthService;
import javacamp.hrms.core.utilities.results.ErrorDataResult;
import javacamp.hrms.entities.concretes.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.HashMap;
import java.util.Map;

@CrossOrigin
@RestController
@RequestMapping("/api/auth")
public class AuthController {

    private AuthService authService;

    @Autowired
    public AuthController(AuthService authService) {
        this.authService = authService;
    }


    @PostMapping("/registerEmployee")
    public ResponseEntity<?> registerEmployee(@Valid @RequestBody EmployeeForRegister employeeForRegister){

        return ResponseEntity.ok(this.authService.registerEmployee(employeeForRegister));
    }

    @PostMapping( "/registerEmployer")
    public ResponseEntity<?> registerEmployer(@Valid @RequestBody EmployerForRegister employerForRegister){

        return ResponseEntity.ok(this.authService.registerEmployer(employerForRegister));
    }

    @PostMapping( "/registerPersonel")
    public ResponseEntity<?> registerPersonel(@Valid @RequestBody Personel personel){

        return ResponseEntity.ok(this.authService.registerPersonel(personel));
    }


   @PostMapping( "/loginForEmployee")
    public ResponseEntity<?> loginForEmployee(@RequestBody EmployeeForLogin employeeForLogin){
        return ResponseEntity.ok(this.authService.loginEmployee(employeeForLogin));

    }
    @PostMapping( "/loginForEmployer")
    public ResponseEntity<?> loginForEmployer(@RequestBody EmployerForLogin employerForLogin){
            return ResponseEntity.ok(this.authService.loginEmployer(employerForLogin));
        }

    @PostMapping( "/loginForPersonel")
    public ResponseEntity<?> loginForPersonel(@RequestBody PersonelForLogin personelForLogin){
        return ResponseEntity.ok(this.authService.loginPersonel(personelForLogin));
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
