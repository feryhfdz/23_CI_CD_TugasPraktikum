package STARTER.User;

import net.serenitybdd.annotations.Step;
import net.serenitybdd.rest.SerenityRest;

import static net.serenitybdd.rest.SerenityRest.restAssuredThat;

public class DeleteDataPost {
    private static String url = "https://jsonplaceholder.typicode.com/posts/";

    @Step("I set API endpoint for delete data with ID")
    public String setDeleteApiEndPoint() {
        return url + "1"; // Or make ID dynamic based on your scenario
    }

    @Step("I send a DELETE request to the endpoint with a valid ID")
    public void sendDeletePostDataRequest() {
        SerenityRest.given()
                .delete(setDeleteApiEndPoint());
    }

    @Step("I receive a successful response status code 200")
    public void verifyDeleteStatusCode() {
        restAssuredThat(response -> response.statusCode(200));
    }

    @Step("I verify the post data is no longer retrievable using a GET request with the same ID")
    public void verifyPostDataDeleted() {
    }
}
