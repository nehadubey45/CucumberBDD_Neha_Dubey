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

import io.cucumber.java.Scenario;

public class SearchProductObject {

private static final Logger logger = LogManager.getLogger(SearchProductObject.class);
	
	WebDriver driver;
	Scenario scn;
	WebDriverWait webDriverWait;
	
	
//************************************************************************************************	
	//	Locators
	
		private By sBox  = By.xpath("//input[@id='search_query_top']");
		private By GoBtn = By.xpath("//button[@class='btn btn-default button-search']");
		private By DressList = By.xpath("//div[@class='ac_results']/ul/li");
	
	//************************************************************************************************	
	
	//Constructor
	public SearchProductObject(WebDriver driver,Scenario scn) {
		this.driver = driver;
		this.scn = scn;
		this.webDriverWait = webDriverWait;
		
	}
	
	//####################### Scenario-8 ######################################
	
		public void SearchBoxDisplay()
		{
			
			WebElement searchBox = driver.findElement(sBox);
			Assert.assertEquals(true, searchBox.isDisplayed());
	
			scn.log("Search Box is Displayed on landing page");
			logger.info("Search Box is Displayed on landing page");
			
//			scn.log("product name send for search box is = " + string);
//			logger.info("product name send for search box is = " +string);
			
	}
		public void searchProduct(String string)
		{
			
			WebElement searchBox = driver.findElement(sBox);
			searchBox.sendKeys(string);
			
			List<WebElement> suggestedList = driver.findElements(DressList); 
			
			webDriverWait = new WebDriverWait(driver, 60);
	//		webDriverWait.until(ExpectedConditions.visibilityOfAllElements(suggestedList));
			
			
		}
		
		public void productCount(String string)
		{
			List<WebElement> suggestedList = driver.findElements(DressList); 
			webDriverWait.until(ExpectedConditions.visibilityOfAllElements(suggestedList));
			int count=0;
			
			for (int i=0; i<suggestedList.size();i++)
			{
				
				if(suggestedList.get(i).getText().contains(string))
				{
					Assert.assertEquals("Product not match",true , suggestedList.get(i).getText().contains(string));
					
					
					System.out.println((i+1)+"."+suggestedList.get(i).getText());
					logger.info((i+1)+"."+suggestedList.get(i).getText());
					scn.log((i+1)+"."+suggestedList.get(i).getText());
					count++;
			
				}
				
			}
			scn.log("Suggested list count is = " + count);
			logger.info("Suggested list count is = " + count);
			System.out.println("product list is" +suggestedList.size());
		}
	
	
}
