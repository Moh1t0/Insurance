package com.javacademy.insurance.service;

import lombok.Getter;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;
import java.util.HashMap;
import java.util.Map;

@Slf4j
@Component
@Getter
public class Archive {
    private Map<String, InsuranceContract> contracts = new HashMap<>();

    public void addContract(InsuranceContract contract) {
        contracts.put(contract.getNumber(), contract);
    }

    public InsuranceContract getContract(String number) {
        InsuranceContract contract = contracts.get(number);
        if (contract != null) {
            log.info("ФИО: {}", contract.getFullName());
            log.info("Номер страховки: {}", contract.getNumber());
            log.info("Статус страховки: {}", contract.getContractStatus());
            log.info("Сумма покрытия: {}", contract.getCostOfCoverage());
            log.info("Стоимость страховки: {}", contract.getPrice());
            log.info("Тип страховки: {}", contract.getTypeOfInsurance());
            log.info("Страна: {}", contract.getCountry());
            log.info("Валюта: {}", contract.getCurrency());
        } else {
            log.info("Страховки с номером: {} , нет в архиве", contract.getNumber());
        }
        return contract;
    }
}
