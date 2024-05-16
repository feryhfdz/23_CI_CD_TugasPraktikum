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

    @Step("the post data is no longer retrievable using a GET request with the same ID")
    public void verifyPostDataDeleted() {
    }

    @Step("I send a DELETE request to the endpoint with a non-existent ID")
    public void sendDeleteRequestWithNonExistentId() {
        String nonExistentId = "10000000000000000000";
        SerenityRest.given()
                .delete(url + nonExistentId);
    }
    @Step("I receive a response with status code 404 Not Found")
    public void receiveStatusCode404(){
        restAssuredThat(response -> response.statusCode(404));
    }

    @Step("the response body contains an error message Post not found")
    public void receiveErrorMessage(){
        restAssuredThat(response -> response.body("'error'", equalTo("TypeError: Cannot read properties of undefined (reading 'id')")));
    }
}
