package com.codedevunlocked.iocdemo;

public class BaseballCoach implements Coach {
	
	public String fortune;
	
	public BaseballCoach(FortuneService fs) {
		fortune = fs.getDailyFortune();
	}
	
	@Override
	public String getDailyWorkOut() {
		return "Run a round : " + fortune;
	}

}
