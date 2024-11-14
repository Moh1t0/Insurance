package com.javacademy.insurance.config;

import com.javacademy.insurance.service.Archive;
import com.javacademy.insurance.japanservice.InsuranceCalcJapanService;
import com.javacademy.insurance.japanservice.InsuranceServiceJapan;
import com.javacademy.insurance.japanservice.JapanInsuranceProperty;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Profile;

@Configuration
@Profile("japan")
public class JapanConfig {

    @Bean
    public JapanInsuranceProperty japanInsuranceProperty() {
        return new JapanInsuranceProperty();
    }

    @Bean
    public InsuranceCalcJapanService insuranceCalcJapanService(JapanInsuranceProperty japanInsuranceProperty) {
        return new InsuranceCalcJapanService(japanInsuranceProperty);
    }

    @Bean
    public Archive archive() {
        return new Archive();
    }

    @Bean
    public InsuranceServiceJapan insuranceServiceJapan(InsuranceCalcJapanService insuranceCalcJapanService,
                                                       Archive archive) {
        return new InsuranceServiceJapan(insuranceCalcJapanService, archive);
    }

}
