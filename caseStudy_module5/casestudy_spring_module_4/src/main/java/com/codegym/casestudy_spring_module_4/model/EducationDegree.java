package com.codegym.casestudy_spring_module_4.model;

import com.fasterxml.jackson.annotation.JsonBackReference;

import javax.persistence.*;
import java.util.List;

@Entity
public class EducationDegree {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer educationDegreeId;

    @Column(length = 45)
    private String educationDegreeName;

    @JsonBackReference
    @OneToMany(mappedBy = "educationDegreeId", cascade = CascadeType.REMOVE)
    private List<Employee> employees;

    public EducationDegree() {
    }

    public EducationDegree(String educationDegreeName) {
        this.educationDegreeName = educationDegreeName;
    }

    public EducationDegree(Integer educationDegreeId, String educationDegreeName) {
        this.educationDegreeId = educationDegreeId;
        this.educationDegreeName = educationDegreeName;
    }

    public Integer getEducationDegreeId() {
        return educationDegreeId;
    }

    public void setEducationDegreeId(Integer educationDegreeId) {
        this.educationDegreeId = educationDegreeId;
    }

    public String getEducationDegreeName() {
        return educationDegreeName;
    }

    public void setEducationDegreeName(String educationDegreeName) {
        this.educationDegreeName = educationDegreeName;
    }

    public List<Employee> getEmployees() {
        return employees;
    }

    public void setEmployees(List<Employee> employees) {
        this.employees = employees;
    }
}
