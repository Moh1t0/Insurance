package com.javacademy.insurance.japanservice;

import lombok.Data;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Profile;
import org.springframework.stereotype.Component;

import java.math.BigDecimal;

@Data
@ConfigurationProperties(prefix = "insurance")
@Profile("japan")
public class JapanInsuranceProperty {

    private BigDecimal robberyCoefficient;
    private BigDecimal medicalCoefficient;
    private BigDecimal robberyBase;
    private BigDecimal medicalBase;
    private String currency;
}
