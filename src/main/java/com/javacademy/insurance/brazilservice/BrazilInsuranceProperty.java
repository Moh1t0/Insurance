package com.javacademy.insurance.brazilservice;

import lombok.Data;
import org.springframework.boot.context.properties.ConfigurationProperties;

import java.math.BigDecimal;
@Data
@ConfigurationProperties(prefix = "insurance.brazil")
public class BrazilInsuranceProperty {

    private BigDecimal robberyCoefficient;
    private BigDecimal medicalCoefficient;
    private BigDecimal robberyBase;
    private BigDecimal medicalBase;
    private String currency;
}
