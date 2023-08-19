package com.example.case_study_furama_servlet.model;

public class Contract_Detail {
    private int contract_detail_id;
    private Contract contract_id;
    private AttachService attachService_id;
    private int quantity;

    public Contract_Detail() {
    }

    public Contract_Detail(int contract_detail_id, Contract contract_id, AttachService attachService_id, int quantity) {
        this.contract_detail_id = contract_detail_id;
        this.contract_id = contract_id;
        this.attachService_id = attachService_id;
        this.quantity = quantity;
    }

    public int getContract_detail_id() {
        return contract_detail_id;
    }

    public void setContract_detail_id(int contract_detail_id) {
        this.contract_detail_id = contract_detail_id;
    }

    public Contract getContract_id() {
        return contract_id;
    }

    public void setContract_id(Contract contract_id) {
        this.contract_id = contract_id;
    }

    public AttachService getAttachService_id() {
        return attachService_id;
    }

    public void setAttachService_id(AttachService attachService_id) {
        this.attachService_id = attachService_id;
    }

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }
}
