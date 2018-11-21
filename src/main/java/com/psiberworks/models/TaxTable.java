package com.psiberworks.models;

import java.io.Serializable;
import java.math.BigDecimal;

import javax.annotation.Generated;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;

@Entity
public class TaxTable implements Serializable{

    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long id;

    @Column(nullable = false, unique = true)
    private String taxYear;
    
    @Column
    private BigDecimal taxBracket1;

    @Column
    private BigDecimal taxBracket1TaxRatePerc;

    @Column
    private BigDecimal taxBracket1TaxRateAmount;
    
    @Column
    private BigDecimal taxBracket2;

    @Column
    private BigDecimal taxBracket2TaxRatePerc;

    @Column
    private BigDecimal taxBracket2TaxRateAmount;
    
    @Column
    private BigDecimal taxBracket3;

    @Column
    private BigDecimal taxBracket3TaxRatePerc;

    @Column
    private BigDecimal taxBracket3TaxRateAmount;
    
    @Column
    private BigDecimal taxBracket4;

    @Column
    private BigDecimal taxBracket4TaxRatePerc;

    @Column
    private BigDecimal taxBracket4TaxRateAmount;
    
    @Column
    private BigDecimal taxBracket5;

    @Column
    private BigDecimal taxBracket5TaxRatePerc;

    @Column
    private BigDecimal taxBracket5TaxRateAmount;
    
    @Column
    private BigDecimal taxBracket6;

    @Column
    private BigDecimal taxBracket6TaxRatePerc;

    @Column
    private BigDecimal taxBracket6TaxRateAmount;

    @Column
    private BigDecimal taxBracket7;

    @Column
    private BigDecimal taxBracket7TaxRatePerc;

    @Column
    private BigDecimal taxBracket7TaxRateAmount;

    @Column
    private BigDecimal medicalAidCreditMainAmount;

    @Column
    private BigDecimal medicalAidCreditSecondaryAmount;

