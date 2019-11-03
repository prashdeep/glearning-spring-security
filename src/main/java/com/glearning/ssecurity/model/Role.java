package com.glearning.ssecurity.model;

import javax.persistence.*;

@Entity
@Table
public class Role {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "role_id")
    private int roleId;

    private String role;

    public void setRole(String role){
        this.role = role;
    }
    public String getRole(){
        return this.role;
    }

    public void setRoleId(int roleId){
        this.roleId = roleId;
    }

    public int getRoleId(){return this.roleId;}

    @Override
    public String toString() {
        return "Role{" +
                "roleId=" + roleId +
                ", role='" + role + '\'' +
                '}';
    }
}