package com.cromocoder.javamvctwo.repository;

import com.cromocoder.javamvctwo.model.EmployeesModel;
import org.springframework.data.jpa.repository.JpaRepository;

public interface EmployeesRepository extends JpaRepository<EmployeesModel, Long> {
}
