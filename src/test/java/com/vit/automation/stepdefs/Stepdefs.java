package com.vit.automation.stepdefs;

import java.util.Iterator;
import java.util.List;
import java.util.Set;
import java.util.concurrent.TimeUnit;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.vit.automation.PageObjects.CommonPageObject;
import com.vit.automation.PageObjects.FooterSectionObject;
import com.vit.automation.PageObjects.ProductCategoryObject;
import com.vit.automation.PageObjects.RandomNumberGeneUtils;
import com.vit.automation.PageObjects.SearchProductObject;
import com.vit.automation.PageObjects.SignInPageObject;
import com.vit.automation.core.WebDriverFactory;

import io.cucumber.java.After;
import io.cucumber.java.Before;
import io.cucumber.java.Scenario;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class Stepdefs {
	
	private static final Logger logger = LogManager.getLogger(Stepdefs.class);

    WebDriver driver;
    String base_url = "http://automationpractice.com/";
    int implicit_wait_timeout_in_sec = 20;
    Scenario scn;
    WebDriverWait webDriverWait;
    
    CommonPageObject commonPageObject;
    SignInPageObject signInPageObject;
    ProductCategoryObject productCategoryObject;
    FooterSectionObject footerSectionObject;
    SearchProductObject searchProductObject;
    RandomNumberGeneUtils randomNumberGeneUtils;
    
    
//	***************************************************************************************************
    
    @Before
    public void setUp(Scenario scn) throws Exception{
        this.scn = scn;
        
//        driver = new ChromeDriver();
//        driver.manage().window().maximize();
//        driver.manage().timeouts().implicitlyWait(implicit_wait_timeout_in_sec, TimeUnit.SECONDS);
        
        String browserName =com.vit.automation.core.WebDriverFactory.setBrowser();
        driver=com.vit.automation.core.WebDriverFactory.webDriverforBrowser(browserName);
        scn.log("Browser invoked");
        logger.info("Browser invoked");
        
        
   //**************************************************************************************     
        footerSectionObject = new FooterSectionObject(driver,scn);
        commonPageObject = new CommonPageObject(driver,scn);
        signInPageObject = new SignInPageObject(driver,scn);
        productCategoryObject = new ProductCategoryObject(driver,scn);
        searchProductObject = new SearchProductObject(driver,scn);
        randomNumberGeneUtils = new RandomNumberGeneUtils(driver,scn);
        
    }

  //****************************************Screenshot*****************************************************
    
  @After(order=1)
    public void cleanUp(){
	  
	  com.vit.automation.core.WebDriverFactory.quitDriver();
	  
        scn.log("Browser Closed");
        logger.info("Browser Closed");
    }
  
	@After(order=2)
	public void takeScreenShot(Scenario s) {
		if (s.isFailed()) {
			TakesScreenshot scrnShot = (TakesScreenshot)driver;
			byte[] data = scrnShot.getScreenshotAs(OutputType.BYTES);
			scn.attach(data, "image/png","Failed Step Name: " + s.getName());
		}
		
		else{
			
			scn.log("Test case is passed, no screen shot captured");
		}
	}
	
	
	//******************************************************************************************************
  //Background
	
	@Given("User is able to Open the browser and navigate to the home application URL")
	public void User_is_able_to_Open_the_browser_and_navigate_to_the_home_application_url() {
	  
		WebDriverFactory.navigateToTheURL(base_url);
		
	}

	//Scenario-1 URL Redirection Test
		
	@When("open Landing page")
	public void open_landing_page() {
	    
	commonPageObject.UserNavigateURL(base_url);
		
		scn.log("Browser is navigated to the URL: ");
        logger.info("Browser is navigated to the URL: ");
        
	}

	@Then("it will redirected as {string}")
	public void it_will_redirected_as(String string) {
	   commonPageObject.URLRedirection(string); 
	}
	

   //Case-2 Landing page Title

	@When("Landing page is Displayed")
	public void landing_page_is_displayed() {
	  
	//	driver.get(base_url);
		
	}

	@Then("title should be {string}")
	public void title_should_be(String string) {
	 
	commonPageObject.titleDisplayAndValidation(string);
	
	scn.log("Landing page title is" + driver.getTitle());
	logger.info("Landing page title is" + driver.getTitle());
		
	}

	//Scenario-3 Product Category
	
	@When("User check for product category")
	public void user_check_for_product_category() {
	    
		productCategoryObject.checkProductCat();
			
			
		}
	
	@Then("product_category should be displayed on Landing page")
	public void category_is_displayed_on_landing_page_list_is(List<String> listSize) throws InterruptedException {
	    
		productCategoryObject.ProductCatDisplay(listSize);
	}
		

	@Then("size of product category is {int}")
	public void size_of_product_category_is(int Count) {
	
			productCategoryObject.productCategorySize(Count);
		}
		
	

	//Scenario-4 Landing page Logo Display
	
	
	@When("user is on the landing page")
	public void user_is_on_the_landing_page() {
	    
		//driver.get(base_url);
		
	}


	@Then("Logo on the landing Page is displayed")
	public void logo_on_the_landing_page_is_displayed() {
	    
		commonPageObject.logoDisplay();
		scn.log("Logo is displayed successfully");
	}

	

	//Scenario-5 Logo Height
		
	@When("On landing page logo is displayed")
	public void on_landing_page_logo_is_displayed() {
		
		scn.log("Logo is available on the landing page");
	}


	@Then("the height of logo on landing page should be {string}")
	public void the_height_of_logo_on_landing_page_should_be(String string) {

		commonPageObject.logoHeight(string);
		scn.log("Logo height is " + string);
		logger.info("Logo height is " + string);
	}

	
	
	//Scenario-6 Logo Width
	
	@When("logo is displayed on landing page")
	public void logo_is_displayed_on_landing_page() {
		
		scn.log("Logo is available on the landing page"); 
	}


	@Then("the width of logo on landing page should be {string}")
	public void the_width_of_logo_on_landing_page_should_be(String string) {
	 commonPageObject.logoWidth(string);
	 scn.log("Logo Width is " + string);
	 logger.info("Logo widht is " + string);
	 
	}

	
	
	
	//Scenario-7 SignIn Page title Validation
	
	@When("User click on the SignIn button")
	public void user_click_on_the_sign_in_button() {
	    
	 signInPageObject.clickOnSignInBtn();
		
	}

	@Then("the next page title should be as {string}")
		public void the_next_page_title_should_be_as_(String string) {
		
		signInPageObject.SignInPageTitleValidation(string);
	 
		
	}

	//Scenario-8 product Search Box And Validation
	
	
	@When("search box is displayed on the landing page")
	public void search_box_is_displayed_on_the_landing_page() {
	    
		searchProductObject.SearchBoxDisplay();
	}

	@Then("User search for the product {string} as an keyword in the search box should contain in the suggested list")
	public void user_search_for_the_product_as_an_keyword_in_the_search_box_should_contain_in_the_suggested_list(String string) {
		
	    searchProductObject.searchProduct(string);
	}
	
	
	@Then("count the number of product from sugested list which countain the keyword {string} in it.")
	public void count_the_number_of_product_from_sugested_list_which_countain_the_keyword_in_it(String string) {
	 
		searchProductObject.productCount(string);
		
	}



	   
	

	//Scenario = 9 Twitter Social media Handle

	
	@When("User click on the Twitter link from bottom of the landing page")
	public void user_click_on_the_twitter_link_from_bottom_of_the_landing_page() {
		
	    footerSectionObject.userClickOnTwitterBtn();
	}


	@Then("Twitter Account should be opened")
	public void twitter_account_should_be_opened() {
	   
		WebDriverFactory.SwitchtoTab();
		
		
		
	}
	@Then("Twitter Account name should be {string}")
	public void twitter_account_name_should_be(String string) {
	    
		footerSectionObject.validateTwitterAccount(string);
	
		scn.log("Twitter Account name is matched and displayed as: " + string);
		
	}
	
   //Scenario = 10 News letter Subscription
	
	@When("User enters Email-ID in newsletter subscription text box")
	public void user_enters_email_id_in_newsletter_subscription_text_box() {
	    
		footerSectionObject.NewsBox();
		
	}

	@When("click on the proceed button")
	public void click_on_the_proceed_button() {
	 
		footerSectionObject.proceedBtn();
		
	}
	
	@Then("user get the message {string}")
	public void user_get_the_message(String string) {
	    footerSectionObject.SuccessMsg(string);
	}



	
}
