# Quality Assurance Integral Project

This project presents automated regression tests for a technical test written in JAVA using Maven and the following dependencies: 

 - Selenium webdriver
 - webdrivermanager
 - TestNG

## Architecture of the project

This project has four directories (pages, tests, suites, and utility) that have JAVA or XML classes.

### Utility

This directory has the generic classes that we use in a routine:

 - **Messages**: This file centralizes all the output messages that we use in the test cases.
 - **Locators**: This file centralizes all the locators of the HTML elements that we use in the test cases.
 - **Base**: This file contains the encapsulation of selenium methods to interact with the components of the graphical interface of web pages.

### Suites

This directory has the suite case in XML format. the testng.xml file orchestrate all test cases defining parameters and tests necessary for each of them.

### Tests

This directory has all the specific functionalities. In all those classes, the * test * tag is validating test behaviors, the *beforetest* prepare the test environment and the *aftertest* close the webdriver and each web pages opened in tests.

### Pages

This directory has all the tests separated by the page to which each of it corresponds.


## Run the project by Eclipse IDE

To run this project you need to follow the next steps

- You could import the TestNG library into the project (optional)
- You must update the Maven project
- You could run the project as TestNG Suite running the testng.xml file
- You could run the project as Maven running the whole project as a Maven test.

## Run the project by command line

To run this project you need to follow the next steps

- Clone this repository
- Open a terminal into the project
- run the command line below
```bash
mvn dependency:resolve
mvn dependency:resolve-plugins
mvn clean install
```
## Run the project by CircleCI

To run this project you to follow the next steps:

- Clone this repository
- Attach it into a CircleCI project
- Change the browser parameter to `Chrome CircleCI` in the `src/suites/testng.xml` file

And CircleCI recognize the file `.circleci/config.yml` to execute the test by a pipeline in a docker container.

## Run the project by Jenkins

To run this project you to follow the next steps:

- Clone this repository
- Create a job into Jenkins
- Attach the file `jenkinsfile` 

And Jenkins execute the test by a pipeline running the test every night at 11PM.

#### Configurate the TestNg library into Ecllipse IDE

1. Locate the ‘Help’ option on the menu bar and click it.
2. Select the option ‘Install New Software’.
3. Click the ‘Add’ button on the appeared installation box.
4. You will see an ‘Add Repository’ dialog box, where you need to provide the Name and Location.
5. Type ‘TestNG’ in the Name field and ‘http://beust.com/eclipse’ in the Location field.
6. Click ‘OK’ button.
7. The given URL will be populated on the “Work with” field.
8. Check the box next to TestNG and click ‘Next’
9. Keep clicking ‘Next’ until you reach a License Agreement dialog box.
10. Accept the license agreement and click ‘Finish’.
11. This will begin the installation process. Wait until it gets finished.
12. In case you get a security warning pop-up, click OK. Else, skip this step.
13. You will get a ‘Software Updates’ dialog box prompting you to restart Eclipse. Click ‘Yes’.
14. Once your Eclipse has been restarted, you can see TestNG has been successfully installed. For this, click Window->Preferences and you can see TestNG included in the list.