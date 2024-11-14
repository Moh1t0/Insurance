package com.javacademy.insurance.config;

import com.javacademy.insurance.service.Archive;
import com.javacademy.insurance.brazilservice.BrazilInsuranceProperty;
import com.javacademy.insurance.brazilservice.InsuranceCalcBrazilService;
import com.javacademy.insurance.brazilservice.InsuranceServiceBrazil;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Profile;

@Configuration
@Profile("brazil")
public class BrazilConfig {

    @Bean
    public BrazilInsuranceProperty brazilInsuranceProperty() {
        return new BrazilInsuranceProperty();
    }

    @Bean
    public InsuranceCalcBrazilService insuranceCalcBrazilService(BrazilInsuranceProperty brazilInsuranceProperty) {
        return new InsuranceCalcBrazilService(brazilInsuranceProperty());
    }

    @Bean
    public Archive archive() {
        return new Archive();
    }

    @Bean
    public InsuranceServiceBrazil insuranceServiceJapan(InsuranceCalcBrazilService insuranceCalcBrazilService,
                                                        Archive archive) {
        return new InsuranceServiceBrazil(insuranceCalcBrazilService, archive);
    }


}
