package com.psiberworks.controller;

import java.util.List;

import com.psiberworks.exceptionHandlers.TaxTableIdMismatchException;
import com.psiberworks.exceptionHandlers.TaxTableNotFoundException;
import com.psiberworks.models.TaxTable;
import com.psiberworks.repository.TaxTableRepository;

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
@RequestMapping("/api/taxTables")
public class TaxTableController {

    @Autowired
    private TaxTableRepository taxTableRepository;

    @GetMapping
    public List<TaxTable> findAll() {
        return taxTableRepository.findAll();
    }


    @GetMapping("/taxYear/{taxYear}")
    public TaxTable findByTaxYear(@PathVariable String taxYear) {
        return taxTableRepository.findByTaxYear(taxYear);
    }

    @GetMapping("/{id}")
    public TaxTable findOne(@PathVariable Long id) {
        return taxTableRepository.findById(id).orElseThrow(TaxTableNotFoundException::new);
    }

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public TaxTable create(@RequestBody TaxTable taxTable) {
        return taxTableRepository.save(taxTable);
    }

    @DeleteMapping("/{id}")
    public void delete(@PathVariable Long id) {
        taxTableRepository.findById(id).orElseThrow(TaxTableNotFoundException::new);
        taxTableRepository.deleteById(id);
    }

    @PutMapping("/{id}")
    public TaxTable updateTaxTable(@RequestBody TaxTable taxTable, @PathVariable Long id) {
        if (taxTable.getId() != id) {
            throw new TaxTableIdMismatchException();
        }
        taxTableRepository.findById(id).orElseThrow(TaxTableNotFoundException::new);
        return taxTableRepository.save(taxTable);
    }
}