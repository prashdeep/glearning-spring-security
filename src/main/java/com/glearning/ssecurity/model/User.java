package com.glearning.ssecurity.model;

import lombok.Data;

import javax.persistence.*;
import java.util.Set;

@Data
@Entity
@Table
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "user_id")
    private int userId;

    @Column(name="username")
    private String userName;

    @Column(name="email")
    private String emailAddress;

    @Column(name="password")
    private String password;

    @OneToMany(cascade = CascadeType.ALL, fetch = FetchType.EAGER)
    @JoinTable(name = "user_role",
            joinColumns= @JoinColumn(name="userId"),
            inverseJoinColumns = @JoinColumn(name = "roleId" ))
    private Set<Role> roles;

}