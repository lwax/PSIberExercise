package com.psiberworks.service;


import org.junit.Before;
import org.junit.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import static org.mockito.Mockito.*;

import static org.junit.Assert.*;

import java.math.BigDecimal;

import com.psiberworks.models.TaxRebateThreshold;
import com.psiberworks.models.TaxTable;
import com.psiberworks.payloads.InputPayload;
import com.psiberworks.payloads.OutputPayload;
import com.psiberworks.repository.TaxRebateThresholdRepository;
import com.psiberworks.repository.TaxTableRepository;

public class AppServiceTest {
 
    @InjectMocks
    private AppService appService;
    
    @Mock
    private TaxTableRepository taxTableRepositoryMock;
    @Mock
    private TaxRebateThresholdRepository taxRebateThresholdRepositoryMock;
    @Before
    public void setUp() {
        appService = new AppService();

        MockitoAnnotations.initMocks(this);
    }
    

    @Test
    public void shouldReturnSuccess_whenAgeGroupPrimaryAndYear2017() {

        InputPayload inputPayload = new InputPayload();
        inputPayload.setAgeGroup("primary");
        inputPayload.setIsMonthOrYear("Monthly");
        inputPayload.setTaxableIncome(new BigDecimal("30000.00"));
        // inputPayload.setNumOfMedicalAidMembers(1);
        inputPayload.setTaxYear("2017");

        when(taxTableRepositoryMock.findByTaxYear("2017")).thenReturn(getTaxTable("2017", 1L));
        when(taxRebateThresholdRepositoryMock.findByAgeGroupAndYear("primary", "2017")).thenReturn(
                getTaxRebateThreshold("2017", "primary", 1L, new BigDecimal("13500.00"), new BigDecimal("75000.00")));

        // Mockito.when(appService)
        OutputPayload outputPayload = appService.calculateTax(inputPayload);

        assertEquals(outputPayload.getNet().stripTrailingZeros(), new BigDecimal("24301.67").stripTrailingZeros());

    }

    @Test
    public void shouldReturnSuccess_whenAgeGroupSecondaryAndYear2017(){
        

        InputPayload inputPayload = new InputPayload();
        inputPayload.setAgeGroup("secondary");
        inputPayload.setIsMonthOrYear("Monthly");
        inputPayload.setTaxableIncome(new BigDecimal("30000.00"));
        //inputPayload.setNumOfMedicalAidMembers(1);
        inputPayload.setTaxYear("2017");

        when(taxTableRepositoryMock.findByTaxYear("2017"))
            .thenReturn(getTaxTable("2017", 1L));
        when(taxRebateThresholdRepositoryMock.findByAgeGroupAndYear("secondary", "2017"))
            .thenReturn(getTaxRebateThreshold("2017", "secondary", 1L, new BigDecimal("7407.00"),
                        new BigDecimal("116150.00")));

        //Mockito.when(appService)
       OutputPayload outputPayload = appService.calculateTax(inputPayload);


       assertEquals(outputPayload.getNet().stripTrailingZeros(), new BigDecimal("23793.92").stripTrailingZeros());

    }


    @Test
    public void shouldReturnSuccess_whenAgeGroupTertiaryAndYear2017() {

        InputPayload inputPayload = new InputPayload();
        inputPayload.setAgeGroup("tertiary");
        inputPayload.setIsMonthOrYear("Monthly");
        inputPayload.setTaxableIncome(new BigDecimal("30000.00"));
        // inputPayload.setNumOfMedicalAidMembers(1);
        inputPayload.setTaxYear("2017");

        when(taxTableRepositoryMock.findByTaxYear("2017")).thenReturn(getTaxTable("2017", 1L));
        when(taxRebateThresholdRepositoryMock.findByAgeGroupAndYear("tertiary", "2017"))
                .thenReturn(getTaxRebateThreshold("2017", "tertiary", 1L, new BigDecimal("2466.00"), 
                        new BigDecimal("129850.00")));

        // Mockito.when(appService)
        OutputPayload outputPayload = appService.calculateTax(inputPayload);

        assertEquals(outputPayload.getNet().stripTrailingZeros(), new BigDecimal("23382.17").stripTrailingZeros());

    }



    private TaxTable getTaxTable(String year, long id) {
        TaxTable taxTable = new TaxTable();
        taxTable.setId(id);
        taxTable.setTaxYear(year);

        // Medical Aid Tax Credits
        taxTable.setMedicalAidCreditMainAmount(new BigDecimal("286.00"));
        taxTable.setMedicalAidCreditSecondaryAmount(new BigDecimal("192.00"));

        // Tax Bracket 1
        taxTable.setTaxBracket1(new BigDecimal("188000.00"));
        taxTable.setTaxBracket1TaxRatePerc(new BigDecimal("0.18"));
        taxTable.setTaxBracket1TaxRateAmount(new BigDecimal("0.00"));

        // Tax Bracket 2
        taxTable.setTaxBracket2(new BigDecimal("293600.00"));
        taxTable.setTaxBracket2TaxRatePerc(new BigDecimal("0.26"));
        taxTable.setTaxBracket2TaxRateAmount(new BigDecimal("33840.00"));

        // Tax Bracket 3
        taxTable.setTaxBracket3(new BigDecimal("406400.00"));
        taxTable.setTaxBracket3TaxRatePerc(new BigDecimal("0.31"));
        taxTable.setTaxBracket3TaxRateAmount(new BigDecimal("61296"));

        // Tax Bracket 4
        taxTable.setTaxBracket4(new BigDecimal("550100.00"));
        taxTable.setTaxBracket4TaxRatePerc(new BigDecimal("0.36"));
        taxTable.setTaxBracket4TaxRateAmount(new BigDecimal("96264.00"));

        // Tax Bracket 5
        taxTable.setTaxBracket5(new BigDecimal("701300.00"));
        taxTable.setTaxBracket5TaxRatePerc(new BigDecimal("0.39"));
        taxTable.setTaxBracket5TaxRateAmount(new BigDecimal("147996.00"));

        // Tax Bracket 6
        taxTable.setTaxBracket6(new BigDecimal("701301.00"));
        taxTable.setTaxBracket6TaxRatePerc(new BigDecimal("0.41"));
        taxTable.setTaxBracket6TaxRateAmount(new BigDecimal("206964.00"));

        return taxTable;
    }

    public TaxRebateThreshold getTaxRebateThreshold(String year, String ageGroup, long id, BigDecimal rebate, 
            BigDecimal threshold) {
        TaxRebateThreshold taxRebateThreshold = new TaxRebateThreshold();

        taxRebateThreshold.setId(id);
        taxRebateThreshold.setAgeGroup(ageGroup);
        taxRebateThreshold.setYear(year);
        taxRebateThreshold.setRebate(rebate);
        taxRebateThreshold.setThreshold(threshold);
        return taxRebateThreshold;

    }
}
