package com.psiberworks.repository;

import com.psiberworks.models.TaxRebateThreshold;

import org.springframework.data.jpa.repository.JpaRepository;

public interface TaxRebateThresholdRepository extends JpaRepository<TaxRebateThreshold, Long> {
    TaxRebateThreshold findByAgeGroupAndYear(String ageGroup, String year);
}