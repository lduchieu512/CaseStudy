package com.codegym.casestudy_spring_module_4.model;

import com.fasterxml.jackson.annotation.JsonBackReference;
import org.hibernate.annotations.GenericGenerator;

import javax.persistence.*;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Pattern;
import java.util.List;

@Entity
public class Service {

    @Id
    @GeneratedValue(generator = "prod-generator")
    @GenericGenerator(name = "prod-generator",
            parameters = @org.hibernate.annotations.Parameter(name = "prefix", value = "DV"),
            strategy = "com.codegym.casestudy_spring_module_4.model.MyGenerator")
    @Column(length = 45)
    private String serviceId;

/*    @Id
//    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Pattern(regexp = "^DV-\\d{4}$", message = "Mã dịch vụ không đúng định dạng DV-XXXX (X là số 0-9)")
    private String serviceId;*/

    @NotEmpty
    @Column(nullable = false, length = 45)
    private String serviceName;

    @Min(value = 0, message = "Diện tích phải lớn hơn 0")
    private Integer serviceArea;

    @Column(nullable = false)
    @Min(value = 0, message = "Giá phải lớn hơn 0")
    private Double serviceCost;

    @Min(value = 0, message = "Số lượng người phải lớn hơn 0")
    private Integer serviceMaxPeople;

    @NotNull
    @ManyToOne
    @JoinColumn(name = "rent_type_id", nullable = false)
    private RentType rentTypeId;

    @NotNull
    @ManyToOne
    @JoinColumn(name = "service_type_id", nullable = false)
    private ServiceType serviceTypeId;

    @NotEmpty
    @Column(length = 45)
    private String standardRoom;

    @NotEmpty
    @Column(length = 45)
    private String descriptionOtherConvenience;

    @Min(value = 0, message = "Lớn hơn 0")
    private Double poolArea;

    @Min(value = 0, message = "Số tầng phải là số nguyên dương")
    private Integer numberOfFloors;

    @JsonBackReference
    @OneToMany(mappedBy = "serviceId", cascade = CascadeType.REMOVE)
    private List<Contract> contracts;

    public Service() {
    }

    public Service(String serviceName, Integer serviceArea, Double serviceCost, Integer serviceMaxPeople,
                   RentType rentTypeId, ServiceType serviceTypeId, String standardRoom,
                   String descriptionOtherConvenience, Double poolArea, Integer numberOfFloors) {
        this.serviceName = serviceName;
        this.serviceArea = serviceArea;
        this.serviceCost = serviceCost;
        this.serviceMaxPeople = serviceMaxPeople;
        this.rentTypeId = rentTypeId;
        this.serviceTypeId = serviceTypeId;
        this.standardRoom = standardRoom;
        this.descriptionOtherConvenience = descriptionOtherConvenience;
        this.poolArea = poolArea;
        this.numberOfFloors = numberOfFloors;
    }

    public Service(String serviceId, String serviceName, Integer serviceArea, Double serviceCost,
                   Integer serviceMaxPeople, RentType rentTypeId, ServiceType serviceTypeId, String standardRoom,
                   String descriptionOtherConvenience, Double poolArea, Integer numberOfFloors) {
        this.serviceId = serviceId;
        this.serviceName = serviceName;
        this.serviceArea = serviceArea;
        this.serviceCost = serviceCost;
        this.serviceMaxPeople = serviceMaxPeople;
        this.rentTypeId = rentTypeId;
        this.serviceTypeId = serviceTypeId;
        this.standardRoom = standardRoom;
        this.descriptionOtherConvenience = descriptionOtherConvenience;
        this.poolArea = poolArea;
        this.numberOfFloors = numberOfFloors;
    }

    public String getServiceId() {
        return serviceId;
    }

    public void setServiceId(String serviceId) {
        this.serviceId = serviceId;
    }

    public String getServiceName() {
        return serviceName;
    }

    public void setServiceName(String serviceName) {
        this.serviceName = serviceName;
    }

    public Integer getServiceArea() {
        return serviceArea;
    }

    public void setServiceArea(Integer serviceArea) {
        this.serviceArea = serviceArea;
    }

    public Double getServiceCost() {
        return serviceCost;
    }

    public void setServiceCost(Double serviceCost) {
        this.serviceCost = serviceCost;
    }

    public Integer getServiceMaxPeople() {
        return serviceMaxPeople;
    }

    public void setServiceMaxPeople(Integer serviceMaxPeople) {
        this.serviceMaxPeople = serviceMaxPeople;
    }

    public RentType getRentTypeId() {
        return rentTypeId;
    }

    public void setRentTypeId(RentType rentTypeId) {
        this.rentTypeId = rentTypeId;
    }

    public ServiceType getServiceTypeId() {
        return serviceTypeId;
    }

    public void setServiceTypeId(ServiceType serviceTypeId) {
        this.serviceTypeId = serviceTypeId;
    }

    public String getStandardRoom() {
        return standardRoom;
    }

    public void setStandardRoom(String standardRoom) {
        this.standardRoom = standardRoom;
    }

    public String getDescriptionOtherConvenience() {
        return descriptionOtherConvenience;
    }

    public void setDescriptionOtherConvenience(String descriptionOtherConvenience) {
        this.descriptionOtherConvenience = descriptionOtherConvenience;
    }

    public Double getPoolArea() {
        return poolArea;
    }

    public void setPoolArea(Double poolArea) {
        this.poolArea = poolArea;
    }

    public Integer getNumberOfFloors() {
        return numberOfFloors;
    }

    public void setNumberOfFloors(Integer numberOfFloors) {
        this.numberOfFloors = numberOfFloors;
    }

    public List<Contract> getContracts() {
        return contracts;
    }

    public void setContracts(List<Contract> contracts) {
        this.contracts = contracts;
    }
}
