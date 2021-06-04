package com.codedevunlocked.iocdemo;

public class TennisCoach implements Coach {

	public String fortune;
	
	public TennisCoach(FortuneService fs) {
		fortune = fs.getDailyFortune();
	}
	
	@Override
	public String getDailyWorkOut() {
		return "Do some tennis practice : " + fortune;
	}

}
