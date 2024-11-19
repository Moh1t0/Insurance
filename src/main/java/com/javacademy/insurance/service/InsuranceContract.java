package com.javacademy.insurance.service;

import com.javacademy.insurance.enums.ContractStatus;
import com.javacademy.insurance.enums.Country;
import com.javacademy.insurance.enums.Currency;
import com.javacademy.insurance.enums.TypeOfInsurance;
import lombok.Getter;
import lombok.RequiredArgsConstructor;
import lombok.Setter;
import lombok.extern.slf4j.Slf4j;
import java.math.BigDecimal;

@Slf4j
@RequiredArgsConstructor
@Getter
@Setter
public class InsuranceContract {

    private final String number; //Номер договора
    private final BigDecimal price; //Стоимость страховки
    private final BigDecimal costOfCoverage; //Сумма покрытия
    private final Currency currency;
    private final String fullName;
    private final Country country;
    private final TypeOfInsurance typeOfInsurance;
    private ContractStatus contractStatus = ContractStatus.UNPAID;
}

