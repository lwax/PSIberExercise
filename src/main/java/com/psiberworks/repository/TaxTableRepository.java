package com.psiberworks.repository;


import com.psiberworks.models.TaxTable;

import org.springframework.data.repository.CrudRepository;

public interface TaxTableRepository  extends CrudRepository<TaxTable, Long>{
        TaxTable findByTaxYear(String taxYear);
}