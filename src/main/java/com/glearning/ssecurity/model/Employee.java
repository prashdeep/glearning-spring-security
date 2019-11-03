package com.glearning.ssecurity.model;

import lombok.Builder;
import lombok.Data;

import javax.validation.constraints.Min;
import javax.validation.constraints.NotBlank;

@Data
@Builder
public class Employee {
    private long id;
    @NotBlank(message = "name cannot be blank")
    @Min(value = 12, message = "Name should be of 12 characters")
    private String name;
    private String password;
    private String emailAddress;
}