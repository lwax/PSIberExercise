package com.psiberworks.service;

import java.math.BigDecimal;
import java.math.RoundingMode;

import com.psiberworks.models.TaxRebateThreshold;
import com.psiberworks.models.TaxTable;
import com.psiberworks.payloads.*;
import com.psiberworks.repository.TaxRebateThresholdRepository;
import com.psiberworks.repository.TaxTableRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

@Component
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


        if(inputPayload.getIsMonthOrYear().equals("Monthly")){
            BigDecimal yearlyIncome =  inputPayload.getTaxableIncome().multiply(new BigDecimal("12"));

            inputPayload.setTaxableIncomeMonthly(inputPayload.getTaxableIncome());
            inputPayload.setTaxableIncomeYearly(yearlyIncome);
        }
        else{
            BigDecimal monthlyIncome = inputPayload.getTaxableIncome().divide(new BigDecimal("12"), 2, RoundingMode.HALF_UP);

            inputPayload.setTaxableIncomeMonthly(monthlyIncome);
            inputPayload.setTaxableIncomeYearly(inputPayload.getTaxableIncome());
        }

        if( inputPayload.getTaxableIncomeYearly().compareTo(taxRebateThreshold.getThreshold()) > 0 &&
                inputPayload.getTaxableIncomeYearly().compareTo(taxTable.getTaxBracket1()) <= 0){
                    BigDecimal tax = inputPayload.getTaxableIncomeYearly().multiply(taxTable.getTaxBracket1TaxRatePerc());
                    outputPayload.setAnnualTax(tax);
                    outputPayload.setMonthlyTax(tax.divide(new BigDecimal("12"), 2, RoundingMode.HALF_UP));
        }

        else if( inputPayload.getTaxableIncomeYearly().compareTo(taxTable.getTaxBracket1()) > 0 && 
                 inputPayload.getTaxableIncomeYearly().compareTo(taxTable.getTaxBracket2()) <= 0) {

            populateAnnualAndMonthlyTax(outputPayload, inputPayload.getTaxableIncomeYearly(), 
                                        taxTable.getTaxBracket1(), taxTable.getTaxBracket2(), 
                                        taxTable.getTaxBracket2TaxRateAmount(), taxTable.getTaxBracket2TaxRatePerc());
        }


        else if (inputPayload.getTaxableIncomeYearly().compareTo(taxTable.getTaxBracket2()) > 0
                && inputPayload.getTaxableIncomeYearly().compareTo(taxTable.getTaxBracket3()) <= 0) {

            populateAnnualAndMonthlyTax(outputPayload, inputPayload.getTaxableIncomeYearly(), taxTable.getTaxBracket2(),
                    taxTable.getTaxBracket3(), taxTable.getTaxBracket3TaxRateAmount(),
                    taxTable.getTaxBracket3TaxRatePerc());
        }

        else if (inputPayload.getTaxableIncomeYearly().compareTo(taxTable.getTaxBracket3()) > 0
                && inputPayload.getTaxableIncomeYearly().compareTo(taxTable.getTaxBracket4()) <= 0) {

            populateAnnualAndMonthlyTax(outputPayload, inputPayload.getTaxableIncomeYearly(), taxTable.getTaxBracket3(),
                    taxTable.getTaxBracket4(), taxTable.getTaxBracket4TaxRateAmount(),
                    taxTable.getTaxBracket4TaxRatePerc());
        }

        else if (inputPayload.getTaxableIncomeYearly().compareTo(taxTable.getTaxBracket4()) > 0
                && inputPayload.getTaxableIncomeYearly().compareTo(taxTable.getTaxBracket5()) <= 0) {

            populateAnnualAndMonthlyTax(outputPayload, inputPayload.getTaxableIncomeYearly(), taxTable.getTaxBracket4(),
                    taxTable.getTaxBracket5(), taxTable.getTaxBracket5TaxRateAmount(),
                    taxTable.getTaxBracket5TaxRatePerc());
        }

        else if (inputPayload.getTaxableIncomeYearly().compareTo(taxTable.getTaxBracket5()) > 0
                && inputPayload.getTaxableIncomeYearly().compareTo(taxTable.getTaxBracket6()) <= 0) {

            populateAnnualAndMonthlyTax(outputPayload, inputPayload.getTaxableIncomeYearly(), taxTable.getTaxBracket5(),
                    taxTable.getTaxBracket6(), taxTable.getTaxBracket6TaxRateAmount(),
                    taxTable.getTaxBracket6TaxRatePerc());
        }


        else{
            outputPayload.setAnnualTax(new BigDecimal("0"));
            outputPayload.setMonthlyTax(new BigDecimal("0"));
        }

        populateMedicalAidTaxCredits(outputPayload, inputPayload.getNumOfMedicalAidMembers(), taxTable.getMedicalAidCreditMainAmount(), taxTable.getMedicalAidCreditSecondaryAmount());
        outputPayload.setTaxCredits(outputPayload.getMedicalAidTaxCredits().add(taxRebateThreshold.getRebate()));
        outputPayload.setAnnualTaxAfterCredits(outputPayload.getAnnualTax().subtract(outputPayload.getTaxCredits()));
        outputPayload.setMonthlyTaxAfterCredits(outputPayload.getAnnualTaxAfterCredits().divide(new BigDecimal("12"), 2, RoundingMode.HALF_UP));
        outputPayload.setNet(inputPayload.getTaxableIncomeMonthly().subtract(outputPayload.getMonthlyTaxAfterCredits()));

        return outputPayload;
    } 

    private void populateAnnualAndMonthlyTax(OutputPayload outputPayload, BigDecimal taxableIncomeYearly,
                                                BigDecimal previousTaxBracket, BigDecimal taxBracket,
                                                BigDecimal taxRateAmount, BigDecimal taxRatePercentage){
                    
        BigDecimal tax = (taxableIncomeYearly.subtract(previousTaxBracket)).multiply(taxRatePercentage);
        tax = tax.add(taxRateAmount);
        outputPayload.setAnnualTax(tax);
        outputPayload.setMonthlyTax(tax.divide(new BigDecimal("12"), 2, RoundingMode.HALF_UP));
    }

    private void populateMedicalAidTaxCredits(OutputPayload outputPayload,int numOfMembers, BigDecimal mainAmount, BigDecimal secondaryAmount){

        BigDecimal medicalAidTaxCredits = new BigDecimal("0");
        if(numOfMembers > 0 && numOfMembers <=2){
            BigDecimal tempCredits = new BigDecimal(numOfMembers).multiply(mainAmount);
            medicalAidTaxCredits.add(tempCredits.multiply(new BigDecimal("12")));
        }
        else if(numOfMembers >2){

            int remainingMembers = numOfMembers - 2;
            BigDecimal mainMembersCredits = new BigDecimal(2).multiply(mainAmount);
            BigDecimal remainingMembersCredits = new BigDecimal(remainingMembers).multiply(secondaryAmount);
            BigDecimal tempCredits = remainingMembersCredits.add(mainMembersCredits);
            medicalAidTaxCredits.add(tempCredits.multiply(new BigDecimal("12")));
        }

        outputPayload.setMedicalAidTaxCredits(medicalAidTaxCredits);
    }

}