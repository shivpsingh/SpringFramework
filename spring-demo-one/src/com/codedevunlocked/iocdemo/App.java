package com.codedevunlocked.iocdemo;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;
//import org.springframework.context.support.ClassPathXmlApplicationContext;

public class App {

	public static void main(String[] args) {

		// create the object
		
		// Coach theCoach = new BaseballCoach();
		// Coach theCoach = new TrackCoach();
		
		// load the configuration file
//		ClassPathXmlApplicationContext context = new ClassPathXmlApplicationContext("applicationContext.xml");
		
		AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext(CoachConfig.class);
		
		// retrieve bean from spring container
		Coach theCoach = context.getBean("swimCoach", Coach.class);
		
		// Use the object
		System.out.println(theCoach.getDailyWorkOut());
		
		// close the context
		context.close();

	}

}
