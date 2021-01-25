package pop.mainView.useCaseView;

import org.openqa.selenium.By;
import util.Base;

public class CreateUseCaseView extends Base {


    /**
     * This method return locator for input field by 'name'
     *
     * @param arg - 'name' value
     * @return inputTemplateByName locator for input field by 'name'
     */
    private By inputTemplateByName(String arg) {
        return By.xpath(String.format("//input[@name='%s']", arg));
    }


    /**
     * This method return locator for button by 'data-testid'
     *
     * @param arg - 'data-testid' value
     * @return buttonTemplateByDataTestId locator for button by 'data-testid'
     */
    private By buttonTemplateByDataTestId(String arg) {
        return By.xpath(String.format("//button[@data-testid='%s']", arg));
    }


    private By TEXTAREA_DESCRIPTION = By.xpath("//textarea[@name='description']");
    private By AUTOMATED_SWITCH_BUTTON = By.xpath("//input[@name='automated-switch']");
    private By CLICK_AUTOMATED = By.xpath("//div[@class='float-right']//label");

    /**
     * This method check if Use case is automated, 'Automated' switch status
     *
     * @return boolean 'selected'
     */
    private boolean isAutomatedSelected() {
        boolean selected = false;

        String attributeValue = getAttributeValue(AUTOMATED_SWITCH_BUTTON, "value");
        if (attributeValue.contains("true")) {
            selected = true;
        }
        return selected;
    }

    /**
     * This method set 'Automated' switch on or off
     *
     * @param select
     * @return CreateUseCaseView object
     */
    public CreateUseCaseView setUseCaseAutomated(boolean select) {

        boolean automatedStatus = isAutomatedSelected();
        if (select != automatedStatus) {
            click(CLICK_AUTOMATED);
        }
        return this;

    }

    /**
     * This method writes "Title name" in 'Title name input field' on Create use case page
     *
     * @param title - Use case title name
     * @return CreateUseCaseView object
     */
    public CreateUseCaseView setTitle(String title) {

        writeText(inputTemplateByName("title"), title);

        return this;
    }


    /**
     * This method returns the number of characters from 'Use case title input field'
     *
     * @return int number of characters in 'Use case title input field'
     */
    public int getNumberOfCharactersFromTitle() {
        return getNumberOfCharactersFromInput(inputTemplateByName("title"));
    }

    /**
     * This method returns number of characters from 'Use case description input field'
     *
     * @return int number of characters in 'Use case description input field'
     */
    public int getNumberOfCharactersFromDescription() {
        return getNumberOfCharactersFromInput(TEXTAREA_DESCRIPTION);
    }

    /**
     * This method returns number of characters from 'Use case Expected result input field'
     *
     * @return int number of characters from 'Use case Expected result input field'
     */
    public int getNumberOfCharactersFromExpectedResult() {
        return getNumberOfCharactersFromInput(inputTemplateByName("expected_result"));
    }

    /**
     * This method get number of characters in 'Step' field by locator 'inputTemplateByName'
     *
     * @param stepNumber - number of existing step in step list by 'testStepId' value
     * @return int number of characters in 'Step' field
     */
    public int getNumberOfCharactersFromStep(int stepNumber) {
        return getNumberOfCharactersFromInput(inputTemplateByName("testStepId-" + Integer.toString(stepNumber - 1)));
    }

    /**
     * This method count number of characters in input field by 'inputLocator'
     *
     * @param inputLocator - input field locator
     * @return int number of characters in input field
     */
    private int getNumberOfCharactersFromInput(By inputLocator) {

        String a = getElementText(inputLocator);
        int character = a.length();
        return character;

    }

    /**
     * This method writes description in 'Description input field'
     *
     * @param description - text of description
     * @return CreateUseCaseView object
     */
    public CreateUseCaseView setDescription(String description) {
        writeText(TEXTAREA_DESCRIPTION, description);
        return this;
    }

    /**
     * This method writes text in 'Expected result input field'
     *
     * @param expectedResult - text of expected result
     * @return CreateUseCaseView object
     */
    public CreateUseCaseView setExpectedResult(String expectedResult) {
        writeText(inputTemplateByName("expected_result"), expectedResult);
        return this;
    }

    public CreateUseCaseView switchAutomatedUseCase(boolean auto) {


        return this;

    }

    /**
     * This method writes text in 'Step input field'
     *
     * @param useCaseNumber - number of step
     * @param text          - text of the step
     * @return CreateUseCaseView object
     */
    public CreateUseCaseView setTextInUseCase(int useCaseNumber, String text) {
        writeText(inputTemplateByName("testStepId-" + Integer.toString(useCaseNumber - 1)), text);
        return this;
    }

    /**
     * This method add new step in Use case by clicking on Add step button
     *
     * @return CreateUseCaseView object
     */
    public CreateUseCaseView addStep() {
        click(buttonTemplateByDataTestId("add_step_btn"));
        return this;
    }

    /**
     * This method clicks on Submit button
     *
     * @return UseCaseView object
     */
    public UseCaseView submit() {
        click(buttonTemplateByDataTestId("submit_btn"));
        waitForNotVisible(buttonTemplateByDataTestId("submit_btn"));
        return new UseCaseView();
    }

}
