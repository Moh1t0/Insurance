package com.javacademy.insurance.japanservice;

import com.javacademy.insurance.service.Archive;
import com.javacademy.insurance.service.ContractNumberGenerator;
import com.javacademy.insurance.service.FullName;
import com.javacademy.insurance.service.InsuranceContract;
import com.javacademy.insurance.enums.ContractStatus;
import com.javacademy.insurance.enums.Country;
import com.javacademy.insurance.enums.Currency;
import com.javacademy.insurance.enums.TypeOfInsurance;
import com.javacademy.insurance.exceptions.ContractNotFoundException;
import com.javacademy.insurance.interfaces.InsuranceService;
import org.springframework.stereotype.Component;
import java.math.BigDecimal;

@Component
public class InsuranceServiceJapan implements InsuranceService {

    private final InsuranceCalcJapanService insuranceCalcJapanService;
    private final Archive archive;

    public InsuranceServiceJapan(InsuranceCalcJapanService insuranceCalcJapanService, Archive archive) {
        this.insuranceCalcJapanService = insuranceCalcJapanService;
        this.archive = archive;
    }

    @Override
    public InsuranceContract offerInsurance(BigDecimal costOfCoverage, FullName fullname,
                                            TypeOfInsurance typeOfInsurance) {
        String number = ContractNumberGenerator.generateContractNumber();
        BigDecimal insuranceCost = insuranceCalcJapanService.calculateInsuranceCost(costOfCoverage, typeOfInsurance);

        InsuranceContract contract = new InsuranceContract(number, insuranceCost, costOfCoverage,
                Currency.JPY, fullname, Country.JAPAN, typeOfInsurance, ContractStatus.UNPAID);

        archive.addContract(contract);
        return contract;
    }

    @Override
    public InsuranceContract payInsurance(String number) throws ContractNotFoundException {
        if (archive.getContracts().containsKey(number)) {
            InsuranceContract insuranceContract = archive.getContracts().get(number);
            insuranceContract.setContractStatus(ContractStatus.PAID);
            return insuranceContract;
        } else {
            throw new ContractNotFoundException("Данного договора нет в архиве!");
        }
    }



























}
