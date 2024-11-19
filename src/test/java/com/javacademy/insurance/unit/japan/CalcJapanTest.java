package com.javacademy.insurance.unit.japan;

import com.javacademy.insurance.enums.TypeOfInsurance;
import com.javacademy.insurance.service.japan.InsuranceCalcJapanService;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.ActiveProfiles;

import java.math.BigDecimal;

@SpringBootTest
@ActiveProfiles({"japan"})
public class CalcJapanTest {

    private static final BigDecimal COVERAGE_AMOUNT_OF_ROBBERY = BigDecimal.valueOf(1_000_000);
    private static final BigDecimal EXPECTED_OF_ROBBERY = BigDecimal.valueOf(20_000);
    private static final BigDecimal COVERAGE_AMOUNT_OF_MEDICAL = BigDecimal.valueOf(10_000_000);
    private static final BigDecimal EXPECTED_OF_MEDICAL = BigDecimal.valueOf(162_000);

    @Autowired
    private InsuranceCalcJapanService insuranceCalcJapanService;

    @Test
    @DisplayName("Рассчитать стоимость страховки при грабеже")
    public void calculateRobberyInsuranceTest() {

        BigDecimal insuranceCost = insuranceCalcJapanService
                .calculateInsuranceCost(COVERAGE_AMOUNT_OF_ROBBERY, TypeOfInsurance.ROBBERY_PROTECTION);
        BigDecimal expected = EXPECTED_OF_ROBBERY;
        int exp = expected.compareTo(insuranceCost);

        Assertions.assertEquals(0, exp);
    }

    @Test
    @DisplayName("Рассчитать стоимость страховки при мед страховке")
    public void calculateMedicalInsuranceTest() {
        BigDecimal insuranceCost = insuranceCalcJapanService
                .calculateInsuranceCost(COVERAGE_AMOUNT_OF_MEDICAL, TypeOfInsurance.MEDICAL_INSURANCE);
        BigDecimal expected = EXPECTED_OF_MEDICAL;
        int exp = expected.compareTo(insuranceCost);
        Assertions.assertEquals(0, exp);
    }

}
