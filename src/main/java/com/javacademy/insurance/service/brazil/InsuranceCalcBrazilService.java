package com.javacademy.insurance.service.brazil;

import com.javacademy.insurance.enums.TypeOfInsurance;
import com.javacademy.insurance.service.InsuranceCalcService;
import lombok.RequiredArgsConstructor;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.context.annotation.Profile;
import org.springframework.stereotype.Component;
import java.math.BigDecimal;

@Component
@Profile("brazil")
@EnableConfigurationProperties(value = BrazilInsuranceProperty.class)
@RequiredArgsConstructor
public class InsuranceCalcBrazilService implements InsuranceCalcService {
    private final BrazilInsuranceProperty brazilInsuranceProperty;

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
