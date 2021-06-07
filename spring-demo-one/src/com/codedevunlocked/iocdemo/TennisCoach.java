package com.codedevunlocked.iocdemo;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class TennisCoach implements Coach {

	public FortuneService fortune;
	
	@Autowired
	public void setFortune(FortuneService fortune) {
		this.fortune = fortune;
	}

	@Override
	public String getDailyWorkOut() {
		return "Do some tennis practice : " + fortune.getDailyFortune();
	}

}
