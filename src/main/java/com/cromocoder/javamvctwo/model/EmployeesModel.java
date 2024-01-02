package com.cromocoder.javamvctwo.model;

import jakarta.persistence.*;

import java.util.Date;

@Entity
@Table(name = "Employees")
public class EmployeesModel {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "employee_id")
    public Long EmployeeID;
    @Column(name = "employee_name")
    public String Name;
    @Column(name = "employee_dept")
    public  String Department;
    @Column(name = "created_on")
    public Date CreatedOn = new Date();
    @Column(name = "updated_on")
    public Date UpdatedOn = new Date();
    @PreUpdate
    public  void setLastUpdate() {this.UpdatedOn = new Date();}
    public EmployeesModel() {
    }
    public EmployeesModel(Long employeeID, String name, String department, Date createdOn, Date updatedOn) {
        EmployeeID = employeeID;
        Name = name;
        Department = department;
        CreatedOn = createdOn;
        UpdatedOn = updatedOn;
    }
    public Long getEmployeeID() {
        return EmployeeID;
    }
    public void setEmployeeID(Long employeeID) {
        EmployeeID = employeeID;
    }
    public String getName() {
        return Name;
    }
    public void setName(String name) {
        Name = name;
    }
    public String getDepartment() {
        return Department;
    }
    public void setDepartment(String department) {
        Department = department;
    }
    public Date getCreatedOn() {
        return CreatedOn;
    }
    public void setCreatedOn(Date createdOn) {
        CreatedOn = createdOn;
    }
    public Date getUpdatedOn() {
        return UpdatedOn;
    }
    public void setUpdatedOn(Date updatedOn) {
        UpdatedOn = updatedOn;
    }
}
