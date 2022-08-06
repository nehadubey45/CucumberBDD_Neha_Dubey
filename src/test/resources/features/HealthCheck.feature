@ui @healthcheck
Feature: E-commerce Project web Site Health Check

 Background: Navigation to the URL
 	Given User is able to Open the browser and navigate to the home application URL
 	
@_1_RedirectionTest

Scenario: Landing page URL Redirection
#When open Landing page
Then it will redirected as "http://automationpractice.com/index.php"

@_2_LandingPageTitleTest

Scenario: Landing page title validation
When Landing page is Displayed
Then title should be "My Store"

@_3_ProductCategoryValidationTest

Scenario: Validation of Product Category
When  User check for product category
Then product_category should be displayed on Landing page

    |product_category|
    | WOMEN      |
    | DRESSES    |
    | T-SHIRTS   |
    
And size of product category is 3 
    
 @_4_LandingPageLogoDisplayTest
  
Scenario: Logo Display Test
When user is on the landing page
Then Logo on the landing Page is displayed

@_5_ValidateApplicationLogoHeight

Scenario: Validation of logo Height
When On landing page logo is displayed
Then the height of logo on landing page should be "99"

@_6_ValidateApplicationLogoWidth
  
Scenario: Validation of logo Width
When logo is displayed on landing page
Then the width of logo on landing page should be "350"
    
@_7_SignInpageTitleValidation

Scenario: Check the Title of Sign In Page
When User click on the SignIn button
Then the next page title should be as "Login - My Store"

@_8_productSearchBoxAndValidation

Scenario: check for search box and product list
When search box is displayed on the landing page
Then User search for the product "Dress" as an keyword in the search box should contain in the suggested list  
And count the number of product from sugested list which countain the keyword "Dress" in it.

@_9_ValidateTwitterSocialMediaHandle
Scenario: Twitter Account Validation
When User click on the Twitter link from bottom of the landing page
Then Twitter Account should be opened 
And Twitter Account name should be "Selenium Framework"

@_10_Newslettersubscription
Scenario: Newsletter Subscription Validation 
When User enters Email-ID in newsletter subscription text box 
And click on the proceed button
Then user get the message "Newsletter : You have successfully subscribed to this newsletter."

