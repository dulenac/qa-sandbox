# QA-SANDBOX exam test | HTEC Group

## DESCRIPTION
This is Selenium test writen in JAVA drived by Junit.

Test checks if any 'Use case' already created and delete them. This is done by API(using REST ASSURED).

Test login and goes thru the part of HTEC QA-sandbox app UI and creates 4 use cases in 'Use cases' section.
'Use cases' are created with random generated strings and all of 'Use cases' are marked as 'Automated'.
After 'Use cases' creation, test edits all 'Use cases' fields by replacing it with string "_**This field previously had:**_ " +
no. of characters in the previous string of each field + "_**characters**_".

### Prerequisite
Before you begin, ensure you have met the following requirements:

- JAVA 1.8 or higher
- Maven 3.6.3
- Junit 4.13.1
- ChromeDriver 87.0.4280.88
- Chrome browser 87.0.4280.141
- Allure report framework

## INSTRUCTIONS
To run this test follow these steps:
1. Clone code of this repo with Git to your local machine
2. Build project using Maven with 'Skip Test' argument:
`mvn clean install -DskipTests`
3. In class /src/main/java/util/DriverCreation go to 'createChromeDriver' method in line 46. and set path to your local
ChromeDriver location (System.setProperty("webdriver.chrome.driver", "**pathToYourChromdriverLocation**");)
4. In test class /src/test/java/T001LoginIntoAppTest set username and password of my registered account in line 37.
Username and password are sent in comment of my exam.
6. Open /src/test/java/T001LoginIntoAppTest class and run test with `mvn clean install`
7. To see generated allure report run `allure serve` in /home/path/to/project/target/ Generated allure report opens in
default browser tab.

## Contact
If you want to contact me you can reach me at decoderkg@gmail.com