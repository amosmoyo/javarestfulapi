package com.cromocoder.javamvctwo.service;

import com.cromocoder.javamvctwo.model.EmployeesModel;
import org.springframework.http.ResponseEntity;

import java.util.List;
import java.util.Optional;

public interface EmployeesService {
    public ResponseEntity<String> createEmployee(EmployeesModel employeesModel);
    public ResponseEntity<Optional<EmployeesModel>> getEmployee(Long Id);
    public ResponseEntity<List<EmployeesModel>> getAllEmployee();
    public ResponseEntity<Optional<String>> updateEmployee(Long Id, EmployeesModel employeesModel);
    public ResponseEntity<Optional<String>> deleteEmployee(Long Id);
}
