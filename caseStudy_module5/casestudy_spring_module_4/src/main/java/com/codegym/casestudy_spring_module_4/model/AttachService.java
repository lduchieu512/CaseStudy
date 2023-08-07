package com.codegym.casestudy_spring_module_4.model;

import com.fasterxml.jackson.annotation.JsonBackReference;

import javax.persistence.*;
import java.util.List;

@Entity
public class AttachService {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer attachServiceId;

    @Column(nullable = false, length = 45)
    private String attachServiceName;

    @Column(nullable = false)
    private Double attachServiceCost;

    @Column(nullable = false, length = 45)
    private String attachServiceUnit;

    @Column(length = 45)
    private String attachServiceStatus;

    @JsonBackReference
    @OneToMany(mappedBy = "attachServiceId", cascade = CascadeType.REMOVE)
    private List<ContractDetail> contractDetails;

    public AttachService() {
    }

    public AttachService(String attachServiceName, Double attachServiceCost, String attachServiceUnit,
                         String attachServiceStatus) {
        this.attachServiceName = attachServiceName;
        this.attachServiceCost = attachServiceCost;
        this.attachServiceUnit = attachServiceUnit;
        this.attachServiceStatus = attachServiceStatus;
    }

    public AttachService(Integer attachServiceId, String attachServiceName, Double attachServiceCost,
                         String attachServiceUnit, String attachServiceStatus) {
        this.attachServiceId = attachServiceId;
        this.attachServiceName = attachServiceName;
        this.attachServiceCost = attachServiceCost;
        this.attachServiceUnit = attachServiceUnit;
        this.attachServiceStatus = attachServiceStatus;
    }

    public Integer getAttachServiceId() {
        return attachServiceId;
    }

    public void setAttachServiceId(Integer attachServiceId) {
        this.attachServiceId = attachServiceId;
    }

    public String getAttachServiceName() {
        return attachServiceName;
    }

    public void setAttachServiceName(String attachServiceName) {
        this.attachServiceName = attachServiceName;
    }

    public Double getAttachServiceCost() {
        return attachServiceCost;
    }

    public void setAttachServiceCost(Double attachServiceCost) {
        this.attachServiceCost = attachServiceCost;
    }

    public String getAttachServiceUnit() {
        return attachServiceUnit;
    }

    public void setAttachServiceUnit(String attachServiceUnit) {
        this.attachServiceUnit = attachServiceUnit;
    }

    public String getAttachServiceStatus() {
        return attachServiceStatus;
    }

    public void setAttachServiceStatus(String attachServiceStatus) {
        this.attachServiceStatus = attachServiceStatus;
    }

    public List<ContractDetail> getContractDetails() {
        return contractDetails;
    }

    public void setContractDetails(List<ContractDetail> contractDetails) {
        this.contractDetails = contractDetails;
    }
}
