package com.javacademy.insurance.service;

import org.springframework.stereotype.Component;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.concurrent.atomic.AtomicInteger;

@Component
public class ContractNumberGenerator {

    private static final SimpleDateFormat DATE_FORMAT = new SimpleDateFormat("yyyyMMdd");
    private static final AtomicInteger COUNTER = new AtomicInteger(0);

    public String generateContractNumber() {
        String date = DATE_FORMAT.format(new Date());
        int id = COUNTER.getAndIncrement();
        return String.format("%s-%s", date, id);
    }

}
