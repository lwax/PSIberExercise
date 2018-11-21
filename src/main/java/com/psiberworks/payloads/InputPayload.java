package com.psiberworks.payloads;

import java.math.BigDecimal;

public class InputPayload {

    private String taxYear;
    private String ageGroup;
    private BigDecimal taxableIncomeYearly;
    private BigDecimal taxableIncomeMonthly;
    private int numOfMedicalAidMembers;
    private String isMonthOrYear;

    public String isMonthOrYear() {
        return this.isMonthOrYear;
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

    public int getNumOfMedicalAidMembers() {
        return numOfMedicalAidMembers;
    }

    public void setNumOfMedicalAidMembers(int numOfMedicalAidMembers) {
        this.numOfMedicalAidMembers = numOfMedicalAidMembers;
    }
}
