package com.cy_day_02.q_01.model;

import org.springframework.stereotype.Component;

import com.fasterxml.jackson.annotation.JsonProperty;

@Component
public class Department {

    @JsonProperty("Department name")
    private String departmentName;
    @JsonProperty("Branch")
    private String branch;

    public Department() {

    }

    public Department(String departmentName, String branch) {
        this.departmentName = departmentName;
        this.branch = branch;
    }

    public String getDepartmentName() {
        return departmentName;
    }

    public void setDepartmentName(String departmentName) {
        this.departmentName = departmentName;
    }

    public String getBranch() {
        return branch;
    }

    public void setBranch(String branch) {
        this.branch = branch;
    }

}
