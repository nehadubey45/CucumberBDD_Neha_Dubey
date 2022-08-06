package com.vit.automation.PageObjects;

import java.util.List;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.vit.automation.core.WebDriverFactory;

import io.cucumber.java.Scenario;

public class CommonPageObject {

	private static final Logger logger = LogManager.getLogger(CommonPageObject.class);
	
	WebDriver driver;
	Scenario scn;
	WebDriverWait webDriverWait;
	
	
//************************************************************************************************	
	//	Locators
	
	private By logoDisplay = By.xpath("//div[@id ='header_logo']/a/img");
	
	
	//************************************************************************************************	
	
	//Constructor
	public CommonPageObject(WebDriver driver,Scenario scn) {
		this.driver = driver;
		this.scn = scn;
		
	}
	
	//Page Methods
	
	//####################### Scenario-1 Landing page URL Redirection ######################################
	
	public void UserNavigateURL(String base_url)
	{
		WebDriverFactory.navigateToTheURL(base_url);
	}
	
	
	
	public void URLRedirection(String string) {
		
		String ActualUrl = driver.getCurrentUrl();
		Assert.assertEquals(true, ActualUrl.contentEquals(string));
	
		scn.log("Redirected Website Link" + driver.getCurrentUrl());
	    logger.info("Redirected Website Link" + driver.getCurrentUrl());
	}
	
	//####################### Scenario-2 Landing page Title ######################################
	
	public void titleDisplayAndValidation(String string)
	{
		driver.getTitle();
		String ActualTitle = driver.getTitle();
		Assert.assertEquals(true,ActualTitle.equals(string));
		
	}

	//####################### Scenario-4 ######################################
	
	public void logoDisplay()
	{
		WebElement logo = driver.findElement(logoDisplay);
		Assert.assertEquals("Logo is Displayed" , true, logo.isDisplayed());
		scn.log("Logo is displayed on Landing Page.");
    	logger.info("Logo is displayed on Landing Page.");
		
	}
	
	//####################### Scenario-5 ######################################
	
	public void logoHeight(String string) 
	{
		WebElement logo_1 = driver.findElement(logoDisplay);
		String logoHeight = logo_1.getAttribute("height");
		Assert.assertEquals("validation of Height of logo is successful",true,logoHeight.equals(string));
		
		scn.log("Logo height validation is sucessfull. Logo width = "+logoHeight);
		logger.info("Logo height validation is sucessfull. Logo width = "+logoHeight);
	}
	
	//####################### Scenario-6 ######################################
	
	public void logoWidth(String string)
	{
		WebElement logo_2 = driver.findElement(logoDisplay);
		String logoWidth = logo_2.getAttribute("width");
		Assert.assertEquals("validation of Width of logo is successful", true, logoWidth.equals(string));
		
		scn.log("Logo Width validation is sucessfull. Logo width = "+logoWidth);
		logger.info("Logo Width validation is sucessfull. Logo width = "+logoWidth);
		
	}
	

	

	
	
	
	
	
	
	
	
	
	
	
	
	
	
}

	
	
