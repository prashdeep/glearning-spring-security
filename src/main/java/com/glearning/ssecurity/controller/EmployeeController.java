package com.glearning.ssecurity.controller;

import com.glearning.ssecurity.model.Employee;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Arrays;
import java.util.List;

@RestController
@RequestMapping("/api/v1/employees")
public class EmployeeController {

    @GetMapping("/")
    public List<Employee> getAllEmployees(){
        return Arrays.asList(
                Employee.builder()
                        .id(1)
                        .name("Vinay")
                        .emailAddress("vinay@gmail.com")
                        .build(),
                Employee.builder()
                        .id(2)
                        .name("Hari")
                        .emailAddress("hari@gmail.com")
                        .build(),
                Employee.builder()
                        .id(2)
                        .name("Vinayak")
                        .emailAddress("vinayak@gmail.com")
                        .build()
        );
    }
}