package com.cromocoder.javamvctwo.controller;

import com.cromocoder.javamvctwo.model.EmployeesModel;
import com.cromocoder.javamvctwo.service.EmployeesService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/v1")
public class EmployeesController {
    private final EmployeesService employeesService;
    @Autowired
    public EmployeesController(EmployeesService employeesService) {
        this.employeesService = employeesService;
    }
    @PostMapping("/create")
    public ResponseEntity<String> createEmployee(@RequestBody EmployeesModel employeesModel){
        return employeesService.createEmployee(employeesModel);
    }
    @GetMapping("/fetch")
    public ResponseEntity<List<EmployeesModel>> getAllEmployee(){
        return  employeesService.getAllEmployee();
    }
    @GetMapping("/fetch/{Id}")
    public ResponseEntity<Optional<EmployeesModel>> getEmployee(@PathVariable(name = "Id") Long Id){
        return  employeesService.getEmployee(Id);
    }
    @PutMapping("/update/{Id}")
    public ResponseEntity<Optional<String>> updateEmployee(@PathVariable(name = "Id") Long Id, @RequestBody EmployeesModel employeesModel){
        return  employeesService.updateEmployee(Id, employeesModel);
    }
    @DeleteMapping("/delete/{Id}")
    public ResponseEntity<Optional<String>> deleteEmployee(@PathVariable(name = "Id") Long Id){
        return  employeesService.deleteEmployee(Id);
    }
}
