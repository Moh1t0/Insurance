package com.javacademy.insurance.service;


import com.javacademy.insurance.enums.ContractStatus;
import com.javacademy.insurance.enums.Country;
import com.javacademy.insurance.enums.Currency;
import com.javacademy.insurance.enums.TypeOfInsurance;
import com.javacademy.insurance.exceptions.ContractNotFoundException;
import lombok.RequiredArgsConstructor;
import java.math.BigDecimal;

@RequiredArgsConstructor
public abstract class AbstractInsuranceService implements InsuranceService {
    protected final Archive archive;
    protected final ContractNumberGenerator contractNumberGenerator;

    protected abstract BigDecimal calculateInsuranceCost(BigDecimal costOfCoverage, TypeOfInsurance typeOfInsurance);

    protected abstract Currency getCurrency();

    protected abstract Country getCountry();


    @Override
    public InsuranceContract offerInsurance(BigDecimal costOfCoverage, String fullname,
                                            TypeOfInsurance typeOfInsurance) {
        String number = contractNumberGenerator.generateContractNumber();
        BigDecimal insuranceCost = calculateInsuranceCost(costOfCoverage, typeOfInsurance);

        InsuranceContract contract = new InsuranceContract(number, insuranceCost, costOfCoverage,
                getCurrency(), fullname, getCountry(), typeOfInsurance);

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
