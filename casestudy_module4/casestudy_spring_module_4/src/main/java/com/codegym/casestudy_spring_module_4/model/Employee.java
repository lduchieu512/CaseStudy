package com.codegym.casestudy_spring_module_4.model;

import com.fasterxml.jackson.annotation.JsonBackReference;
import org.springframework.format.annotation.DateTimeFormat;

import javax.persistence.*;
import javax.validation.constraints.*;
import java.util.Date;
import java.util.List;

@Entity
public class Employee {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer employeeId;

    @NotEmpty
    @Column(nullable = false, length = 45)
    private String employeeName;

    @NotNull
    @Column(nullable = false)
    @DateTimeFormat(pattern = "dd-MM-yyyy")
    private Date employeeBirthday;

    @Column(nullable = false, length = 45)
    @Pattern(regexp = "^\\d{9}$|^\\d{12}$", message = "{idCard}")
    private String employeeIdCard;

    @Column(nullable = false)
    @Min(value = 0, message = "Lương phải lớn hơn 0")
    private Double employeeSalary;

    @Column(nullable = false, length = 45)
    @Pattern(regexp = "^090\\d{7}$|^091\\d{7}$|^\\(84\\)\\+90\\d{7}$|^\\(84\\)\\+91\\d{7}$", message = "{phone}")
    private String employeePhone;

    @Column(length = 45)
    @Pattern(regexp = "^[a-z]\\w*@gmail+\\.[a-z]+$", message = "{email}")
    private String employeeEmail;

    @NotEmpty
    @Column(length = 45)
    private String employeeAddress;

    @NotNull
    @ManyToOne
    @JoinColumn(name = "position_id", nullable = false)
    private Position positionId;

    @NotNull
    @ManyToOne
    @JoinColumn(name = "education_degree_id", nullable = false)
    private EducationDegree educationDegreeId;

    @NotNull
    @ManyToOne
    @JoinColumn(name = "division_id", nullable = false)
    private Division divisionId;

    @ManyToOne
    @JoinColumn(name = "username")
    private User username;

    @JsonBackReference
    @OneToMany(mappedBy = "employeeId", cascade = CascadeType.REMOVE)
    private List<Contract> contracts;

    public Employee() {
    }

    public Employee(String employeeName, Date employeeBirthday, String employeeIdCard, Double employeeSalary,
                    String employeePhone, String employeeEmail, String employeeAddress, Position positionId,
                    EducationDegree educationDegreeId, Division divisionId, User username) {
        this.employeeName = employeeName;
        this.employeeBirthday = employeeBirthday;
        this.employeeIdCard = employeeIdCard;
        this.employeeSalary = employeeSalary;
        this.employeePhone = employeePhone;
        this.employeeEmail = employeeEmail;
        this.employeeAddress = employeeAddress;
        this.positionId = positionId;
        this.educationDegreeId = educationDegreeId;
        this.divisionId = divisionId;
        this.username = username;
    }

    public Employee(Integer employeeId, String employeeName, Date employeeBirthday, String employeeIdCard,
                    Double employeeSalary, String employeePhone, String employeeEmail, String employeeAddress,
                    Position positionId, EducationDegree educationDegreeId, Division divisionId, User username) {
        this.employeeId = employeeId;
        this.employeeName = employeeName;
        this.employeeBirthday = employeeBirthday;
        this.employeeIdCard = employeeIdCard;
        this.employeeSalary = employeeSalary;
        this.employeePhone = employeePhone;
        this.employeeEmail = employeeEmail;
        this.employeeAddress = employeeAddress;
        this.positionId = positionId;
        this.educationDegreeId = educationDegreeId;
        this.divisionId = divisionId;
        this.username = username;
    }

    public Integer getEmployeeId() {
        return employeeId;
    }

    public void setEmployeeId(Integer employeeId) {
        this.employeeId = employeeId;
    }

    public String getEmployeeName() {
        return employeeName;
    }

    public void setEmployeeName(String employeeName) {
        this.employeeName = employeeName;
    }

    public Date getEmployeeBirthday() {
        return employeeBirthday;
    }

    public void setEmployeeBirthday(Date employeeBirthday) {
        this.employeeBirthday = employeeBirthday;
    }

    public String getEmployeeIdCard() {
        return employeeIdCard;
    }

    public void setEmployeeIdCard(String employeeIdCard) {
        this.employeeIdCard = employeeIdCard;
    }

    public Double getEmployeeSalary() {
        return employeeSalary;
    }

    public void setEmployeeSalary(Double employeeSalary) {
        this.employeeSalary = employeeSalary;
    }

    public String getEmployeePhone() {
        return employeePhone;
    }

    public void setEmployeePhone(String employeePhone) {
        this.employeePhone = employeePhone;
    }

    public String getEmployeeEmail() {
        return employeeEmail;
    }

    public void setEmployeeEmail(String employeeEmail) {
        this.employeeEmail = employeeEmail;
    }

    public String getEmployeeAddress() {
        return employeeAddress;
    }

    public void setEmployeeAddress(String employeeAddress) {
        this.employeeAddress = employeeAddress;
    }

    public Position getPositionId() {
        return positionId;
    }

    public void setPositionId(Position positionId) {
        this.positionId = positionId;
    }

    public EducationDegree getEducationDegreeId() {
        return educationDegreeId;
    }

    public void setEducationDegreeId(EducationDegree educationDegreeId) {
        this.educationDegreeId = educationDegreeId;
    }

    public Division getDivisionId() {
        return divisionId;
    }

    public void setDivisionId(Division divisionId) {
        this.divisionId = divisionId;
    }

    public User getUsername() {
        return username;
    }

    public void setUsername(User username) {
        this.username = username;
    }

    public List<Contract> getContracts() {
        return contracts;
    }

    public void setContracts(List<Contract> contracts) {
        this.contracts = contracts;
    }
}
