package com.javacademy.insurance.unit.brazil;

import com.javacademy.insurance.service.brazil.InsuranceCalcBrazilService;
import com.javacademy.insurance.enums.TypeOfInsurance;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.ActiveProfiles;

import java.math.BigDecimal;

@SpringBootTest
@ActiveProfiles({"brazil"})
public class InsuranceCalcBrazilServiceTest {

    private static final BigDecimal COVERAGE_AMOUNT_OF_ROBBERY = BigDecimal.valueOf(50_000);
    private static final BigDecimal COVERAGE_AMOUNT_OF_MEDICAL = BigDecimal.valueOf(200_000);
    private static final BigDecimal EXPECTED_OF_ROBBERY = BigDecimal.valueOf(2_800);
    private static final BigDecimal EXPECTED_OF_MEDICAL = BigDecimal.valueOf(6_800);

    @Autowired
    private InsuranceCalcBrazilService insuranceCalcBrazilService;

    @Test
    @DisplayName("Рассчитать стоимость страховки при грабеже")
    public void calculateRobberyInsuranceTest() {
        BigDecimal insuranceCost = insuranceCalcBrazilService
                .calculateInsuranceCost(COVERAGE_AMOUNT_OF_ROBBERY, TypeOfInsurance.ROBBERY_PROTECTION);
        BigDecimal expected = EXPECTED_OF_ROBBERY;
        int exp = expected.compareTo(insuranceCost);

        Assertions.assertEquals(0, exp);
    }

    @Test
    @DisplayName("Рассчитать стоимость страховки при мед страховке")
    public void calculateMedicalInsuranceTest() {
        BigDecimal insuranceCost = insuranceCalcBrazilService
                .calculateInsuranceCost(COVERAGE_AMOUNT_OF_MEDICAL, TypeOfInsurance.MEDICAL_INSURANCE);
        BigDecimal expected = EXPECTED_OF_MEDICAL;
        int exp = expected.compareTo(insuranceCost);

        Assertions.assertEquals(0, exp);
    }

}
