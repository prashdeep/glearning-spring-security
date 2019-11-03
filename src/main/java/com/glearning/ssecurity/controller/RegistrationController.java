package com.glearning.ssecurity.controller;

import com.glearning.ssecurity.model.Employee;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.validation.Valid;

@RestController
@RequestMapping("/register")

public class RegistrationController {

    public void register(@Valid @RequestBody Employee employee){

    }
}