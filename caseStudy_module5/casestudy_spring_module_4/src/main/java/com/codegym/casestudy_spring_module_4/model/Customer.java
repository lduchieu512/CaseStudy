package com.codegym.casestudy_spring_module_4.model;

import com.fasterxml.jackson.annotation.JsonBackReference;
import org.hibernate.annotations.GenericGenerator;
import org.springframework.format.annotation.DateTimeFormat;

import javax.persistence.*;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Pattern;
import java.util.Date;
import java.util.List;

@Entity
public class Customer {

    @Id
    @GeneratedValue(generator = "prod-generator")
    @GenericGenerator(name = "prod-generator",
            parameters = @org.hibernate.annotations.Parameter(name = "prefix", value = "KH"),
            strategy = "com.codegym.casestudy_spring_module_4.model.MyGenerator")
    @Column(length = 45)
    private String customerId;

   /* @Id
//    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Pattern(regexp = "^KH-\\d{4}$", message = "Mã khách hàng không đúng định dạng KH-XXXX (X là số từ 0-9)")
    private String customerId;*/

    @NotNull
    @ManyToOne
    @JoinColumn(name = "customer_type_id", nullable = false)
    private CustomerType customerTypeId;

    @NotEmpty
    @Column(nullable = false, length = 45)
    private String customerName;

    @NotNull
    @Column(nullable = false)
    @DateTimeFormat(pattern = "dd-MM-yyyy")
    private Date customerBirthday;

    @NotNull
    @Column(nullable = false)
    private Boolean customerGender;

    @Column(nullable = false, length = 45)
    @Pattern(regexp = "^\\d{9}$|^\\d{12}$", message = "{idCard}")
    private String customerIdCard;

    @Column(nullable = false, length = 45)
    @Pattern(regexp = "^090\\d{7}$|^091\\d{7}$|^\\(84\\)\\+90\\d{7}$|^\\(84\\)\\+91\\d{7}$", message = "{phone}")
    private String customerPhone;

    @Column(length = 45)
    @Pattern(regexp = "^[a-z]\\w*@gmail+\\.[a-z]+$", message = "{email}")
    private String customerEmail;

    @NotEmpty
    @Column(length = 45)
    private String customerAddress;

    @JsonBackReference
    @OneToMany(mappedBy = "customerId", cascade = CascadeType.REMOVE)
    private List<Contract> contracts;

    public Customer() {
    }

    public Customer(CustomerType customerTypeId, String customerName, Date customerBirthday, Boolean customerGender,
                    String customerIdCard, String customerPhone, String customerEmail, String customerAddress) {
        this.customerTypeId = customerTypeId;
        this.customerName = customerName;
        this.customerBirthday = customerBirthday;
        this.customerGender = customerGender;
        this.customerIdCard = customerIdCard;
        this.customerPhone = customerPhone;
        this.customerEmail = customerEmail;
        this.customerAddress = customerAddress;
    }

    public Customer(String customerId, CustomerType customerTypeId, String customerName, Date customerBirthday,
                    Boolean customerGender, String customerIdCard, String customerPhone, String customerEmail,
                    String customerAddress, List<Contract> contracts) {
        this.customerId = customerId;
        this.customerTypeId = customerTypeId;
        this.customerName = customerName;
        this.customerBirthday = customerBirthday;
        this.customerGender = customerGender;
        this.customerIdCard = customerIdCard;
        this.customerPhone = customerPhone;
        this.customerEmail = customerEmail;
        this.customerAddress = customerAddress;
        this.contracts = contracts;
    }


    public String getCustomerId() {
        return customerId;
    }

    public void setCustomerId(String customerId) {
        this.customerId = customerId;
    }

    public CustomerType getCustomerTypeId() {
        return customerTypeId;
    }

    public void setCustomerTypeId(CustomerType customerTypeId) {
        this.customerTypeId = customerTypeId;
    }

    public String getCustomerName() {
        return customerName;
    }

    public void setCustomerName(String customerName) {
        this.customerName = customerName;
    }

    public Date getCustomerBirthday() {
        return customerBirthday;
    }

    public void setCustomerBirthday(Date customerBirthday) {
        this.customerBirthday = customerBirthday;
    }

    public Boolean getCustomerGender() {
        return customerGender;
    }

    public void setCustomerGender(Boolean customerGender) {
        this.customerGender = customerGender;
    }

    public String getCustomerIdCard() {
        return customerIdCard;
    }

    public void setCustomerIdCard(String customerIdCard) {
        this.customerIdCard = customerIdCard;
    }

    public String getCustomerPhone() {
        return customerPhone;
    }

    public void setCustomerPhone(String customerPhone) {
        this.customerPhone = customerPhone;
    }

    public String getCustomerEmail() {
        return customerEmail;
    }

    public void setCustomerEmail(String customerEmail) {
        this.customerEmail = customerEmail;
    }

    public String getCustomerAddress() {
        return customerAddress;
    }

    public void setCustomerAddress(String customerAddress) {
        this.customerAddress = customerAddress;
    }

    public List<Contract> getContracts() {
        return contracts;
    }

    public void setContracts(List<Contract> contracts) {
        this.contracts = contracts;
    }
}
