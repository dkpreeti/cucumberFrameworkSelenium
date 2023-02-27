Feature: Customer
Background: Steps common for all scenarios
   Given User Launch chrome browser                                      
   When User open URL "http://admin-demo.nopcommerce.com/login"          
   And User enter email as "admin@yourstore.com" and Password as "admin" 
   And Click on Login
   Then User can view Dashboard

@sanity
Scenario: Add New Customer
   When User click on customers menu
   And click on customer menu item
   And click on Add new button
   Then User can view Add new customer page
   When User enter customer info 
   And click on save button
   Then User can view confirmation message "The new customer has been added successfully."
   And close browser
   
@regression   
Scenario: Search Customer by Email
   When User click on customers menu
   And click on customer menu item   
   And enter customer Email
   When click on search button
   Then User should found Email in search table
   And close browser   
   
@regression   
Scenario: Search Customer by Name
   When User click on customers menu
   And click on customer menu item   
   And enter customer FirstName
   And enter customer LastName
   When click on search button
   Then User should found Name in search table
   And close browser