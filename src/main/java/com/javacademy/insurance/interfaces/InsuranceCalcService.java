package com.javacademy.insurance.interfaces;

import com.javacademy.insurance.enums.TypeOfInsurance;

import java.math.BigDecimal;

@FunctionalInterface
public interface InsuranceCalcService {
    BigDecimal calculateInsuranceCost(BigDecimal costOfCoverage, TypeOfInsurance typeOfInsurance);
}
