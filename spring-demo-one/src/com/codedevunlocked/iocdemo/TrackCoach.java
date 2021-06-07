package com.codedevunlocked.iocdemo;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class TrackCoach implements Coach {

	@Autowired
	public FortuneService fs;

	@Override
	public String getDailyWorkOut() {
		return "Run on the track well : " + fs.getDailyFortune();
	}

}
