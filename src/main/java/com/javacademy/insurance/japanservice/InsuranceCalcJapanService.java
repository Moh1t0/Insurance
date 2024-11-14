package com.javacademy.insurance.japanservice;

import com.javacademy.insurance.enums.TypeOfInsurance;
import com.javacademy.insurance.interfaces.InsuranceCalcService;
import org.springframework.stereotype.Component;
import java.math.BigDecimal;

@Component
public class InsuranceCalcJapanService implements InsuranceCalcService {

   private final JapanInsuranceProperty japanInsuranceProperty;

    public InsuranceCalcJapanService(JapanInsuranceProperty japanInsuranceProperty) {
        this.japanInsuranceProperty = japanInsuranceProperty;
    }

    @Override
    public BigDecimal calculateInsuranceCost(BigDecimal costOfCoverage, TypeOfInsurance typeOfInsurance) {
        if (typeOfInsurance == TypeOfInsurance.ROBBERY_PROTECTION) {
            return costOfCoverage.multiply(japanInsuranceProperty.getRobberyCoefficient())
                                 .add(japanInsuranceProperty.getRobberyBase());
        } else if (typeOfInsurance == TypeOfInsurance.MEDICAL_INSURANCE) {
            return costOfCoverage.multiply(japanInsuranceProperty.getMedicalCoefficient())
                                 .add(japanInsuranceProperty.getMedicalBase());
        } else {
            throw new IllegalArgumentException("Неизвестный тип страховки: " + typeOfInsurance);
        }
    }
}
