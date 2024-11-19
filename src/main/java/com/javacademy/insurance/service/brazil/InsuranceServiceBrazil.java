package com.javacademy.insurance.service.brazil;

import com.javacademy.insurance.enums.Country;
import com.javacademy.insurance.enums.Currency;
import com.javacademy.insurance.enums.TypeOfInsurance;
import com.javacademy.insurance.service.AbstractInsuranceService;
import com.javacademy.insurance.service.Archive;
import com.javacademy.insurance.service.ContractNumberGenerator;
import org.springframework.context.annotation.Profile;
import org.springframework.stereotype.Component;
import java.math.BigDecimal;

@Component
@Profile("brazil")
public class InsuranceServiceBrazil extends AbstractInsuranceService {

    private final InsuranceCalcBrazilService insuranceCalcBrazilService;

    public InsuranceServiceBrazil(Archive archive, ContractNumberGenerator contractNumberGenerator,
                                  InsuranceCalcBrazilService insuranceCalcBrazilService) {
        super(archive, contractNumberGenerator);
        this.insuranceCalcBrazilService = insuranceCalcBrazilService;
    }

    @Override
    protected BigDecimal calculateInsuranceCost(BigDecimal costOfCoverage, TypeOfInsurance typeOfInsurance) {
        return insuranceCalcBrazilService.calculateInsuranceCost(costOfCoverage, typeOfInsurance);
    }

    @Override
    protected Currency getCurrency() {
        return Currency.BRL;
    }

    @Override
    protected Country getCountry() {
        return Country.BRAZIL;
    }
}
