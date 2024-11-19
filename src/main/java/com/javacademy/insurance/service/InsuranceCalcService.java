package com.javacademy.insurance.service;

import com.javacademy.insurance.enums.TypeOfInsurance;
import java.math.BigDecimal;

@FunctionalInterface
public interface InsuranceCalcService {
    BigDecimal calculateInsuranceCost(BigDecimal costOfCoverage, TypeOfInsurance typeOfInsurance);
}
