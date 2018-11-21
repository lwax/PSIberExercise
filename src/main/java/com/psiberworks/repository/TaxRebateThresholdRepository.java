package com.psiberworks.repository;

import com.psiberworks.models.TaxRebateThreshold;

import org.springframework.data.repository.CrudRepository;

public interface TaxRebateThresholdRepository extends CrudRepository<TaxRebateThreshold, Long> {
    TaxRebateThreshold findByAgeGroupAndYear(String ageGroup, String year);
}