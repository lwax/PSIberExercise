package com.psiberworks.repository;


import com.psiberworks.models.TaxTable;

import org.springframework.data.jpa.repository.JpaRepository;

public interface TaxTableRepository  extends JpaRepository<TaxTable, Long>{
        TaxTable findByTaxYear(String taxYear);
}