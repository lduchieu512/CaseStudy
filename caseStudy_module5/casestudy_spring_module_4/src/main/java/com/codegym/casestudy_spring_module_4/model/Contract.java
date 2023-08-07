package com.codegym.casestudy_spring_module_4.model;

import com.fasterxml.jackson.annotation.JsonBackReference;
import org.springframework.format.annotation.DateTimeFormat;

import javax.persistence.*;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotNull;
import java.util.Date;
import java.util.List;

@Entity
public class Contract {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer contractId;

    @NotNull
    @Column(nullable = false)
    @DateTimeFormat(pattern = "dd-MM-yyyy")
    private Date contractStartDate;

    @NotNull
    @Column(nullable = false)
    @DateTimeFormat(pattern = "dd-MM-yyyy")
    private Date contractEndDate;

    @Column(nullable = false)
    @Min(value = 0, message = "Không được bé hơn 0")
    private Double contractDeposit;

    @Column(nullable = false)
    @Min(value = 0, message = "Không được bé hơn 0")
    private Double contractTotalMoney;

    @NotNull
    @ManyToOne
    @JoinColumn(name = "employee_id", nullable = false)
    private Employee employeeId;

    @NotNull
    @ManyToOne
    @JoinColumn(name = "customer_id", nullable = false)
    private Customer customerId;

    @NotNull
    @ManyToOne
    @JoinColumn(name = "service_id", nullable = false)
    private Service serviceId;

    @JsonBackReference
    @OneToMany(mappedBy = "contractId", cascade = CascadeType.REMOVE)
    private List<ContractDetail> contractDetails;

    public Contract() {
    }

    public Contract(Date contractStartDate, Date contractEndDate, Double contractDeposit, Double contractTotalMoney,
                    Employee employeeId, Customer customerId, Service serviceId) {
        this.contractStartDate = contractStartDate;
        this.contractEndDate = contractEndDate;
        this.contractDeposit = contractDeposit;
        this.contractTotalMoney = contractTotalMoney;
        this.employeeId = employeeId;
        this.customerId = customerId;
        this.serviceId = serviceId;
    }

    public Contract(Integer contractId, Date contractStartDate, Date contractEndDate, Double contractDeposit,
                    Double contractTotalMoney, Employee employeeId, Customer customerId, Service serviceId) {
        this.contractId = contractId;
        this.contractStartDate = contractStartDate;
        this.contractEndDate = contractEndDate;
        this.contractDeposit = contractDeposit;
        this.contractTotalMoney = contractTotalMoney;
        this.employeeId = employeeId;
        this.customerId = customerId;
        this.serviceId = serviceId;
    }

    public Integer getContractId() {
        return contractId;
    }

    public void setContractId(Integer contractId) {
        this.contractId = contractId;
    }

    public Date getContractStartDate() {
        return contractStartDate;
    }

    public void setContractStartDate(Date contractStartDate) {
        this.contractStartDate = contractStartDate;
    }

    public Date getContractEndDate() {
        return contractEndDate;
    }

    public void setContractEndDate(Date contractEndDate) {
        this.contractEndDate = contractEndDate;
    }

    public Double getContractDeposit() {
        return contractDeposit;
    }

    public void setContractDeposit(Double contractDeposit) {
        this.contractDeposit = contractDeposit;
    }

    public Double getContractTotalMoney() {
        return contractTotalMoney;
    }

    public void setContractTotalMoney(Double contractTotalMoney) {
        this.contractTotalMoney = contractTotalMoney;
    }

    public Employee getEmployeeId() {
        return employeeId;
    }

    public void setEmployeeId(Employee employeeId) {
        this.employeeId = employeeId;
    }

    public Customer getCustomerId() {
        return customerId;
    }

    public void setCustomerId(Customer customerId) {
        this.customerId = customerId;
    }

    public Service getServiceId() {
        return serviceId;
    }

    public void setServiceId(Service serviceId) {
        this.serviceId = serviceId;
    }

    public List<ContractDetail> getContractDetails() {
        return contractDetails;
    }

    public void setContractDetails(List<ContractDetail> contractDetails) {
        this.contractDetails = contractDetails;
    }
}
