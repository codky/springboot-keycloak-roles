package com.example.springbootkeycloakexample.controller;

import com.example.springbootkeycloakexample.entity.Employee;
import com.example.springbootkeycloakexample.service.EmployeeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.security.RolesAllowed;
import java.util.List;

@RestController
@RequestMapping("/employees")
public class EmployeeController {

    @Autowired
    private EmployeeService service;

    // this method can be accessed by user whose role is user
    @RolesAllowed("user")
    @GetMapping("/{employeeId}")
    public ResponseEntity<Employee> getEmployee(@PathVariable int employeeId) {
        return ResponseEntity.ok(service.getEmployee(employeeId));
    }

    // this method can be accessed by user whose role is admin
    @GetMapping
    @RolesAllowed("admin")
    public ResponseEntity<List<Employee>> findAllEmployees() {
        return ResponseEntity.ok(service.getAllEmployees());
    }
}
