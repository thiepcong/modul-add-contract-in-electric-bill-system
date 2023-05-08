
package model;

import java.io.Serializable;

public class ContractDetail implements Serializable{
    private int id;
    private String payment;
    private String paymentTerm;
    private Contract c;
    private ContractType t;
    private ElectricHousehold h;

    public ContractDetail() {
    }

    public ContractDetail(int id, String payment, String paymentTerm, Contract c, ContractType t, ElectricHousehold h) {
        this.id = id;
        this.payment = payment;
        this.paymentTerm = paymentTerm;
        this.c = c;
        this.t = t;
        this.h = h;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getPayment() {
        return payment;
    }

    public void setPayment(String payment) {
        this.payment = payment;
    }

    public String getPaymentTerm() {
        return paymentTerm;
    }

    public void setPaymentTerm(String paymentTerm) {
        this.paymentTerm = paymentTerm;
    }

    public Contract getC() {
        return c;
    }

    public void setC(Contract c) {
        this.c = c;
    }

    public ContractType getT() {
        return t;
    }

    public void setT(ContractType t) {
        this.t = t;
    }

    public ElectricHousehold getH() {
        return h;
    }

    public void setH(ElectricHousehold h) {
        this.h = h;
    }
    
}
