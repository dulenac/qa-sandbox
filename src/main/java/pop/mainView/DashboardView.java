package pop.mainView;

import org.openqa.selenium.By;
import pop.mainView.useCaseView.UseCaseView;
import util.Base;

public class DashboardView extends Base {

    /**
     * This method return locator for card in dashboardview by cardId
     *
     * @param cardId - 'cardId' value
     * @return selectCardByDataTestId locator for card by 'cardId'
     */
    private By selectCardByDataTestId(String cardId) {
        return By.xpath(String.format("//div[@data-testid='%s']", cardId));
    }

    /**
     * This method select card in dashboard view by clicking it on card
     *
     * @param cardName -
     */
    private void selectCard(String cardName) {

        click(selectCardByDataTestId(cardName));

    }

    /**
     * This method select existing use case in use case view
     *
     * @return UseCaseView object
     */
    public UseCaseView selectUseCases() {

        selectCard("use_cases_card_id");

        return new UseCaseView();
    }


}
