package com.psiberworks.controller;

import static org.junit.Assert.*;

import java.math.BigDecimal;

import com.psiberworks.App;
import com.psiberworks.models.TaxTable;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.context.SpringBootTest.WebEnvironment;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.test.context.junit4.SpringRunner;

import io.restassured.RestAssured;
import io.restassured.response.Response;

@RunWith(SpringRunner.class)
@SpringBootTest(classes = { App.class }, webEnvironment 
  = WebEnvironment.DEFINED_PORT)
  
public class TaxTableControllerTest {

    private static final String API_ROOT
      = "http://localhost:8084/api/taxTables";


  @Test
  public void whenGetTaxTables_thenOK() {
    Response response = RestAssured.get(API_ROOT);
    assertEquals(HttpStatus.OK.value(), response.getStatusCode());
  }
    
  @Test
  public void whenGetTaxTableByTaxYear_thenOK() {

    TaxTable taxTable = createTaxTable("2017", 1L);
    createTaxTableAsUri(taxTable);

    Response response = RestAssured.get(API_ROOT + "/taxYear/" + taxTable.getTaxYear());
    assertEquals(HttpStatus.OK.value(), response.getStatusCode());
    assertEquals(taxTable.getTaxBracket1().stripTrailingZeros(), new BigDecimal(Float.toString(response.jsonPath().get("taxBracket1"))).stripTrailingZeros());

  }

  @Test
  public void whenGetTaxTableById_thenOK() {

    TaxTable taxTable = createTaxTable("2018", 2L);
    String location = createTaxTableAsUri(taxTable);
    Response response = RestAssured.get(location);

    assertEquals(HttpStatus.OK.value(), response.getStatusCode());
    assertEquals(taxTable.getTaxBracket2().stripTrailingZeros(), new BigDecimal(Float.toString(response.jsonPath().get("taxBracket2"))).stripTrailingZeros());
    
  }

  private TaxTable createTaxTable(String year, long id) {
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
 
    private String createTaxTableAsUri(TaxTable taxTable) {
        Response response = RestAssured.given()
          .contentType(MediaType.APPLICATION_JSON_VALUE)
          .body(taxTable)
          .post(API_ROOT);
        return API_ROOT + "/" + response.jsonPath().get("id");
    }

}