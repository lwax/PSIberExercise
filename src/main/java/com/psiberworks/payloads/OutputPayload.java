package com.psiberworks.payloads;

import java.math.BigDecimal;

public class OutputPayload {

    private BigDecimal annualTax;
    private BigDecimal monthlyTax;
    private BigDecimal taxCredits;
    private BigDecimal annualTaxAfterCredits;
    private BigDecimal monthlyTaxAfterCredits;
    private BigDecimal net;
    private BigDecimal medicalAidTaxCredits;




    public BigDecimal getMonthlyTax() {
        return monthlyTax;
    }

    public void setMonthlyTax(BigDecimal monthlyTax) {
        this.monthlyTax = monthlyTax;
    }

    public BigDecimal getAnnualTax() {
        return annualTax;
    }

    public void setAnnualTax(BigDecimal annualTax) {
        this.annualTax = annualTax;
    }

    public BigDecimal getTaxCredits() {
        return taxCredits;
    }

    public void setTaxCredits(BigDecimal taxCredits) {
        this.taxCredits = taxCredits;
    }

    public BigDecimal getAnnualTaxAfterCredits() {
        return annualTaxAfterCredits;
    }

    public void setAnnualTaxAfterCredits(BigDecimal annualTaxAfterCredits) {
        this.annualTaxAfterCredits = annualTaxAfterCredits;
    }

    public BigDecimal getMonthlyTaxAfterCredits() {
        return monthlyTaxAfterCredits;
    }

    public void setMonthlyTaxAfterCredits(BigDecimal monthlyTaxAfterCredits) {
        this.monthlyTaxAfterCredits = monthlyTaxAfterCredits;
    }

    public BigDecimal getNet() {
        return net;
    }

    public void setNet(BigDecimal net) {
        this.net = net;
    }

    public BigDecimal getMedicalAidTaxCredits() {
        return medicalAidTaxCredits;
    }

    public void setMedicalAidTaxCredits(BigDecimal medicalAidTaxCredits) {
        this.medicalAidTaxCredits = medicalAidTaxCredits;
    }
}
