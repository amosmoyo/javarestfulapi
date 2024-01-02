package com.cromocoder.javamvctwo.service.impl;

import com.cromocoder.javamvctwo.exceptions.GlobalExceptionHandler;
import com.cromocoder.javamvctwo.exceptions.NotFoundException;
import com.cromocoder.javamvctwo.model.EmployeesModel;
import com.cromocoder.javamvctwo.repository.EmployeesRepository;
import com.cromocoder.javamvctwo.service.EmployeesService;
import jakarta.persistence.EntityNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.function.Supplier;

@Service
public class EmployeesServiceImpl implements EmployeesService {
    private final EmployeesRepository employeesRepository;
    @Autowired
    public EmployeesServiceImpl(EmployeesRepository employeesRepository) {
        this.employeesRepository = employeesRepository;
    }
    @Override
    public ResponseEntity<String> createEmployee(EmployeesModel employeesModel) {
        try {
            employeesRepository.save(employeesModel);
            return ResponseEntity.ok("Success");
        } catch (Exception ex) {
            return ResponseEntity.internalServerError().build();
        }
    }
    @Override
    public ResponseEntity<Optional<EmployeesModel>> getEmployee(Long Id) {
        try {
            Optional<EmployeesModel> employee = employeesRepository.findById(Id);

            if (employee.isPresent()) {
                return ResponseEntity.ok(employee);
            } else {
                return ResponseEntity.notFound().build();
            }
        } catch (Exception ex) {
            return ResponseEntity.internalServerError().build();
        }
    }
    @Override
    public ResponseEntity<Optional<String>> updateEmployee(Long Id, EmployeesModel employeesModel) {
        try {
            EmployeesModel employee = employeesRepository.findById(Id)
                    .orElseThrow(() -> {
                        System.out.println("Employee not found. Throwing NotFoundException.");
                        return new NotFoundException("Request object not founds");
                    });

            employee.setName(employeesModel.Name);
            employee.setDepartment(employee.Department);

            employeesRepository.save(employee);

            String responseMessage = "Success";
            Optional<String> responseBody = Optional.of(responseMessage);
            return new ResponseEntity<>(responseBody, HttpStatus.OK);
        } catch (NotFoundException ex) {
            // Log the exception details
            ex.printStackTrace();
            throw new NotFoundException("Employee not found");
        } catch (Exception ex) {
            throw new NotFoundException("Request object not found");
            //return ResponseEntity.internalServerError().build();
        }
    }

    public ResponseEntity<List<EmployeesModel>> getAllEmployee() {
        return ResponseEntity.ok(employeesRepository.findAll());
    }

    @Override
    public ResponseEntity<Optional<String>> deleteEmployee(Long Id) {
        try {
            Optional<EmployeesModel> employee = employeesRepository.findById(Id);
            if (employee.isPresent()) {
                employeesRepository.deleteById(Id);
                String responseMessage = "Success";
                Optional<String> responseBody = Optional.of(responseMessage);
                return new ResponseEntity<>(responseBody, HttpStatus.OK);
            } else {
                return ResponseEntity.notFound().build();
            }
        } catch (Exception ex) {
            return ResponseEntity.internalServerError().build();
        }
    }
}
