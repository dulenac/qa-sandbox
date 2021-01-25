package api;

import api.models.UseCaseModel;
import io.restassured.RestAssured;
import io.restassured.response.Response;

public class UseCaseList extends AccessToken {

    private static UseCaseModel[] getNumberOfUseCases() {
        UseCaseModel[] response = new UseCaseModel[0];
        try {

            response = RestAssured.given().header("Authorization", "Bearer " + userToken)
                    .when().get("https://qa-sandbox.apps.htec.rs/api/usecases/all").then().extract().as(UseCaseModel[].class);
        } catch (Exception e) {
            System.out.println("UseCaseModel is empty");
        }


        return response;

    }

    public static void deleteAllUseCases() {

        UseCaseModel[] useCaseModels = getNumberOfUseCases();

        for (int i = 0; i < useCaseModels.length; i++) {
            int useCaseId = useCaseModels[i].getUsecase_id();
            deleteUseCase(useCaseId);

        }


    }

    public static void deleteUseCase(int useCaseId) {

        RestAssured.given().header("Authorization", "Bearer " + userToken)
                .when().delete("https://qa-sandbox.apps.htec.rs/api/usecases/usecase/" + Integer.toString(useCaseId))
                .then().statusCode(200);

    }

}
