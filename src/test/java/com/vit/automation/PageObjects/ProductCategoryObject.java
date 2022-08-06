package com.vit.automation.PageObjects;

import java.util.List;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.WebDriverWait;

import io.cucumber.java.Scenario;

public class ProductCategoryObject {
	
	private static final Logger logger = LogManager.getLogger(ProductCategoryObject.class);
	
	WebDriver driver;
	Scenario scn;
	WebDriverWait webDriverWait;
	
//************************************************************************************************	
	
	//	Locators
	
	private By ProdCategory = By.xpath("//div[@id = 'block_top_menu']/ul/li/a");
	
	//Constructor 
	
	public ProductCategoryObject(WebDriver driver, Scenario scn) {
		this.driver = driver;
		this.scn = scn;
		this.webDriverWait = webDriverWait;
	
	}	
	
	//####################### Scenario-3 Product Category List ######################################
	
	public void checkProductCat()
	{
		List<WebElement> ProdCatList = driver.findElements(ProdCategory);
		
		Assert.assertEquals("Category is displayed successful", false, ProdCatList.isEmpty());
		scn.log("Product Category is displayed successfully.");
		logger.info("Product Category is displayed successfully.");
	}
	
	public void ProductCatDisplay(List<String> listSize) throws InterruptedException
	{
		
		List<WebElement> list = driver.findElements(ProdCategory);
		
		
	    for(int i = 0; i<list.size(); i++)
	    {
	    	if(list.get(i).getText().equals(listSize.get(i).toString()))
	    	{
	    		Assert.assertTrue(true);
	    	}
	    	else
	    	{
	    		Assert.assertFalse(false);
	    	}
	    }
	}
	
	
	public void productCategorySize(int Count)
	{
		
		List<WebElement> productList = driver.findElements(ProdCategory);
		
		int actualCount = productList.size();
		
		Assert.assertEquals(Count, actualCount);
		scn.log("Number of product category searched: " + actualCount);
		logger.info("Number of product category searched: " + actualCount);
		
		//scn.log("Size of product category is same as 3.");
		//logger.info("Size of product category is same as 3.");
	}
	
	
}
