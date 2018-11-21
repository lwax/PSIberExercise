package com.psiberworks.service;

import java.math.BigDecimal;

import com.psiberworks.models.TaxRebateThreshold;
import com.psiberworks.models.TaxTable;
import com.psiberworks.payloads.*;
import com.psiberworks.repository.TaxRebateThresholdRepository;
import com.psiberworks.repository.TaxTableRepository;

import org.springframework.beans.factory.annotation.Autowired;

public class AppService {

    @Autowired
    private TaxTableRepository taxTableRepository;

    @Autowired
    private TaxRebateThresholdRepository taxRebateThresholdRepository;

    public OutputPayload calculateTax(InputPayload inputPayload){

        OutputPayload outputPayload = new OutputPayload();

        TaxTable taxTable = taxTableRepository
                .findByTaxYear(inputPayload.getTaxYear());

        TaxRebateThreshold taxRebateThreshold = taxRebateThresholdRepository
                .findByAgeGroupAndYear(inputPayload.getAgeGroup(), inputPayload.getTaxYear());


        if(inputPayload.isMonthOrYear().equals("Monthly")){
            BigDecimal yearlyIncome =  inputPayload.getTaxableIncomeMonthly().multiply(new BigDecimal("12"));
            inputPayload.setTaxableIncomeYearly(yearlyIncome);
        }

        if( inputPayload.getTaxableIncomeYearly().compareTo(taxRebateThreshold.getThreshold()) > 0 &&
                inputPayload.getTaxableIncomeYearly().compareTo(taxTable.getTaxBracket1()) <= 0){
                    BigDecimal tax = inputPayload.getTaxableIncomeYearly().multiply(taxTable.getTaxBracket1TaxRatePerc());
                    outputPayload.setAnnualTax(tax);
                    outputPayload.setMonthlyTax(tax.divide(new BigDecimal("12")));
                }

                outputPayload.setNet(inputPayload.getTaxableIncomeMonthly().subtract(outputPayload.getMonthlyTax()));

        return outputPayload;
    } 
    


    // private void setAnnualTaxAndMonthlyTax(OutputPayload outputPayload, BigDecimal previousTaxBracket,
    //                         BigDecimal taxableIncomeYearly, BigDecimal taxBracket,  BigDecimal taxRateAmount, 
    //                         BigDecimal taxRatePercentage){
        
    //     BigDecimal tax ;
    //     if(taxableIncomeYearly.compareTo(previousTaxBracket) <= 0){
    //       tax  = taxableIncomeYearly.multiply(taxRatePercentage);
    //     }
    //     outputPayload.setAnnualTax(tax);
    //     outputPayload.setMonthlyTax(tax.divide(new BigDecimal("12")));
    // }

    //     if(inputPayload.getTaxableIncomeYearly() > taxThreshold && inputPayload.getTaxableIncomeYearly() <= 188000){
    //         BigDecimal tax = inputPayload.getTaxableIncomeYearly() * 0.18;
    //         outputPayload.setAnnualTax(tax);
    //         outputPayload.setMonthlyTax(tax/12);
    //     }

    //     else if(inputPayload.getTaxableIncomeYearly() > 188000 && inputPayload.getTaxableIncomeYearly() <= 293600){

    //         BigDecimal taxableIncome = (inputPayload.getTaxableIncomeYearly() - 188000) *  0.26;
    //         BigDecimal tax = 33840 + taxableIncome;
    //         outputPayload.setAnnualTax(tax);
    //         outputPayload.setMonthlyTax(tax/12);
    //     }

    //     else if(inputPayload.getTaxableIncomeYearly() > 293600 && inputPayload.getTaxableIncomeYearly() <= 406400){

    //         BigDecimal taxableIncome = (inputPayload.getTaxableIncomeYearly() - 293600) * 0.31;
    //         BigDecimal tax = (61296 + taxableIncome) - 20907;
    //         outputPayload.setAnnualTax(tax);
    //         outputPayload.setMonthlyTax(tax/12);
    //     }

    //     else if(inputPayload.getTaxableIncomeYearly() > 406400 && inputPayload.getTaxableIncomeYearly() <= 550100){

    //         BigDecimal taxableIncome = (inputPayload.getTaxableIncomeYearly() - 406400) *  0.36;
    //         BigDecimal tax = 96264 + taxableIncome;
    //         outputPayload.setAnnualTax(tax);
    //         outputPayload.setMonthlyTax(tax/12);
    //     }

    //     else if(inputPayload.getTaxableIncomeYearly() > 550100 && inputPayload.getTaxableIncomeYearly() <= 701300){

    //         BigDecimal taxableIncome = (inputPayload.getTaxableIncomeYearly() - 550100) *  0.39;
    //         BigDecimal tax = 147996 + taxableIncome;
    //         outputPayload.setAnnualTax(tax);
    //         outputPayload.setMonthlyTax(tax/12);
    //     }


    //     else if(inputPayload.getTaxableIncomeYearly() > 701300){

    //         BigDecimal taxableIncome = (inputPayload.getTaxableIncomeYearly() - 701300) *  0.41;
    //         BigDecimal tax = 206294 + taxableIncome;
    //         outputPayload.setAnnualTax(tax);
    //         outputPayload.setMonthlyTax(tax/12);
    //     }

    //     else{
    //         outputPayload.setAnnualTax(0);
    //         outputPayload.setMonthlyTax(0);
    //     }

    //     if(inputPayload.getNumOfMedicalAidMembers() > 0 && inputPayload.getNumOfMedicalAidMembers() <= 2){

    //         BigDecimal primaryDependents = 286 * 12;
    //         BigDecimal secondaryDependants = (286 * 2)* 12;
    //         if(inputPayload.getNumOfMedicalAidMembers() == 1){
    //             outputPayload.setMedicalAidTaxCredits(primaryDependents);
    //         }
    //         else{
    //             outputPayload.setMedicalAidTaxCredits(secondaryDependants);
    //         }
    //     }
    //     else if (inputPayload.getNumOfMedicalAidMembers() > 2){
    //         BigDecimal primaryDependents= (286 * 2) * 12;
    //         BigDecimal secondaryDependants = ((inputPayload.getNumOfMedicalAidMembers() - 2) * 192) * 12;
    //         outputPayload.setMedicalAidTaxCredits(primaryDependents + secondaryDependants);

    //     }
    //     else{
    //         outputPayload.setMedicalAidTaxCredits(0);
    //     }

    //     outputPayload.setTaxCredits(outputPayload.getMedicalAidTaxCredits() + taxRebate);
    //     outputPayload.setAnnualTaxAfterCredits(outputPayload.getAnnualTax() - outputPayload.getTaxCredits());
    //     outputPayload.setMonthlyTaxAfterCredits(outputPayload.getAnnualTaxAfterCredits()/12);
    //     outputPayload.setNet(inputPayload.getTaxableIncomeMonthly() - outputPayload.getMonthlyTaxAfterCredits());

    //     return outputPayload;

    // }

}