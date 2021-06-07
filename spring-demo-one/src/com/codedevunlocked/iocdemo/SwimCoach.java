package com.codedevunlocked.iocdemo;

//import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
//import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class SwimCoach implements Coach {
	
	@Value("${coach.coachname}")
	private String coachName;

//	@Autowired
	private FortuneService fs;

	public SwimCoach(FortuneService fs) {
		this.fs = fs;
	}
	
//	public SwimCoach() {}
	
	@Override
	public String getDailyWorkOut() {
		// TODO Auto-generated method stub
		return "I want you to swim : " + fs.getDailyFortune() + " : " + coachName;
	}

}
