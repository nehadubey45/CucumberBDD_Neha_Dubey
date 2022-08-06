package com.vit.automation.PageObjects;


import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import io.cucumber.java.Scenario;

public class SignInPageObject {

	private final static Logger logger = LogManager.getLogger(SignInPageObject.class);
	
	WebDriver driver;
	Scenario scn;
	WebDriverWait webDriverWait;
	
	//Locator
	
	private By SignIn = By.xpath("//div/a[contains(text(),'Sign in')]");
	//"//div/a[contains(text(),'Sign in')]"
	
	
//	Constructor
	
	public SignInPageObject(WebDriver driver, Scenario scn ) {
		this.driver = driver;
		this.scn = scn;
		this.webDriverWait = webDriverWait;

	}
	
	//####################### Scenario-7 ######################################
	
	public void clickOnSignInBtn()
	{
		WebElement SignInBtn = driver.findElement(SignIn);
		
		webDriverWait = new WebDriverWait(driver, 20);
		
		scn.log("sign in button found");
		logger.info("sign in button found");
		
		webDriverWait.until(ExpectedConditions.elementToBeClickable(SignIn));
		
		SignInBtn.click();
		
		scn.log("User click on sign in button successfully");
		logger.info("User click on sign in button successfully");
		
//		Actions actions = new Actions(driver);
//		actions.click(SignInBtn);
		
		
	
//			JavascriptExecutor js = ((JavascriptExecutor) driver);
//			js.executeScript("arguments[0].click();",SignInBtn);
		
	}
	
	
	public void SignInPageTitleValidation(String string)
	{
		webDriverWait.until(ExpectedConditions.titleContains(string));
		
		String actTitle = driver.getTitle();
		 Assert.assertEquals(true, actTitle.contains(string));
		 
		  scn.log("SignIn page Title validation is successful");
		  logger.info("SignIn page Title validation is successful");
	}
	
	
	
	
	
	
	
	
	
}
