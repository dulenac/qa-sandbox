package util;

import org.junit.Rule;
import org.junit.rules.TestWatcher;
import org.junit.runner.Description;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.apache.commons.lang3.RandomStringUtils;

import java.util.concurrent.ThreadLocalRandom;


public class DriverCreation {

    private static WebDriver _driver;

    public static WebDriver getDriver() {
        return _driver;
    }

    /**
     * This method create random string from 5 to 15 characters
     *
     * @return String random
     */
    public String createRandomString() {
        int randomNum = ThreadLocalRandom.current().nextInt(5, 15 + 1);

        String random = RandomStringUtils.randomAlphabetic(randomNum);

        return random;
    }

    /**
     * This method open url in browser with coosen driver
     *
     * @param url
     */
    public void openUrl(String url) {
        _driver.get(url);
    }


    private void createChromeDriver() {

        System.setProperty("webdriver.chrome.driver", "/Users/dulenac/chromedriver");
        _driver = new ChromeDriver();


    }


    @Rule
    public TestWatcher watchman = new TestWatcher() {

        @Override
        protected void starting(Description description) {
            createChromeDriver();
            _driver.manage().window().maximize();
        }

        @Override
        protected void failed(Throwable e, Description description) {
        }

        @Override
        protected void succeeded(Description description) {
        }

        @Override
        protected void finished(Description description) {
            _driver.quit();
        }
    };

}
