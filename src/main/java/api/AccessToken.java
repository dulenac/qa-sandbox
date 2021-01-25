package api;

import api.models.AccessTokenModel;
import io.restassured.RestAssured;
import io.restassured.http.ContentType;

public class AccessToken {

    public static String userToken = getAccessTokenForUser("decoderkg@gmail.com", "dtodorovickg");

    public static final String getAccessTokenForUser(String username, String password) {
        return RestAssured.given()
                .contentType(ContentType.JSON)
                .body("{\"email\":\"" + username + "\",\"password\":\"" + password + "\"}")
                .when().post("https://qa-sandbox.apps.htec.rs/api/users/login")
                .as(AccessTokenModel.class).getToken();
    }

}
