package util;

import org.openqa.selenium.By;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class Base extends DriverCreation {


    /**
     * This method  clicks on element by locator
     *
     * @param locator
     */
    public void click(By locator) {
        waitForVisible(locator);
        getDriver().findElement(locator).click();

    }

    /**
     * This method writes text in element by locator
     *
     * @param locator
     * @param keys
     */
    public void writeText(By locator, String keys) {
        waitForVisible(locator);
        clear(locator);
        getDriver().findElement(locator).sendKeys(keys);
    }

    /**
     * This method waits for element to be visible
     *
     * @param locator
     */
    public void waitForVisible(By locator) {

        WebDriverWait wait = new WebDriverWait(getDriver(), 30);

        wait.until(ExpectedConditions.visibilityOfElementLocated(locator));

    }

    /**
     * This method waits for element to be invisible
     *
     * @param locator
     */
    public void waitForNotVisible(By locator) {

        WebDriverWait wait = new WebDriverWait(getDriver(), 30);

        wait.until(ExpectedConditions.invisibilityOfElementLocated(locator));

    }

    /**
     * This method get text from element by locator
     *
     * @param locator
     * @return String value of the selected element
     */
    public String getElementText(By locator) {
        waitForVisible(locator);
        return getDriver().findElement(locator).getAttribute("value");
    }

    public String getAttributeValue(By locator, String attribute) {

        return getDriver().findElement(locator).getAttribute(attribute);
    }

    /**
     * This method clears the value of selected element
     *
     * @param locator
     */
    public void clear(By locator) {

        getDriver().findElement(locator).clear();
    }


}
