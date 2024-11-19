package com.javacademy.insurance.service.japan;

import lombok.Data;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Profile;
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
