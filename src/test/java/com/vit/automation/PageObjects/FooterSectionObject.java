package com.vit.automation.PageObjects;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import io.cucumber.java.Scenario;

public class FooterSectionObject {
	
	private static final Logger logger = LogManager.getLogger(FooterSectionObject.class);


	WebDriver driver;
	Scenario scn;
	WebDriverWait webDriverWait;
	
	
	
//	Locator
	private By twitterLinkele = By.xpath("//li[@class='twitter']");
	private By tweetName = By.xpath("//div[@class='css-1dbjc4n r-1awozwy r-18u37iz r-1wbh5a2']//preceding-sibling::div[1]/child::div[1]/child::div[1]/span/span");
	private By newsletter = By.xpath("//input[@id='newsletter-input']");
	private By newsLtrProceedBtn = By.xpath("//button[@name='submitNewsletter']");
	private By succefulSubscriptionEle = By.xpath("//p[@class='alert alert-success']");
	
	//Constructor
	
	public FooterSectionObject(WebDriver driver, Scenario scn)
	{
		this.driver = driver;
		this.scn = scn;
		this.webDriverWait = webDriverWait;
	}

//	###################Scenario = 9 Twitter link###########################################
	
	
	public void userClickOnTwitterBtn() 
	{
		
	WebElement TwitLink = driver.findElement(twitterLinkele);
	JavascriptExecutor js = (JavascriptExecutor )driver;
	js.executeScript("arguments[0].scrollIntoView(true);",TwitLink);
	Assert.assertEquals(true, TwitLink.isDisplayed());
	scn.log("Twitter link is displayed");
	logger.info("Twitter link is displayed");
	TwitLink.click();
	
	}

	public void validateTwitterAccount (String string)
	{
		
	WebElement TweetAcName = driver.findElement(tweetName);
	
	Assert.assertEquals(true, TweetAcName.getText().contains(string));
	
    scn.log("Tweeter Account name is matched and displayed as: " + TweetAcName);
    logger.info("Tweeter Account name is matched and displayed as: " + TweetAcName);

	}	
	
	
//	##########################Scenario = 10 News letter Subscription##############################
	
	public void NewsBox() {
		
		WebElement SubcTxtBox = driver.findElement(newsletter);
		
	//	Assert.assertEquals("News letter not available",true,SubcTxtBox);
		
		String randomStringGenerator = RandomNumberGeneUtils.randomStringGenerator();
		
		SubcTxtBox.sendKeys(randomStringGenerator);
}
	
	
	
	public void proceedBtn() {
		
		WebElement GoBtn = driver.findElement(newsLtrProceedBtn);
		
		webDriverWait = new WebDriverWait(driver,20);

		webDriverWait.until(ExpectedConditions.elementToBeClickable(newsLtrProceedBtn));

		
		GoBtn.click();
		
		scn.log("Subscription message is displayed");
		logger.info("Subscription message is displayed");
		
	}

	public void SuccessMsg(String string) {
		WebElement Message = driver.findElement(succefulSubscriptionEle);
		Assert.assertEquals("Subscription alert message not displayed",true, Message.getText().contains(string));
		scn.log("Subscription alert message  displayed");
	}
		

		
}
	