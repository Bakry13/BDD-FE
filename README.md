[![HitCount](https://hits.dwyl.com/Bakry13/PlaywrightFramework.svg?style=flat-square)](http://hits.dwyl.com/Bakry13/PlaywrightFramework)
# BDD Framework

*- This project is a base project to build a solid test automation framework using selenium test automation tool and java programming language.*

*- API testing is added to the project using Rest Assured automation libraries.*

*- You can use this framework to be a start point for your test automation project to write your automated test cases.*

*- You can find more details in selenium official website documentation:*
https://www.selenium.dev/documentation/

## `Preparation:`

### A. Pre-requirements:

#### 1- Download and install latest JDK through the below link
https://www.oracle.com/eg/java/technologies/downloads/

#### 2- Download and install IntelliJ throw the below link
https://www.jetbrains.com/idea/download/?section=windows

#### 3- Download and install latest nodejs through the below link (to use allure report)
https://nodejs.org/en/download

### B. Project readiness

#### 1- Clone the project

#### 2- Run the below command to install the required dependencies

        mvn clean install

#### 3- Run the below command to be able to use allure report

        npm install -g allure-commandline

## `Features:`

### A. Usage of Selenium, Rest Assured Libraries:

#### 1- Waits and timeout adjustment
* Implicitly wait across the project
* Explicitly wait

#### 2- Screenshots
* Ability to take screenshot on specific step

#### 3- Parallel execution using Selenium Grid
* Adjust remote execution using Selenium Grid

#### 4- API tests
* Using Rest Assured libraries to apply API testing
* Adding usable API URLs
* Applying api tests with different methods using simple examples

#### 5- Tests examples
* Simple examples of test cases scripts using some options like "annotations, tags, ..."

### B. Extra features:

#### 1- Page Object Model design pattern
* Separating pages contents in different modules to enhance readability and maintainability

#### 2- Project structure adjustment to modules
* Dividing the project into modules according to its functionality and usage

#### 3- Using data driven framework
* Separating test data to external files to enhance readability and maintainability
* Reading from different types of files (json format, csv, Excel sheets and properties files)

#### 4- Running in different environments
* Adding an option to pass the environment value through CLI
* Adjustment of the baseURL in code and config file according to the running environment

#### 5- Database connection
* Adding a usable module for mysql DB connection using JDBC library

#### 6- Handling different languages
* Adding a simple technique to run the test cases in different language

#### 7- Allure report
* Adding allure report with more analytics and charts options to enhance readability and visibility to the test report
* Adjusting the report to attach (screenshots, videos and console logs)

#### 8- Extent report
* Adding extent report with more analytics and charts options to enhance readability and visibility to the test report
* Adjusting the report to attach (screenshots and videos)
* Making the report customized with the ability to use Spark or HTML report
* Integrate Extent report with cucumber using testNG-cucumber adapter library and plugin

#### 9- Using BDD framework
* Adding the ability to apply BDD test automation framework using cucumber tool
* Adjustment for cucumber run (feature files, steps and test runner)
* Adding cucumber report for logging the test results
* Adding a simple example of BDD tests

#### 10- Cross Browsing
* Adding the ability to run different types of browsers like (Chrome, Firefox and Edge)
* Adjustment the framework to run them sequentially or in parallel

#### 11- Hooks
* Running before and after scenarios hooks for repetitive actions per browser

#### 12- TestNG features
* Using testNG test runner library to arrange test cases by integrating it to cucumber

#### 13- Using Docker
* Adding the ability to run selenium grid on docker containers (Hub-Nodes mode)
* Adding the ability to run selenium grid using docker compose file (docker mode)

#### 14- BrowserStack connection
* Adding the ability to run test cases on different devices and browsers on BrowserStack

#### 15- Serialization and Deserialization
* Using serialization and deserialization in APIs tests

## `Contents:`

### A. Folders and directories:

#### 1- main/java/utilities/actions/:
* APIActions: General methods related to API
* BrowserActions: General methods related to handling browser
* DBActions: General methods for connecting to DB using JDBC library
* ElementActions: General methods related to handling web elements

#### 2- main/java/utilities/readers/:
* ExcelReader: to read from Excel sheets
* JsonReader: to read from json files
* PropertiesReader: to read from properties files

#### 3- main/utilities/:
* Assertions: contains different types of assertions
* AWS: to connect to AWS services
* BatchRunner: to run batch files
* ConfigUtil: to collect all configurations that are included in the config file
* Hooks: to contain all needed cucumber hooks
* Paths: to contain all used paths
* Screenshots: to take screenshots if needed
* TestBase: to handle webDrivers and its general methods

#### 4- main/resources/:
* Config.properties: contains general project configurations
* createSeleniumGridComponents.bat: contains Selenium Grid commands to set up its components
* createSeleniumGridContainers.bat: contains Selenium Grid commands to set up its docker containers
* selenium-server.jar: Selenium library for running Selenium Grid in (Hub-Nodes mode)

#### 5- test/java/api/endpoints/:
* All APIs endpoints methods
* All APIs extraction using deserialization

#### 6- test/java/api/features/:
* Cucumber features which contain test scenarios related to API

#### 7- test/java/api/stepDefinition/:
* Cucumber steps which contain the implementation of test scenarios related to API

#### 8- test/java/ui/features/:
* Cucumber features which contain test scenarios related to frontend

#### 9- test/java/ui/stepDefinition/:
* Cucumber steps which contain the implementation of test scenarios related to frontend

#### 10- test/java/ui/pages/:
* All pages which use page object model

#### 10- test/java/ui/pages/:
* All pages which use page object model

#### 12- test/resources/testData/:
* All test data files

#### 13- test/testRunner/:
* FailedScenariosRunner: cucumber test runner for failed scenarios
* TestRunner: cucumber test runner
* TestNG.xml: xml config file to contains tests that will run and its configurations

#### 14- target/:
* default path for test result files

#### 15- tests-output/:
* allure-report: generated allure report in html view
* allure-file: generated allure report in json files
* DefaultReport: default cucumber report
* HTMLReport: extent HTML report
* SparkReport: extent spark report
* rerun.txt: failed cucumber scenarios to be used to rerun later

### B. Project configuration files:

#### 1- docker-compose.yml:
* docker compose file which contains all containers images, components, ports and its environment

#### 2- browserstack.yml:
* config file which contains all configurations needed (devices, OS, Browsers, ...) to connect to BrowserStack

#### 3- pom.xml:
* Detailed Installed dependencies

#### 4- .gitignore:
* All files and folders that needs to be excluded from pushing to the version control

#### 5- .github/workflows/regression.yml:
* Configurations and commands for  running tests in github actions pipeline


## `How to run?`

### A. Running normal test cases:

#### 1- Use direct command as below:

        mvn test

#### 2- To specify specific tags:

        mvn test -Dcucumber.filter.tags="@sanity and @FERegression"

### B. Running using docker compose:

        docker-compose -f docker-compose.yml up --scale chrome=2 --scale edge=0 --scale firefox=0 -d

### C. Generating/ Opening Allure report:

#### 1- Generate the report:

        allure generate ${allure-results-path} -o ${allure-report-path} --clean

#### 2- Open the report:

        allure open ${allure-results-path}

## `Project Structure:`
*The below is a package diagram for the implemented project structure "Files and folders"*

![Screenshot](BDDFramework.JPG)

## `General instructions and guidelines:`

1- Specify files and tags that should be run from runner class under Test Runner package 

2- Configure TestNG.xml file for browser to run the file as testNG file

3- Configure pom.xml file for test environment to run the file as testNG file

4- Every scenario should have its id in its name

5- Every feature file should have tag with its US id

6- Every feature should have 3 files (feature file - step def. - page)

7- Pages should hold locators, strings, actions and assertions and inherits from ElementActions

8- Feature files should have business scenarios

9- Step def should have technical steps and inherits from pages

10- Assertions uses assertion class

11- We locate element using method in element actions class (getElement())

12- Variables and methods should start with small letters

13- Write locators, tickets, scenario steps and step def methods in the order of the page under test

14- Step def class should end with _StepDef

15- Do not assert on existence of a certain element if we will assert on its text

16- Do not write any methods if you will not use it

17- Do not make more than 2 Then in the scenario except view page scenario

18- For every api we create feature file with its name, endpoint class, extraction class and step def