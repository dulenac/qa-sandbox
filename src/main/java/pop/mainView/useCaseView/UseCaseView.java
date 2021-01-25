package pop.mainView.useCaseView;

import org.openqa.selenium.By;
import util.Base;

public class UseCaseView extends Base {

    private By buttonTemplateByDataTestId(String arg) {
        return By.xpath(String.format("//a[@data-testid='%s']", arg));
    }

    private By selectItem(String item) {
        return By.xpath(String.format("//a[text()='%s']", item));
    }

    /**
     * This method clicks on 'Create use case' button
     *
     * @return CreateUseCaseView object
     */
    public CreateUseCaseView createUseCase() {
        click(buttonTemplateByDataTestId("create_use_case_btn"));
        return new CreateUseCaseView();
    }

    /**
     * This method open existing use case in edit mode by clicking on it
     *
     * @param useCaseName
     * @return CreateUseCaseView object
     */
    public CreateUseCaseView openUseCase(String useCaseName) {
        waitForVisible(selectItem(useCaseName));
        click(selectItem(useCaseName));
        waitForNotVisible(selectItem(useCaseName));

        return new CreateUseCaseView();
    }
}
