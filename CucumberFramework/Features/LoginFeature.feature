Feature: Login

@sanity
Scenario: successful login with valid credentials
  Given User Launch chrome browser                                      
  When User open URL "http://admin-demo.nopcommerce.com/login"          
  And User enter email as "admin@yourstore.com" and Password as "admin" 
  And Click on Login                                                      
  Then Page Title should be "Dashboard / nopCommerce administration"    
  When User click on Log out link
  #Then Page title should be "Your store. Login"
  And close browser
  
  
Scenario Outline: successful login with valid credentials DDT
  Given User Launch chrome browser                                      
  When User open URL "http://admin-demo.nopcommerce.com/login"          
  And User enter email as "<email>" and Password as "<password>" 
  And Click on Login                                                      
  Then Page Title should be "Dashboard / nopCommerce administration"    
  When User click on Log out link
  And close browser
  
Examples:
|email|password|
|admin@yourstore.com|admin|
|test@yourstore.com|test|