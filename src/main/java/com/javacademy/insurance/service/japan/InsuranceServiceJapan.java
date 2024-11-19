package com.javacademy.insurance.service.japan;

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
@Profile("japan")
public class InsuranceServiceJapan extends AbstractInsuranceService {

    private final InsuranceCalcJapanService insuranceCalcJapanService;

    public InsuranceServiceJapan(Archive archive, ContractNumberGenerator contractNumberGenerator,
                                 InsuranceCalcJapanService insuranceCalcJapanService) {
        super(archive, contractNumberGenerator);
        this.insuranceCalcJapanService = insuranceCalcJapanService;
    }

    @Override
    protected BigDecimal calculateInsuranceCost(BigDecimal costOfCoverage, TypeOfInsurance typeOfInsurance) {
        return insuranceCalcJapanService.calculateInsuranceCost(costOfCoverage, typeOfInsurance);
    }

    @Override
    protected Currency getCurrency() {
        return Currency.JPY;
    }

    @Override
    protected Country getCountry() {
        return Country.JAPAN;
    }
}



























