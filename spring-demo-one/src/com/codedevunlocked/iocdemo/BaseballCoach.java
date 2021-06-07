package com.codedevunlocked.iocdemo;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class BaseballCoach implements Coach {

	public String fortune = "Test";

	@Autowired
	public BaseballCoach(FortuneService fs) {
		fortune = fs.getDailyFortune();
	}

	@Override
	public String getDailyWorkOut() {
		return "Run a round : " + fortune;
	}

}
