package com.javacademy.insurance.japanservice;

import lombok.Data;
import org.springframework.boot.context.properties.ConfigurationProperties;
import java.math.BigDecimal;

@Data
@ConfigurationProperties(prefix = "insurance.japan")
public class JapanInsuranceProperty {

    private BigDecimal robberyCoefficient;
    private BigDecimal medicalCoefficient;
    private BigDecimal robberyBase;
    private BigDecimal medicalBase;
    private String currency;
}
