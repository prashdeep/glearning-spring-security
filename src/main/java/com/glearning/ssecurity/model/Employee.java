package com.glearning.ssecurity.model;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class Employee {
    private long id;
    private String name;
    private String password;
    private String emailAddress;
}