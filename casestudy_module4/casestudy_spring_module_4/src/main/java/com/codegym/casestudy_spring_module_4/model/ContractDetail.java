package com.codegym.casestudy_spring_module_4.model;

import javax.persistence.*;

@Entity
public class ContractDetail {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer contractDetailId;

    @ManyToOne
    @JoinColumn(name = "contract_id", nullable = false)
    private Contract contractId;

    @ManyToOne
    @JoinColumn(name = "attach_service_id", nullable = false)
    private AttachService attachServiceId;

    @Column(nullable = false)
    private Integer quantity;

    public ContractDetail() {
    }

    public ContractDetail(Contract contractId, AttachService attachServiceId, Integer quantity) {
        this.contractId = contractId;
        this.attachServiceId = attachServiceId;
        this.quantity = quantity;
    }

    public ContractDetail(Integer contractDetailId, Contract contractId, AttachService attachServiceId, Integer quantity) {
        this.contractDetailId = contractDetailId;
        this.contractId = contractId;
        this.attachServiceId = attachServiceId;
        this.quantity = quantity;
    }

    public Integer getContractDetailId() {
        return contractDetailId;
    }

    public void setContractDetailId(Integer contractDetailId) {
        this.contractDetailId = contractDetailId;
    }

    public Contract getContractId() {
        return contractId;
    }

    public void setContractId(Contract contractId) {
        this.contractId = contractId;
    }

    public AttachService getAttachServiceId() {
        return attachServiceId;
    }

    public void setAttachServiceId(AttachService attachServiceId) {
        this.attachServiceId = attachServiceId;
    }

    public Integer getQuantity() {
        return quantity;
    }

    public void setQuantity(Integer quantity) {
        this.quantity = quantity;
    }
}
