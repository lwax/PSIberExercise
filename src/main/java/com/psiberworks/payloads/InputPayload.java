package com.psiberworks.payloads;

import java.math.BigDecimal;

public class InputPayload {

    private String taxYear;
    private String ageGroup;
    private BigDecimal taxableIncomeYearly;
    private BigDecimal taxableIncomeMonthly;
    private BigDecimal taxableIncome;
    private int numOfMedicalAidMembers;
    private String isMonthOrYear;

    public String getIsMonthOrYear() {
        return isMonthOrYear;
    }

    public void setMonthOrYear(String isMonthOrYear) {
        this.isMonthOrYear = isMonthOrYear;
    }

    public String getTaxYear() {
        return taxYear;
    }

    public void setTaxYear(String taxYear) {
        this.taxYear = taxYear;
    }

    public String getAgeGroup() {
        return ageGroup;
    }

    public void setAgeGroup(String ageGroup) {
        this.ageGroup = ageGroup;
    }

    public BigDecimal getTaxableIncomeYearly() {
        return taxableIncomeYearly;
    }

    public void setTaxableIncomeYearly(BigDecimal taxableIncomeYearly) {
        this.taxableIncomeYearly = taxableIncomeYearly;
    }

    public BigDecimal getTaxableIncomeMonthly() {
        return taxableIncomeMonthly;
    }

    public void setTaxableIncomeMonthly(BigDecimal taxableIncomeMonthly) {
        this.taxableIncomeMonthly = taxableIncomeMonthly;
    }

    public BigDecimal getTaxableIncome() {
        return this.taxableIncome;
    }

    public void setTaxableIncome(BigDecimal taxableIncome) {
        this.taxableIncome = taxableIncome;
    }

    public int getNumOfMedicalAidMembers() {
        return numOfMedicalAidMembers;
    }

    public void setNumOfMedicalAidMembers(int numOfMedicalAidMembers) {
        this.numOfMedicalAidMembers = numOfMedicalAidMembers;
    }
}
