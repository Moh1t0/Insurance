package com.javacademy.insurance.service;

import com.javacademy.insurance.enums.ContractStatus;
import com.javacademy.insurance.enums.Country;
import com.javacademy.insurance.enums.Currency;
import com.javacademy.insurance.enums.TypeOfInsurance;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.extern.slf4j.Slf4j;
import java.math.BigDecimal;

@Slf4j
@Data
@AllArgsConstructor
public class InsuranceContract {

    private String number; //Номер договора
    private BigDecimal price; //Стоимость страховки
    private BigDecimal costOfCoverage; //Сумма покрытия
    private Currency currency;
    private String fullName;
    private Country country;
    private TypeOfInsurance typeOfInsurance;
    private ContractStatus contractStatus;
}

