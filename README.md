# AxelerantAssignment

# Components of Framework
    1.  Selenium      - API to perform interactions with Web Application
    2.  Gradle        - Build Automation Tool
    3.  TestNG        - Testing Framework
    4.  Java          - Programming Language
    5.  ExtentReports - Reporting API to help with html reports
 
# Framework Structure
  Framework is configured using the Page Object Model Design framework, with few modifications.
  # Pages
  Each Page of the application has a corresponding java class (Eg.Womens Page has womenspage.java) where all the webelements associated with that page is initialized & grouped
  This Page class also has separate methods for all actions that are performed in that specific page (eg. AuthenticationPage.java has a method to perform sign-in action using     valid credentials & perform submit)
  All the page classes are grouped under a "Pages" package under the source sets(src/main)
  
  # Utils
  All the util classes which are common to the framework are grouped under the Utils package
  These util classes perform actions such as reading the config.properties file, configure the extent reports in a presentable format

  # Tests
  The tests are configured and grouped under the axeleranttests package under source sets(src/test)
     1.BaseTest.java - Class which is being extended by other test classes. BaseTest.java is where the driver instantiation , thread configuration for parallel                                          execution , teardown after execution happens.
     2.AssignmentTests.java is the class where all the tests corresponding to this assignment are configured. There are 5 tests configured in this class which are explained             below
  
    a. HeaderFooterContentTest - Navigate to different pages of the application and verify if header & footer content are correct
    b. NewsLetterSubscriptionTest - Subscribe to the newsletter by entering a valid email address & validating the message shown is correct
    c. NewsLetterSubscriptionNegativeTest - Subscribe to the NewsLetter by entering a invalid email ID & click submit button. Validating if the display error message is correct
    d. WomensPageAutomationTest - Navigate to Women's Page from Landing Page & click on different tabs.Validating if the number of items displayed are correct in each of the tab
    e. FullCheckOutTest - Navigate to TShirt Page from Landing Page & add an item to the cart.Validating if the checkout process is complete without any issues
    
   The test mentioned in 3.a in the assignment was not attempted as enabling the Filter in WomensPage left the application hanging for a long time. So its not a valid scenario     for test automation. Instead test 'd' above has been used.
   
  # TestReport
  Once the tests are executed, the html test results will be present in this folder 
  
  # testng.xml
  Grouping of all tests to be executed as part of the test.
  
  # Config.properties:
  Good practice to keep all the dynamic part of the framework (like application URL, driverpath etc..) in a properties file so it can be changed as and when needed

# Pre-Requisites for this Framework
    1.  Gradle - Download the latest gradle version, update the homepath in system variables. Ensure command "gradle -v" gives the installed gradle version in command prompt
    2.  Browser Drivers - Download the necessary drivers(chromedriver, firefoxdriver etc..) needed for execution and update the path in config.properties file
    3.  Dependent JAR files - No need to download the dependent JAR files(Selenium,ExtentReports, TestNG) etc, as they would be downloaded automatically as they are configured                                   in build.gradle file
  
  # Execute the Tests - Follow the below steps to execute the tests:
    1. Ensure all the above pre-requisites are met.
    2. If the browser needs to be changed, it can be updated in the testng.xml file
    3. Currently the configuration is set for parallel execution, but if this needs to be changed, it can be done by updating testng.xml file
    4. Execute the testng.xml file by using Run or Debug command & the tests will be executed
    5. Once the tests are executed, the html results will be available in the TestReport folder
    
  # Advantages of Framework:
    1. Page Object Model is one of the best practices for test automation framework. If there are any changes to the webelement locators, it will be easy to identify & update them at one place rather than multiple places
    2. Usage of gradle enables to perform build automation & helps integration with CI/CD pipelines easy. If needed, we can create a task for tests in build.gradle file which can be invoked by a CI/CD tool (eg. Jenkins, GitlabCI etc..)
    3. In future, if there is a need to pass the test data from an external source (like excel, json, xml) then the framework can easily be scaled up by creating a new util class & read the external source
    4. Extent reports provides extensive information about the test runs in a very presentable html format which can be published across team members
