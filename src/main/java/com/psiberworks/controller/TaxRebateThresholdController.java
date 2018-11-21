package com.psiberworks.controller;

import com.psiberworks.exceptionHandlers.TaxTableIdMismatchException;
import com.psiberworks.exceptionHandlers.TaxTableNotFoundException;
import com.psiberworks.models.TaxRebateThreshold;
import com.psiberworks.repository.TaxRebateThresholdRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.http.HttpStatus;

@RestController
@RequestMapping("/api/taxRebateThresholds")
public class TaxRebateThresholdController {

    @Autowired
    private TaxRebateThresholdRepository taxRebateThresholdRepository;

    @GetMapping
    public Iterable findAll() {
        return taxRebateThresholdRepository.findAll();
    }

    @GetMapping("/ageGroup/{ageGroup}")
    public TaxRebateThreshold findByAgeGroup(@PathVariable String ageGroup, @PathVariable String year) {
        return taxRebateThresholdRepository.findByAgeGroupAndYear(ageGroup, year);
    }

    @GetMapping("/{id}")
    public TaxRebateThreshold findOne(@PathVariable Long id) {
        return taxRebateThresholdRepository.findById(id).orElseThrow(TaxTableNotFoundException::new);
    }

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public TaxRebateThreshold create(@RequestBody TaxRebateThreshold taxTable) {
        return taxRebateThresholdRepository.save(taxTable);
    }

    @DeleteMapping("/{id}")
    public void delete(@PathVariable Long id) {
        taxRebateThresholdRepository.findById(id).orElseThrow(TaxTableNotFoundException::new);
        taxRebateThresholdRepository.deleteById(id);
    }

    @PutMapping("/{id}")
    public TaxRebateThreshold updateBook(@RequestBody TaxRebateThreshold taxTable, @PathVariable Long id) {
        if (taxTable.getId() != id) {
            throw new TaxTableIdMismatchException();
        }
        taxRebateThresholdRepository.findById(id).orElseThrow(TaxTableNotFoundException::new);
        return taxRebateThresholdRepository.save(taxTable);
    }
}