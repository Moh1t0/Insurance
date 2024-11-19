package com.javacademy.insurance.service.brazil;

import lombok.Data;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Profile;
import java.math.BigDecimal;


@Data
@ConfigurationProperties(prefix = "insurance")
@Profile("brazil")
public class BrazilInsuranceProperty {

    private BigDecimal robberyCoefficient;
    private BigDecimal medicalCoefficient;
    private BigDecimal robberyBase;
    private BigDecimal medicalBase;
    private String currency;
}
