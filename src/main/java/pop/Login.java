package pop;

import org.openqa.selenium.By;
import pop.mainView.DashboardView;
import util.Base;

public class Login extends Base {

    private By INPUT_USERNAME = By.xpath("//input[@name='email']");

    private By INPUT_PASSWORD = By.xpath("//input[@name='password']");

    private By BUTTON_SUBMIT = By.xpath("//button[@data-testid='submit_btn']");

    private By BUTTON_LOGIN = By.xpath("//a[@href='/login']");

    /**
     * This method clicks on 'Login' button
     *
     * @return Login object
     */
    public Login openLoginDialog() {
        click(BUTTON_LOGIN);
        return this;
    }

    /**
     * This method writes text in 'username input field'
     *
     * @param userName - String username
     * @return Login object
     */
    public Login setUserName(String userName) {
        writeText(INPUT_USERNAME, userName);

        return this;
    }

    /**
     * This method writes text in 'password input field'
     *
     * @param userName - String password
     * @return Login object
     */
    public Login setPassword(String userName) {
        writeText(INPUT_PASSWORD, userName);
        return this;
    }

    /**
     * This method clicks on 'Submit' button
     *
     * @return DashboardView object
     */
    public DashboardView submit() {
        click(BUTTON_SUBMIT);
        return new DashboardView();
    }

}
