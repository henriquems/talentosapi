package com.example.talentosapi;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.context.properties.EnableConfigurationProperties;

import com.example.talentosapi.config.property.TalentosApiProperty;

@SpringBootApplication
@EnableConfigurationProperties(TalentosApiProperty.class)
public class TalentosApiApplication {

	public static void main(String[] args) {
		SpringApplication.run(TalentosApiApplication.class, args);
	}
	
}
