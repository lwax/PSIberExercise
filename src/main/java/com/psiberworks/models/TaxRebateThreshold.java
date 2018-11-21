package com.psiberworks.models;

import java.math.BigDecimal;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;

@Entity
public class TaxRebateThreshold {


    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long id;

    @Column(nullable = false)
    private String year;

    @Column(nullable = false)
    private String ageGroup;

    @Column(nullable = false)
    private BigDecimal rebate;

    @Column(nullable = false)
    private BigDecimal threshold;

    public long getId() {
        return this.id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getYear() {
        return this.year;
    }

    public void setYear(String year) {
        this.year = year;
    }
    public String getAgeGroup() {
        return this.ageGroup;
    }

    public void setAgeGroup(String ageGroup) {
        this.ageGroup = ageGroup;
    }

    public BigDecimal getRebate() {
        return this.rebate;
    }

    public void setRebate(BigDecimal rebate) {
        this.rebate = rebate;
    }

    public BigDecimal getThreshold() {
        return this.threshold;
    }

    public void setThreshold(BigDecimal threshold) {
        this.threshold = threshold;
    }



    @Override
    public String toString() {
        return "{" +
            " id='" + getId() + "'" +
            ", year='" + getYear() + "'" +
            ", ageGroup='" + getAgeGroup() + "'" +
            ", rebate='" + getRebate() + "'" +
            ", threshold='" + getThreshold() + "'" +
            "}";
    }

}
