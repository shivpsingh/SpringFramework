package com.codedevunlocked.iocdemo;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.PropertySource;
//import org.springframework.context.annotation.ComponentScan;
import org.springframework.stereotype.Component;

@Component
//@ComponentScan("com.codedevunlocked.iocdemo")
@PropertySource("classpath:coach.properties")
public class CoachConfig {

	@Bean
	public FortuneService sadFortuneService() {
		return new HappyFortuneService();
	}
	
	@Bean
	public Coach swimCoach() {
		return new SwimCoach(sadFortuneService());
//		return new SwimCoach();
	}
	
}
