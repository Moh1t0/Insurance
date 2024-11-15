package com.javacademy.insurance.brazilservice;

import com.javacademy.insurance.enums.TypeOfInsurance;
import com.javacademy.insurance.interfaces.InsuranceCalcService;
import org.springframework.stereotype.Component;

import java.math.BigDecimal;

@Component
public class InsuranceCalcBrazilService implements InsuranceCalcService {

    private final BrazilInsuranceProperty brazilInsuranceProperty;

    public InsuranceCalcBrazilService(BrazilInsuranceProperty brazilInsuranceProperty) {
        this.brazilInsuranceProperty = brazilInsuranceProperty;
    }

    @Override
    public BigDecimal calculateInsuranceCost(BigDecimal costOfCoverage, TypeOfInsurance typeOfInsurance) {
        if (typeOfInsurance == TypeOfInsurance.ROBBERY_PROTECTION) {
            return costOfCoverage.multiply(brazilInsuranceProperty.getRobberyCoefficient())
                                 .add(brazilInsuranceProperty.getRobberyBase());
        } else if (typeOfInsurance == TypeOfInsurance.MEDICAL_INSURANCE) {
            return costOfCoverage.multiply(brazilInsuranceProperty.getMedicalCoefficient())
                                  .add(brazilInsuranceProperty.getMedicalBase());
        } else {
            throw new IllegalArgumentException("Неизвестный тип страховки: " + typeOfInsurance);
        }
    }
}
