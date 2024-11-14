package com.javacademy.insurance.service;

import com.javacademy.insurance.enums.ContractStatus;
import com.javacademy.insurance.enums.Country;
import com.javacademy.insurance.enums.Currency;
import com.javacademy.insurance.enums.TypeOfInsurance;
import lombok.AccessLevel;
import lombok.Data;
import lombok.experimental.FieldDefaults;
import lombok.extern.slf4j.Slf4j;
import java.math.BigDecimal;

@Slf4j
@FieldDefaults(level = AccessLevel.PRIVATE)
@Data
public class InsuranceContract {

     String number; //Номер договора
     BigDecimal price; //Стоимость страховки
     BigDecimal costOfCoverage; //Сумма покрытия
     Currency currency;
     FullName fullName;
     Country country;
     TypeOfInsurance typeOfInsurance;
     ContractStatus contractStatus;

     public InsuranceContract(String number, BigDecimal price, BigDecimal costOfCoverage,
                              Currency currency, FullName fullName, Country country,
                              TypeOfInsurance typeOfInsurance, ContractStatus contractStatus) {
          this.number = number;
          this.price = price;
          this.costOfCoverage = costOfCoverage;
          this.currency = currency;
          this.fullName = fullName;
          this.country = country;
          this.typeOfInsurance = typeOfInsurance;
          this.contractStatus = contractStatus;
     }
}

