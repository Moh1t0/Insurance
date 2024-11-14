package com.javacademy.insurance;

import com.javacademy.insurance.enums.TypeOfInsurance;
import com.javacademy.insurance.japanservice.InsuranceServiceJapan;
import com.javacademy.insurance.service.Archive;
import com.javacademy.insurance.service.InsuranceContract;
import lombok.extern.slf4j.Slf4j;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ConfigurableApplicationContext;
import java.math.BigDecimal;

@Slf4j
@SpringBootApplication
public class InsuranceApplication {

	public static void main(String[] args) {
		ConfigurableApplicationContext context = SpringApplication.run(InsuranceApplication.class, args);
		InsuranceServiceJapan serviceJapan = context.getBean(InsuranceServiceJapan.class);
		InsuranceContract insurance = serviceJapan.offerInsurance
				(new BigDecimal("11200"), "Костенко Иван Сергеевич", TypeOfInsurance.MEDICAL_INSURANCE);
		Archive archive = context.getBean(Archive.class);
		archive.getContract(insurance.getNumber());
	}
}