    public long getId() {
        return this.id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getTaxYear() {
        return this.taxYear;
    }

    public void setTaxYear(String taxYear) {
        this.taxYear = taxYear;
    }

    public BigDecimal getTaxBracket1() {
        return this.taxBracket1;
    }

    public void setTaxBracket1(BigDecimal taxBracket1) {
        this.taxBracket1 = taxBracket1;
    }

    public BigDecimal getTaxBracket1TaxRatePerc() {
        return this.taxBracket1TaxRatePerc;
    }

    public void setTaxBracket1TaxRatePerc(BigDecimal taxBracket1TaxRatePerc) {
        this.taxBracket1TaxRatePerc = taxBracket1TaxRatePerc;
    }

    public BigDecimal getTaxBracket1TaxRateAmount() {
        return this.taxBracket1TaxRateAmount;
    }

    public void setTaxBracket1TaxRateAmount(BigDecimal taxBracket1TaxRateAmount) {
        this.taxBracket1TaxRateAmount = taxBracket1TaxRateAmount;
    }

    public BigDecimal getTaxBracket2() {
        return this.taxBracket2;
    }

    public void setTaxBracket2(BigDecimal taxBracket2) {
        this.taxBracket2 = taxBracket2;
    }

    public BigDecimal getTaxBracket2TaxRatePerc() {
        return this.taxBracket2TaxRatePerc;
    }

    public void setTaxBracket2TaxRatePerc(BigDecimal taxBracket2TaxRatePerc) {
        this.taxBracket2TaxRatePerc = taxBracket2TaxRatePerc;
    }

    public BigDecimal getTaxBracket2TaxRateAmount() {
        return this.taxBracket2TaxRateAmount;
    }

    public void setTaxBracket2TaxRateAmount(BigDecimal taxBracket2TaxRateAmount) {
        this.taxBracket2TaxRateAmount = taxBracket2TaxRateAmount;
    }

    public BigDecimal getTaxBracket3() {
        return this.taxBracket3;
    }

    public void setTaxBracket3(BigDecimal taxBracket3) {
        this.taxBracket3 = taxBracket3;
    }

    public BigDecimal getTaxBracket3TaxRatePerc() {
        return this.taxBracket3TaxRatePerc;
    }

    public void setTaxBracket3TaxRatePerc(BigDecimal taxBracket3TaxRatePerc) {
        this.taxBracket3TaxRatePerc = taxBracket3TaxRatePerc;
    }

    public BigDecimal getTaxBracket3TaxRateAmount() {
        return this.taxBracket3TaxRateAmount;
    }

    public void setTaxBracket3TaxRateAmount(BigDecimal taxBracket3TaxRateAmount) {
        this.taxBracket3TaxRateAmount = taxBracket3TaxRateAmount;
    }

    public BigDecimal getTaxBracket4() {
        return this.taxBracket4;
    }

    public void setTaxBracket4(BigDecimal taxBracket4) {
        this.taxBracket4 = taxBracket4;
    }

    public BigDecimal getTaxBracket4TaxRatePerc() {
        return this.taxBracket4TaxRatePerc;
    }

    public void setTaxBracket4TaxRatePerc(BigDecimal taxBracket4TaxRatePerc) {
        this.taxBracket4TaxRatePerc = taxBracket4TaxRatePerc;
    }

    public BigDecimal getTaxBracket4TaxRateAmount() {
        return this.taxBracket4TaxRateAmount;
    }

    public void setTaxBracket4TaxRateAmount(BigDecimal taxBracket4TaxRateAmount) {
        this.taxBracket4TaxRateAmount = taxBracket4TaxRateAmount;
    }

    public BigDecimal getTaxBracket5() {
        return this.taxBracket5;
    }

    public void setTaxBracket5(BigDecimal taxBracket5) {
        this.taxBracket5 = taxBracket5;
    }

    public BigDecimal getTaxBracket5TaxRatePerc() {
        return this.taxBracket5TaxRatePerc;
    }

    public void setTaxBracket5TaxRatePerc(BigDecimal taxBracket5TaxRatePerc) {
        this.taxBracket5TaxRatePerc = taxBracket5TaxRatePerc;
    }

    public BigDecimal getTaxBracket5TaxRateAmount() {
        return this.taxBracket5TaxRateAmount;
    }

    public void setTaxBracket5TaxRateAmount(BigDecimal taxBracket5TaxRateAmount) {
        this.taxBracket5TaxRateAmount = taxBracket5TaxRateAmount;
    }

    public BigDecimal getTaxBracket6() {
        return this.taxBracket6;
    }

    public void setTaxBracket6(BigDecimal taxBracket6) {
        this.taxBracket6 = taxBracket6;
    }

    public BigDecimal getTaxBracket6TaxRatePerc() {
        return this.taxBracket6TaxRatePerc;
    }

    public void setTaxBracket6TaxRatePerc(BigDecimal taxBracket6TaxRatePerc) {
        this.taxBracket6TaxRatePerc = taxBracket6TaxRatePerc;
    }

    public BigDecimal getTaxBracket6TaxRateAmount() {
        return this.taxBracket6TaxRateAmount;
    }

    public void setTaxBracket6TaxRateAmount(BigDecimal taxBracket6TaxRateAmount) {
        this.taxBracket6TaxRateAmount = taxBracket6TaxRateAmount;
    }

    public BigDecimal getTaxBracket7() {
        return this.taxBracket7;
    }

    public void setTaxBracket7(BigDecimal taxBracket7) {
        this.taxBracket7 = taxBracket7;
    }

    public BigDecimal getTaxBracket7TaxRatePerc() {
        return this.taxBracket7TaxRatePerc;
    }

    public void setTaxBracket7TaxRatePerc(BigDecimal taxBracket7TaxRatePerc) {
        this.taxBracket7TaxRatePerc = taxBracket7TaxRatePerc;
    }

    public BigDecimal getTaxBracket7TaxRateAmount() {
        return this.taxBracket7TaxRateAmount;
    }

    public void setTaxBracket7TaxRateAmount(BigDecimal taxBracket7TaxRateAmount) {
        this.taxBracket7TaxRateAmount = taxBracket7TaxRateAmount;
    }

    public BigDecimal getMedicalAidCreditMainAmount() {
        return this.medicalAidCreditMainAmount;
    }

    public void setMedicalAidCreditMainAmount(BigDecimal medicalAidCreditMainAmount) {
        this.medicalAidCreditMainAmount = medicalAidCreditMainAmount;
    }

    public BigDecimal getMedicalAidCreditSecondaryAmount() {
        return this.medicalAidCreditSecondaryAmount;
    }

    public void setMedicalAidCreditSecondaryAmount(BigDecimal medicalAidCreditSecondaryAmount) {
        this.medicalAidCreditSecondaryAmount = medicalAidCreditSecondaryAmount;
    }

    @Override
    public String toString() {
        return "{" +
            " id='" + getId() + "'" +
            ", taxYear='" + getTaxYear() + "'" +
            ", taxBracket1='" + getTaxBracket1() + "'" +
            ", taxBracket1TaxRatePerc='" + getTaxBracket1TaxRatePerc() + "'" +
            ", taxBracket1TaxRateAmount='" + getTaxBracket1TaxRateAmount() + "'" +
            ", taxBracket2='" + getTaxBracket2() + "'" +
            ", taxBracket2TaxRatePerc='" + getTaxBracket2TaxRatePerc() + "'" +
            ", taxBracket2TaxRateAmount='" + getTaxBracket2TaxRateAmount() + "'" +
            ", taxBracket3='" + getTaxBracket3() + "'" +
            ", taxBracket3TaxRatePerc='" + getTaxBracket3TaxRatePerc() + "'" +
            ", taxBracket3TaxRateAmount='" + getTaxBracket3TaxRateAmount() + "'" +
            ", taxBracket4='" + getTaxBracket4() + "'" +
            ", taxBracket4TaxRatePerc='" + getTaxBracket4TaxRatePerc() + "'" +
            ", taxBracket4TaxRateAmount='" + getTaxBracket4TaxRateAmount() + "'" +
            ", taxBracket5='" + getTaxBracket5() + "'" +
            ", taxBracket5TaxRatePerc='" + getTaxBracket5TaxRatePerc() + "'" +
            ", taxBracket5TaxRateAmount='" + getTaxBracket5TaxRateAmount() + "'" +
            ", taxBracket6='" + getTaxBracket6() + "'" +
            ", taxBracket6TaxRatePerc='" + getTaxBracket6TaxRatePerc() + "'" +
            ", taxBracket6TaxRateAmount='" + getTaxBracket6TaxRateAmount() + "'" +
            ", taxBracket7='" + getTaxBracket7() + "'" +
            ", taxBracket7TaxRatePerc='" + getTaxBracket7TaxRatePerc() + "'" +
            ", taxBracket7TaxRateAmount='" + getTaxBracket7TaxRateAmount() + "'" +
            ", medicalAidCreditMainAmount='" + getMedicalAidCreditMainAmount() + "'" +
            ", medicalAidCreditSecondaryAmount='" + getMedicalAidCreditSecondaryAmount() + "'" +
            "}";
    }

}