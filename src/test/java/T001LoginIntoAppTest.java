import api.UseCaseList;
import org.junit.Before;
import org.junit.Test;
import pop.Login;
import pop.mainView.DashboardView;
import pop.mainView.useCaseView.CreateUseCaseView;
import pop.mainView.useCaseView.UseCaseView;
import util.DriverCreation;

import java.util.ArrayList;
import java.util.List;

/**
 * This test delete existing use cases by API, logs in qa-sandbox app, create 4 use cases by filling up input fields with
 * random created strings and edit all filled input fields with text "This field previously had: " + no. of characters in
 * previous string
 */
public class T001LoginIntoAppTest extends DriverCreation {


    @Before
    public void deleteAllUseCases() {

        UseCaseList.deleteAllUseCases();


    }

    @Test
    public void loginIntoSandbox() {


        openUrl("https://qa-sandbox.apps.htec.rs/login");

        Login login = new Login();

        DashboardView dashboardView = login.setUserName("decoderkg@gmail.com").setPassword("dtodorovickg").submit();

        UseCaseView useCaseView = dashboardView.selectUseCases();

        List<String> title = new ArrayList<>();
        for (int i = 0; i < 4; i++) {


            CreateUseCaseView createUseCaseView = useCaseView.createUseCase();
            title.add(createRandomString());
            createUseCaseView.setTitle(title.get(i)).setDescription(createRandomString()).setUseCaseAutomated(true)
                    .setExpectedResult(createRandomString()).setTextInUseCase(1, createRandomString()).addStep()
                    .setTextInUseCase(2, createRandomString()).addStep()
                    .setTextInUseCase(3, createRandomString()).submit();
        }

        for (int i = 0; i < title.size(); i++) {

            CreateUseCaseView editUseCaseView = useCaseView.openUseCase(title.get(i));

            editUseCaseView.setTitle("This field previously had: " + editUseCaseView.getNumberOfCharactersFromTitle() + " characters")
                    .setDescription("This field previously had: " + editUseCaseView.getNumberOfCharactersFromDescription() + " characters")
                    .setExpectedResult("This field previously had: " + editUseCaseView.getNumberOfCharactersFromExpectedResult() + " characters")
                    .setTextInUseCase(1, "This field previously had: " + editUseCaseView.getNumberOfCharactersFromStep(1) + " characters")
                    .setTextInUseCase(2, "This field previoysly had: " + editUseCaseView.getNumberOfCharactersFromStep(2) + " characters")
                    .setTextInUseCase(3, "This field previously had: " + editUseCaseView.getNumberOfCharactersFromStep(3) + " characters").submit();


        }


    }

}