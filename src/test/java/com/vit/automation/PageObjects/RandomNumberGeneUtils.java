package com.vit.automation.PageObjects;

import java.util.Random;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.WebDriverWait;

import io.cucumber.java.Scenario;


public class RandomNumberGeneUtils {
	
	private static final Logger logger = LogManager.getLogger(RandomNumberGeneUtils.class);
	
	WebDriver driver;
	Scenario scn;
	WebDriverWait webDriverWait; 
	
//	constructor
	public RandomNumberGeneUtils(WebDriver driver, Scenario scn ) {
		this.driver = driver;
		this.scn = scn;
		this.webDriverWait = webDriverWait;
		
	}
	
	//for Scenario = 10 News Letter Subscription 
	
	public static String randomStringGenerator () {
		Random random = new Random();
		String randomName = "";
		
		for (int i=0; i<10; i++)
		{
			char characterRandom = (char)(random.nextInt(26)+97);
			if(random.nextBoolean())
			{
				characterRandom = Character.toUpperCase(characterRandom);
				randomName = randomName + characterRandom;
			}
		}
			
		randomName =randomName+"@gmail.com";
		
		return randomName;
	}

}
