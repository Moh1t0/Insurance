package com.javacademy.insurance.it.japan;

import com.javacademy.insurance.enums.ContractStatus;
import com.javacademy.insurance.enums.Country;
import com.javacademy.insurance.enums.Currency;
import com.javacademy.insurance.enums.TypeOfInsurance;
import com.javacademy.insurance.exceptions.ContractNotFoundException;
import com.javacademy.insurance.japanservice.InsuranceCalcJapanService;
import com.javacademy.insurance.japanservice.InsuranceServiceJapan;
import com.javacademy.insurance.japanservice.JapanInsuranceProperty;
import com.javacademy.insurance.service.Archive;
import com.javacademy.insurance.service.ContractNumberGenerator;
import com.javacademy.insurance.service.InsuranceContract;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.annotation.DirtiesContext;
import org.springframework.test.context.ActiveProfiles;

import java.math.BigDecimal;
import java.util.Map;

@SpringBootTest
@ActiveProfiles({"japan"})
@DirtiesContext(classMode = DirtiesContext.ClassMode.BEFORE_EACH_TEST_METHOD)
public class InsuranceServiceJapanTest {

    private static final BigDecimal COVERAGE_AMOUNT_OF_ROBBERY = BigDecimal.valueOf(1_000_000);
    private static final BigDecimal COVERAGE_AMOUNT_OF_MEDICAL = BigDecimal.valueOf(10_000_000);
    private static final BigDecimal EXPECTED_OF_ROBBERY = BigDecimal.valueOf(20_000);
    private static final BigDecimal EXPECTED_OF_MEDICAL = BigDecimal.valueOf(162_000);

    @Autowired
    InsuranceServiceJapan insuranceServiceJapan;
    @Autowired
    JapanInsuranceProperty japanInsuranceProperty;
    @MockBean
    InsuranceCalcJapanService insuranceCalcJapanService;
    @MockBean
    Archive archive;
    @MockBean
    ContractNumberGenerator contractNumberGenerator;

    @Test
    @DisplayName("Получить предложение по страховке от грабежей")
    public void successInsuranceOfRobbery() {

        Mockito.when(contractNumberGenerator.generateContractNumber()).thenReturn("001");
        Mockito.when(insuranceCalcJapanService
                .calculateInsuranceCost(
                        COVERAGE_AMOUNT_OF_ROBBERY,
                        TypeOfInsurance.ROBBERY_PROTECTION))
                .thenReturn(EXPECTED_OF_ROBBERY);

        String fullName = ("Иванов Иван Иванович");
        BigDecimal coverageAmount = COVERAGE_AMOUNT_OF_ROBBERY;
        TypeOfInsurance type = TypeOfInsurance.ROBBERY_PROTECTION;

        InsuranceContract insuranceContract = insuranceServiceJapan.offerInsurance(coverageAmount, fullName, type);

        Assertions.assertEquals("001", insuranceContract.getNumber());
        Assertions.assertEquals(EXPECTED_OF_ROBBERY, insuranceContract.getPrice());
        Assertions.assertEquals(COVERAGE_AMOUNT_OF_ROBBERY, insuranceContract.getCostOfCoverage());
        Assertions.assertEquals(Currency.JPY, insuranceContract.getCurrency());
        Assertions.assertEquals(fullName, insuranceContract.getFullName());
        Assertions.assertEquals(Country.JAPAN, insuranceContract.getCountry());
        Assertions.assertEquals(type, insuranceContract.getTypeOfInsurance());
        Assertions.assertEquals(ContractStatus.UNPAID, insuranceContract.getContractStatus());

    }

    @Test
    @DisplayName("Получить предложение по мед страховке")
    public void successInsuranceOfMedical() {
        Mockito.when(contractNumberGenerator.generateContractNumber()).thenReturn("001");
        Mockito.when(insuranceCalcJapanService
                        .calculateInsuranceCost(
                                COVERAGE_AMOUNT_OF_MEDICAL,
                                TypeOfInsurance.MEDICAL_INSURANCE))
                .thenReturn(EXPECTED_OF_MEDICAL);

        String fullName = ("Иванов Иван Иванович");
        BigDecimal coverageAmount = COVERAGE_AMOUNT_OF_MEDICAL;
        TypeOfInsurance type = TypeOfInsurance.MEDICAL_INSURANCE;

        InsuranceContract insuranceContract = insuranceServiceJapan.offerInsurance(coverageAmount, fullName, type);

        Assertions.assertEquals("001", insuranceContract.getNumber());
        Assertions.assertEquals(EXPECTED_OF_MEDICAL, insuranceContract.getPrice());
        Assertions.assertEquals(COVERAGE_AMOUNT_OF_MEDICAL, insuranceContract.getCostOfCoverage());
        Assertions.assertEquals(Currency.JPY, insuranceContract.getCurrency());
        Assertions.assertEquals(fullName, insuranceContract.getFullName());
        Assertions.assertEquals(Country.JAPAN, insuranceContract.getCountry());
        Assertions.assertEquals(type, insuranceContract.getTypeOfInsurance());
        Assertions.assertEquals(ContractStatus.UNPAID, insuranceContract.getContractStatus());
    }

    @Test
    @DisplayName("Оплата страховки")
    public void successPay() throws ContractNotFoundException {
        Mockito.when(contractNumberGenerator.generateContractNumber()).thenReturn("001");
        Mockito.when(insuranceCalcJapanService
                        .calculateInsuranceCost(
                                COVERAGE_AMOUNT_OF_MEDICAL,
                                TypeOfInsurance.MEDICAL_INSURANCE))
                .thenReturn(EXPECTED_OF_MEDICAL);


        String fullName = ("Иванов Иван Иванович");
        BigDecimal coverageAmount = COVERAGE_AMOUNT_OF_MEDICAL;
        TypeOfInsurance type = TypeOfInsurance.MEDICAL_INSURANCE;

        InsuranceContract insuranceContract = insuranceServiceJapan.offerInsurance(coverageAmount, fullName, type);
        Mockito.when(archive.getContracts()).thenReturn(Map.of("001", insuranceContract));
        InsuranceContract result = insuranceServiceJapan.payInsurance("001");

        Assertions.assertNotNull(result);
        Assertions.assertEquals("001", result.getNumber());
        Assertions.assertEquals(EXPECTED_OF_MEDICAL, result.getPrice());
        Assertions.assertEquals(COVERAGE_AMOUNT_OF_MEDICAL, result.getCostOfCoverage());
        Assertions.assertEquals(Currency.JPY, result.getCurrency());
        Assertions.assertEquals(fullName, result.getFullName());
        Assertions.assertEquals(Country.JAPAN, result.getCountry());
        Assertions.assertEquals(type, result.getTypeOfInsurance());
        Assertions.assertEquals(ContractStatus.PAID, result.getContractStatus());
    }
}
