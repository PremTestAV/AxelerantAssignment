# AxelerantAssignment

# Components of Framework
  Selenium      - API to perform interactions with Web Application
  Gradle        - Build Automation Tool
  TestNG        - Testing Framework
  Java          - Programming Language
  ExtentReports - Reporting API to help with html reports
 
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
  There is a BaseTest.java class which is being extended by other test classes. BaseTest.java is where the driver instantiation , thread configuration for parallel                 execution , teardown after execution happens.
  AssignmentTests.java is the class where all the tests corresponding to this assignment are configured. There are 5 tests configured in this class which are explained below
  
    1. HeaderFooterContentTest - Navigate to different pages of the application and verify if header & footer content are correct
    2. NewsLetterSubscriptionTest - Subscribe to the newsletter by entering a valid email address & validating the message shown is correct
    3. NewsLetterSubscriptionNegativeTest - Subscribe to the NewsLetter by entering a invalid email ID & click submit button. Validating if the display error message is correct
    4. WomensPageAutomationTest - Navigate to Women's Page from Landing Page & click on different tabs.Validating if the number of items displayed are correct in each of the tab
    5. FullCheckOutTest - Navigate to TShirt Page from Landing Page & add an item to the cart.Validating if the checkout process is complete without any issues
  
  # TestReport
  Once the tests are executed, the html test results will be present in this folder 
  
  # The test mentioned in 3.a in the assignment was not attempted as enabling the Filter in WomensPage left the application hanging for a long time. So its not a valid scenario     for test automation
  
  # testng.xml
  Grouping of all tests to be executed as part of the test.
  
  # Config.properties:
  Good practice to keep all the dynamic part of the framework (like application URL, driverpath etc..) in a properties file so it can be changed as and when needed

# Pre-Requisites for this Framework
  Gradle - Download the latest gradle version, update the homepath in system variables. Ensure command "gradle -v" gives the installed gradle version in command prompt
  Browser Drivers - Download the necessary drivers(chromedriver, firefoxdriver etc..) needed for execution and update the path in config.properties file
  Dependent JAR files - No need to download the dependent JAR files(Selenium,ExtentReports, TestNG) etc, as they would be downloaded automatically as they are configured in                               build.gradle file
  
  # Execute the Tests - Follow the below steps to execute the tests:
    1. Ensure all the above pre-requisites are met.
    2. If the browser needs to be changed, it can be updated in the testng.xml file
    3. Currently the configuration is set for parallel execution, but if this needs to be changed, it can be done by updating testng.xml file
    4. Execute the testng.xml file by using Run or Debug command & the tests will be executed
    5. Once the tests are executed, the html results will be available in the TestReport folder
