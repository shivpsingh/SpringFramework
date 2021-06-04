package com.codedevunlocked.iocdemo;

public class TrackCoach implements Coach {

	public FortuneService fs;
	public String coachName;
	
	public void setFs(FortuneService fs) {
		this.fs = fs;
	}
	
	public void setCoachName(String coachName) {
		this.coachName = coachName;
	}

	@Override
	public String getDailyWorkOut() {
		return "Run on the track well : " + fs.getDailyFortune() + " : " + coachName;
	}

}
