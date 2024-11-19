package com.javacademy.insurance.service;

import com.javacademy.insurance.enums.TypeOfInsurance;
import com.javacademy.insurance.exceptions.ContractNotFoundException;

import java.math.BigDecimal;

public interface InsuranceService {
    InsuranceContract offerInsurance(BigDecimal costOfCoverage, String fullname, TypeOfInsurance typeOfInsurance);

    InsuranceContract payInsurance(String number) throws ContractNotFoundException;

}
